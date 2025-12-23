package com.github.chenqimiao.engine;

import com.github.chenqimiao.flowengine.EngineFlow;
import com.github.chenqimiao.flowengine.context.SayHelloContext;
import com.github.chenqimiao.flowengine.flow.EngineFlowConfig;
import com.github.chenqimiao.flowengine.request.SayHelloRequest;
import com.github.chenqimiao.flowengine.response.SayHelloResponse;

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
