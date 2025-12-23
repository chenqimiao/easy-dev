package com.github.chenqimiao.sequence;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Qimiao Chen
 * @date 2022-10-13 19:12
 **/
public class Test {
    public static void main(String[] args) {
        // 分布式环境中可以用数据库自增id来做workId
        long workId = 1;
        IdentifierGenerator identifierGenerator = new DefaultIdentifierGenerator(workId);
        Set<Long> ids = new HashSet<>();
        int i = 0;
        while (true) {
            Long id = identifierGenerator.nextId();
            System.out.println("No." + i + ":" + id);
            i++;
            if (!ids.add(id)) {
                throw new RuntimeException();
            }
        }

    }
}
