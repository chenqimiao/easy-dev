package com.github.chenqimiao.flowengine.check;


import com.github.chenqimiao.flowengine.BaseChecker;
import com.github.chenqimiao.flowengine.FlowContext;
import com.github.chenqimiao.flowengine.context.SayHelloContext;
import com.github.chenqimiao.flowengine.request.SayHelloRequest;
import com.github.chenqimiao.flowengine.response.SayHelloResponse;

/**
 * @author Qimiao Chen
 * @date 2022-10-13 17:10
 **/
public class SayHelloParamChecker implements BaseChecker<SayHelloContext,
        SayHelloRequest, SayHelloResponse> {


    @Override
    public void check(FlowContext<SayHelloContext, SayHelloRequest, SayHelloResponse> flowContext) {

        SayHelloRequest request = flowContext.getRequest();

        if (!"Hello".equals(request.getMsg())) {
            throw new RuntimeException("The behavior does not meet the requirement");
        }
    }
}
