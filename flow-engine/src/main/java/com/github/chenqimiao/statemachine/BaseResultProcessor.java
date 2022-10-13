package com.github.chenqimiao.statemachine;

public interface BaseResultProcessor<C,P> {

    P execute(C context);

}
