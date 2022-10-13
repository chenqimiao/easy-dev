package com.github.chenqimiao.engine;

import com.github.chenqimiao.statemachine.EngineFlow;
import com.github.chenqimiao.statemachine.context.SayHelloContext;
import com.github.chenqimiao.statemachine.flow.EngineFlowConfig;
import com.github.chenqimiao.statemachine.request.SayHelloRequest;
import com.github.chenqimiao.statemachine.response.SayHelloResponse;

/**
 * @author Qimiao Chen
 * @date 2022-10-13 15:45
 **/
public class Test {

    public static void main(String[] args) {
        EngineFlow<SayHelloContext, SayHelloRequest, SayHelloResponse> engineFlow = EngineFlowConfig.createSayHelloEngineFlow();


        SayHelloRequest sayHelloRequest = new SayHelloRequest();
        sayHelloRequest.setMsg("Hello");
        SayHelloResponse response = engineFlow.start(sayHelloRequest);

        System.out.println(response);
    }
}
