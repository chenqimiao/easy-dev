package com.github.chenqimiao.statemachine;

import lombok.Data;

@Data
public class FlowContext<C,R,P> {

    private C context;

    private R request;

    private P result;

    public void initContext(Class<C> tClass){
        try {
            this.context = tClass.newInstance();
        } catch (Exception e) {
            throw new RuntimeException("create context error, class name : " + tClass.getName());
        }
    }

}
