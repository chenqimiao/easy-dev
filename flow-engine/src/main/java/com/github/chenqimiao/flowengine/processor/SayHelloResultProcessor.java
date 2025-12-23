package com.github.chenqimiao.flowengine.processor;

import com.github.chenqimiao.flowengine.BaseResultProcessor;
import com.github.chenqimiao.flowengine.context.SayHelloContext;
import com.github.chenqimiao.flowengine.response.SayHelloResponse;

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
