package com.decerto.strategy;

import org.springframework.stereotype.Component;

@Component
public class AddictionStrategy implements JoinDataStrategy {

    @Override
    public <T extends Number> T joinData(T dataFirstSource, T dataSecondSource) {
        if(null == dataFirstSource || null == dataSecondSource) {
            return null;
        }

        if(dataFirstSource instanceof Integer) {
            return (T) Integer.valueOf(dataFirstSource.intValue() + dataSecondSource.intValue());
        } else if(dataFirstSource instanceof Double) {
            return (T) Double.valueOf(dataFirstSource.doubleValue() + dataSecondSource.doubleValue());
        }
        throw new IllegalArgumentException("Method not support " + dataFirstSource.getClass() + " yet.");
    }
}
