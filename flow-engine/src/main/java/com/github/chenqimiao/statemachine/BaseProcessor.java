package com.github.chenqimiao.statemachine;

public interface BaseProcessor<C> {

    //是否执行当前execute方法
    default boolean canExecute(C context){
        return true;
    }

    void execute(C context);

    //执行完成后是否需要跳出循环，后续handler不会执行
    default boolean breakExecute(C context){
        return false;
    }
}
