package com.github.chenqimiao.sequence;

import io.github.mocreates.Sequence;
import io.github.mocreates.config.DefaultSequenceConfig;

/**
 * @author Qimiao Chen
 * @date 2022-10-12 11:25
 **/
public class DefaultIdentifierGenerator implements IdentifierGenerator{
    private final Sequence sequence;



    public DefaultIdentifierGenerator(long workerId) {
        DefaultSequenceConfig defaultSequenceConfig = new DefaultSequenceConfig();
        defaultSequenceConfig.setWorkerId(workerId);
        sequence =  new Sequence(defaultSequenceConfig);
    }


    @Override
    public Long nextId() {
        return sequence.nextId();
    }
}
