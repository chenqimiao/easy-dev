package com.github.chenqimiao.statemachine.processor;

import com.github.chenqimiao.statemachine.BaseProcessor;
import com.github.chenqimiao.statemachine.context.SayHelloContext;

/**
 * @author Qimiao Chen
 * @date 2022-10-13 15:30
 **/
public class SayHelloProcessor implements BaseProcessor<SayHelloContext> {

    @Override
    public void execute(SayHelloContext context) {
        System.out.println("Hello world!");
    }
}
