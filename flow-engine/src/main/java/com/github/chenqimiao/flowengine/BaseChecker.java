package com.github.chenqimiao.flowengine;

public interface BaseChecker<C,R,P> {

    void check(FlowContext<C,R,P> context);
}
