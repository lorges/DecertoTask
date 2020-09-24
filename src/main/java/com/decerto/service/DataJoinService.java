package com.decerto.service;

import com.decerto.strategy.JoinDataStrategy;
import org.springframework.stereotype.Service;

@Service
public class DataJoinService {

    private final IDataProviderService restApiConsumer;
    private final IDataProviderService randomGenerator;
    private JoinDataStrategy joinDataStrategy;

    public DataJoinService(IDataProviderService restApiConsumer, IDataProviderService randomGenerator) {
        this.restApiConsumer = restApiConsumer;
        this.randomGenerator = randomGenerator;
    }

    public void setJoinDataStrategy(JoinDataStrategy joinDataStrategy) {
        this.joinDataStrategy = joinDataStrategy;
    }

    public <T extends Number> T prepareAndReturnJoinedData() {
        return (T) joinDataStrategy.joinData(restApiConsumer.getIntegerValue(), randomGenerator.getIntegerValue());
    }
}
