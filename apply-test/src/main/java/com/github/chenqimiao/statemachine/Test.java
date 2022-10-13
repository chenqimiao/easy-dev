package com.github.chenqimiao.statemachine;

import com.github.chenqimiao.statemachine.context.OrderStateContext;
import com.github.chenqimiao.statemachine.enums.OrderStateEnum;
import com.github.chenqimiao.statemachine.enums.OrderStateEventEnum;
import com.github.chenqimiao.statemachine.machine.OrderStateMachine;

/**
 * @author Qimiao Chen
 * @date 2022-10-13 18:53
 **/
public class Test {

    public static void main(String[] args) {
        OrderStateMachine.buildOrderStateMachine();
        StateMachine<OrderStateEnum, OrderStateEventEnum, OrderStateContext> bizOrderStateMachine = OrderStateMachine.getBizOrderStateMachine();

        OrderStateContext.Order order = new OrderStateContext.Order();
        order.setOrderId("100001");
        order.setOrderState(OrderStateEnum.TO_BE_PAY);

        OrderStateContext orderStateContext = new OrderStateContext();
        orderStateContext.setOrder(order);
        OrderStateEnum orderStateEnum = bizOrderStateMachine.fireEvent(OrderStateEnum.TO_BE_PAY, OrderStateEventEnum.PAY_SUCCESS, orderStateContext);

        System.out.println("exec " + (orderStateEnum == OrderStateEnum.FINISH ? "success" : "fail"));


    }
}
