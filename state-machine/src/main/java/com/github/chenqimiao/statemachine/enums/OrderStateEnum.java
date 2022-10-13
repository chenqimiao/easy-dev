package com.github.chenqimiao.statemachine.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author Qimiao Chen
 * @date 2022-10-13 17:38
 **/
@AllArgsConstructor
@Getter
public enum OrderStateEnum {


    TO_BE_PAY(1, "待支付"),

    FINISH(2, "已完成");


    private final Integer status;
    private final String desc;
}
