package com.example.communal.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CommunalDto {
    Double result;

    public CommunalDto(Double result) {
        this.result = result;
    }
}
