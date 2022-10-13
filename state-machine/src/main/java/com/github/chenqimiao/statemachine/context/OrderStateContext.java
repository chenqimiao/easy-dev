package com.github.chenqimiao.statemachine.context;

import com.github.chenqimiao.statemachine.enums.OrderStateEnum;
import lombok.Data;

/**
 * @author Qimiao Chen
 * @date 2022-10-13 17:34
 **/
@Data
public class OrderStateContext {

    private Order order;

    @Data
    public static class Order {

        private String orderId;

        private OrderStateEnum orderState;
    }
}

