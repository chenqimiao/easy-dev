package com.github.chenqimiao.statemachine;

public interface BaseChecker<C,R,P> {

    void check(FlowContext<C,R,P> context);
}
