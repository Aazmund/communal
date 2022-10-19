package com.example.communal.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "communal.factor")
public record CommunalFactorConfig(
        Double minFactorCitizen,
        Double maxFactorCitizen,
        Integer totalCitizen,
        Double minFactorFlat,
        Double maxFactorFlat,
        Integer factorCitizen,
        Integer factorTotalHouses
) {

}
