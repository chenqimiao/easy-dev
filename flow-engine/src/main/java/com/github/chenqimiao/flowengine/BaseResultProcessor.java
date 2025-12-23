package com.github.chenqimiao.flowengine;

public interface BaseResultProcessor<C,P> {

    P execute(C context);

}
