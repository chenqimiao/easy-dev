package com.github.chenqimiao.statemachine.impl;

import com.github.chenqimiao.statemachine.State;
import com.github.chenqimiao.statemachine.StateMachine;
import com.github.chenqimiao.statemachine.Transition;
import com.github.chenqimiao.statemachine.Visitor;


/**
 * SysOutVisitor
 *
 */
public class SysOutVisitor implements Visitor {

    @Override
    public String visitOnEntry(StateMachine<?, ?, ?> stateMachine) {
        String entry = "-----StateMachine:"+stateMachine.getMachineId()+"-------";
        System.out.println(entry);
        return entry;
    }

    @Override
    public String visitOnExit(StateMachine<?, ?, ?> stateMachine) {
        String exit = "------------------------";
        System.out.println(exit);
        return exit;
    }

    @Override
    public String visitOnEntry(State<?, ?, ?> state) {
        StringBuilder sb = new StringBuilder();
        String stateStr = "State:"+state.getId();
        sb.append(stateStr).append(LF);
        System.out.println(stateStr);
        for(Transition transition: state.getTransitions()){
            String transitionStr = "    Transition:"+transition;
            sb.append(transitionStr).append(LF);
            System.out.println(transitionStr);
        }
        return sb.toString();
    }

    @Override
    public String visitOnExit(State<?, ?, ?> visitable) {
        return "";
    }
}
