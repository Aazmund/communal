package com.example.communal.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CitizenInfoDto {
    UUID id;

    Integer totalCitizens;
    Integer totalHouses;
    String flatNumber;
}
