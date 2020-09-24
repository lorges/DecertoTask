package com.decerto.utils;

import com.decerto.service.IDataProviderService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;

@Component
public class RestApiConsumer implements IDataProviderService {

    private final RestTemplate restTemplate;

    @Value("${restApi.url.randomInteger}")
    public String urlRestApiRandomInt;

    public RestApiConsumer(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public Integer getIntegerValue() {
        String valueAsString = restTemplate.getForObject(urlRestApiRandomInt, String.class);
        if(!StringUtils.isEmpty(valueAsString)) {
            return Integer.valueOf(valueAsString.trim());
        }
        return null;
    }
}
