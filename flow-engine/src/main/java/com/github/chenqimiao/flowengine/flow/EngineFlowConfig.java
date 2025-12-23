package com.github.chenqimiao.flowengine.flow;

import com.github.chenqimiao.flowengine.EngineFlow;
import com.github.chenqimiao.flowengine.check.SayHelloParamChecker;
import com.github.chenqimiao.flowengine.context.SayHelloContext;
import com.github.chenqimiao.flowengine.processor.SayHelloProcessor;
import com.github.chenqimiao.flowengine.processor.SayHelloResultProcessor;
import com.github.chenqimiao.flowengine.request.SayHelloRequest;
import com.github.chenqimiao.flowengine.response.SayHelloResponse;

/**
 * @author Qimiao Chen
 * @date 2022-10-13 15:30
 **/
public class EngineFlowConfig {


    private static final SayHelloParamChecker SAY_HELLO_PARAM_CHECKER = new SayHelloParamChecker();

    private static final SayHelloProcessor SAY_HELLO_PROCESSOR = new SayHelloProcessor();

    private static final SayHelloResultProcessor SAY_HELLO_RESULT_PROCESSOR = new SayHelloResultProcessor();



    public static EngineFlow<SayHelloContext, SayHelloRequest, SayHelloResponse> createSayHelloEngineFlow() {
        EngineFlow.EngineFlowBuilder<SayHelloContext, SayHelloRequest, SayHelloResponse> builder = EngineFlow.builder();
        return builder
                .addLastChecker(SAY_HELLO_PARAM_CHECKER) //check
                .addLastProcessor(SAY_HELLO_PROCESSOR) // process
                .resultProcessor(SAY_HELLO_RESULT_PROCESSOR) //wrap result
                .flowScene("say hello")
                .contextClass(SayHelloContext.class)
                .build();
    }
}
