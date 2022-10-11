package com.example.communal.service;

import com.example.communal.client.NeighbourCitizen;
import com.example.communal.dto.CitizenInfoDto;
import com.example.communal.dto.CommunalDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CommunalService {

    private final NeighbourCitizen neighbourCitizenClient;

    public CommunalDto calculateByCitizen(UUID citizenId) {
        CitizenInfoDto citizen = neighbourCitizenClient.findByCitizen(citizenId);

        Double totalCitizen = 1.0;
        if (citizen.getTotalCitizens() > 3) {
            totalCitizen = 1.5;
        }

        Double couf = 1.9;
        Integer flatNumber = Integer.getInteger(citizen.getFlatNumber());
        if (flatNumber % 2 == 0) {
            couf= 2.3;
        }

        Double result = 100 * totalCitizen * couf + (citizen.getTotalHouses() * 10);

        return new CommunalDto(result);
    }

}
