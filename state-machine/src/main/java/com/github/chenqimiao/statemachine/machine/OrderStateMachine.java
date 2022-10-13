package com.github.chenqimiao.statemachine.machine;

import com.github.chenqimiao.statemachine.Action;
import com.github.chenqimiao.statemachine.Condition;
import com.github.chenqimiao.statemachine.StateMachine;
import com.github.chenqimiao.statemachine.StateMachineFactory;
import com.github.chenqimiao.statemachine.builder.StateMachineBuilder;
import com.github.chenqimiao.statemachine.builder.StateMachineBuilderFactory;
import com.github.chenqimiao.statemachine.context.OrderStateContext;
import com.github.chenqimiao.statemachine.enums.OrderStateEventEnum;
import com.github.chenqimiao.statemachine.enums.OrderStateEnum;

/**
 * @author Qimiao Chen
 * @date 2022-10-13 17:34
 **/
public class OrderStateMachine {

    private static StateMachineBuilder<OrderStateEnum, OrderStateEventEnum, OrderStateContext> builder = StateMachineBuilderFactory.create();


    private static String ORDER_STATE = "orderState";

    public static StateMachine<OrderStateEnum, OrderStateEventEnum, OrderStateContext> getBizOrderStateMachine() {
        return StateMachineFactory.get(ORDER_STATE);
    }


    public static void buildOrderStateMachine() {
        builder.externalTransition()
                .from(OrderStateEnum.TO_BE_PAY)
                .to(OrderStateEnum.FINISH)
                .on(OrderStateEventEnum.PAY_SUCCESS)
                .when(OrderStateMachine::checkCondition)
                .perform(OrderStateMachine::executeState);
        builder.build(ORDER_STATE);
    }

    private static boolean checkCondition(OrderStateContext context) {
        return OrderStateEnum.TO_BE_PAY == context.getOrder().getOrderState();
    }

    private static void executeState(OrderStateEnum from, OrderStateEnum to, OrderStateEventEnum event, OrderStateContext context) {

        OrderStateContext.Order order = context.getOrder();

        order.setOrderState(OrderStateEnum.FINISH);
    }

}
