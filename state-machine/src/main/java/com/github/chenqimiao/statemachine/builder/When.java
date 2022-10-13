package com.github.chenqimiao.statemachine.builder;


import com.github.chenqimiao.statemachine.Action;

/**
 * When
 *
 */
public interface When<S, E, C>{
    /**
     * Define action to be performed during transition
     *
     * @param action performed action
     */
    void perform(Action<S, E, C> action);
}
