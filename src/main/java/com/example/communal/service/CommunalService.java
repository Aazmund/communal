package com.example.communal.service;

import com.example.communal.client.NeighbourCitizen;
import com.example.communal.configuration.CommunalFactorConfig;
import com.example.communal.dto.CitizenInfoDto;
import com.example.communal.dto.CommunalDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CommunalService {

    private final NeighbourCitizen neighbourCitizenClient;

    private final CommunalFactorConfig communalFactorConfig;

    public CommunalDto calculateByCitizen(UUID citizenId) {
        CitizenInfoDto citizen = neighbourCitizenClient.findByCitizen(citizenId);

        Double totalCitizen = communalFactorConfig.minFactorCitizen();
        if (citizen.getTotalCitizens() > communalFactorConfig.totalCitizen()) {
            totalCitizen = communalFactorConfig.maxFactorCitizen();
        }

        Double couf = communalFactorConfig.minFactorFlat();
        Integer flatNumber = Integer.getInteger(citizen.getFlatNumber());
        if (flatNumber % 2 == 0) {
            couf= communalFactorConfig.maxFactorFlat();
        }

        Double result = communalFactorConfig.factorCitizen() * totalCitizen * couf + (citizen.getTotalHouses() * communalFactorConfig.factorTotalHouses());

        return new CommunalDto(result);
    }

}
