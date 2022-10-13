package com.github.chenqimiao.statemachine.impl;

import com.github.chenqimiao.statemachine.State;

import java.util.Map;

/**
 * StateHelper
 *
 */
public class StateHelper {
    public static <S, E, C> State<S, E, C> getState(Map<S, State<S, E, C>> stateMap, S stateId){
        State<S, E, C> state = stateMap.get(stateId);
        if (state == null) {
            state = new StateImpl<>(stateId);
            stateMap.put(stateId, state);
        }
        return state;
    }
}
