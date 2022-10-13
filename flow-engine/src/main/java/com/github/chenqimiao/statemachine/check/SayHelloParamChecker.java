package com.github.chenqimiao.statemachine.check;


import com.github.chenqimiao.statemachine.BaseChecker;
import com.github.chenqimiao.statemachine.FlowContext;
import com.github.chenqimiao.statemachine.context.SayHelloContext;
import com.github.chenqimiao.statemachine.request.SayHelloRequest;
import com.github.chenqimiao.statemachine.response.SayHelloResponse;

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
