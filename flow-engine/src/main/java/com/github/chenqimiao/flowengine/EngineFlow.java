package com.github.chenqimiao.flowengine;

import com.alibaba.fastjson2.JSONObject;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Data
@Slf4j
public class EngineFlow<C,R,P> {


    private List<BaseProcessor<C>> baseProcessors;

    private List<BaseChecker<C,R,P>> baseCheckers;

    private BaseResultProcessor<C,P> baseResultProcessor;

    private String flowScene;//场景

    private Class<C> contextClass;

    private Function<Exception, P> exceptionHandler;

    public void setContextClass(Class<C> contextClass) {
        this.contextClass = contextClass;
    }

    public static EngineFlowBuilder builder() {
        return new EngineFlowBuilder();
    }

    public P start(R request) {

        FlowContext<C,R,P> flowContext = new FlowContext<>();
        flowContext.setRequest(request);
        flowContext.initContext(contextClass);

        if (baseProcessors == null) {
            throw new RuntimeException("handlers can't be null");
        }

        try {
            check(flowContext);
        } catch (Exception e) {
            if (exceptionHandler != null) {
                log.warn("[{}]: check error, msg is [{}], context is [{}]", getFlowScene(), e.getMessage(), JSONObject.toJSONString(flowContext), e);
                return exceptionHandler.apply(e);
            } else {
                throw e;
            }
        }
        for (BaseProcessor<C> baseProcessor : baseProcessors) {
            try {
                if (baseProcessor.canExecute(flowContext.getContext())) {
                    baseProcessor.execute(flowContext.getContext());
                }
                if (baseProcessor.breakExecute(flowContext.getContext())) {
                    break;
                }
            } catch (Exception e) {
                log.error("[{}]: exec error, msg is [{}], context is [{}]", getFlowScene(), e.getMessage(), JSONObject.toJSONString(flowContext), e);
                if (exceptionHandler != null) {
                    return exceptionHandler.apply(e);
                } else {
                    throw e;
                }
            }
        }

        Optional.ofNullable(baseResultProcessor).ifPresent(resultProcessor -> {
            flowContext.setResult(resultProcessor.execute(flowContext.getContext()));
        });

        return flowContext.getResult();
    }


    private void check(FlowContext<C,R,P> context) {
        if (CollectionUtils.isNotEmpty(baseCheckers)) {
            for (BaseChecker<C,R,P> checker : baseCheckers) {
                checker.check(context);
            }
        }
    }

    public static class EngineFlowBuilder<C, R, P> {

        private final List<BaseProcessor<C>> baseProcessors = new ArrayList<>();

        private final List<BaseChecker<C,R,P>> baseCheckers = new ArrayList<>();

        private BaseResultProcessor<C,P> baseResultProcessor;

        private String flowScene;

        private Class<C> contextClass;

        private Function<Exception,P> exceptionHandler;

        public EngineFlowBuilder<C,R,P> addLastProcessor(BaseProcessor<C> baseProcessor) {
            baseProcessors.add(baseProcessor);
            return this;
        }

        public EngineFlowBuilder<C,R,P> addLastChecker(BaseChecker<C,R,P> baseChecker) {
            baseCheckers.add(baseChecker);
            return this;
        }

        public EngineFlowBuilder<C,R,P> resultProcessor(BaseResultProcessor<C,P> baseResultProcessor) {
            this.baseResultProcessor = baseResultProcessor;
            return this;
        }

        public EngineFlowBuilder<C,R,P> flowScene(String flowScene) {
            this.flowScene = flowScene;
            return this;
        }

        public EngineFlowBuilder<C,R,P> contextClass(Class<C> cClass) {
            this.contextClass = cClass;
            return this;
        }

        public EngineFlowBuilder<C,R,P> exceptionHandler(Function<Exception,P> exceptionHandler){
            this.exceptionHandler = exceptionHandler;
            return this;
        }

        public EngineFlow<C,R,P> build() {
            EngineFlow<C,R,P> engineFlow = new EngineFlow<>();
            engineFlow.setBaseProcessors(baseProcessors);
            engineFlow.setBaseCheckers(baseCheckers);
            engineFlow.setBaseResultProcessor(baseResultProcessor);
            engineFlow.setFlowScene(flowScene);
            engineFlow.setContextClass(contextClass);
            engineFlow.setExceptionHandler(exceptionHandler);
            return engineFlow;
        }

    }

}
