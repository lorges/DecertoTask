package com.decerto.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class RandomGenerator implements IDataProviderService {

    @Value("${randomGeneratorMaxIntValue}")
    public int randomGeneratorMaxIntValue;

    @Override
    public Integer getIntegerValue() {
        Random rand = new Random();
        return rand.nextInt(randomGeneratorMaxIntValue);
    }
}
