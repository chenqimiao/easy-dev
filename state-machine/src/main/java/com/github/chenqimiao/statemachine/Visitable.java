package com.github.chenqimiao.statemachine;

/**
 * Visitable
 *
 */
public interface Visitable {
    String accept(final Visitor visitor);
}
