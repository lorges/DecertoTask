package com.decerto.strategy;

public interface JoinDataStrategy {
    <T extends Number> T joinData(T firstSourceData, T secondSourceData);
}
