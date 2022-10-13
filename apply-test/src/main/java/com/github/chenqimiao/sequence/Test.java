package com.github.chenqimiao.sequence;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Qimiao Chen
 * @date 2022-10-13 19:12
 **/
public class Test {
    public static void main(String[] args) {
        IdentifierGenerator identifierGenerator = new DefaultIdentifierGenerator();
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
