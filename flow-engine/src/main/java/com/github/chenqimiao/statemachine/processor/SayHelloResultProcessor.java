package com.github.chenqimiao.statemachine.processor;

import com.github.chenqimiao.statemachine.BaseResultProcessor;
import com.github.chenqimiao.statemachine.context.SayHelloContext;
import com.github.chenqimiao.statemachine.response.SayHelloResponse;

/**
 * @author Qimiao Chen
 * @date 2022-10-13 15:30
 **/
public class SayHelloResultProcessor implements BaseResultProcessor<SayHelloContext, SayHelloResponse> {
    @Override
    public SayHelloResponse execute(SayHelloContext context) {

        return new SayHelloResponse();
    }
}
