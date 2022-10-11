package com.example.communal.controller;

import com.example.communal.client.NeighbourCitizen;
import com.example.communal.dto.CitizenInfoDto;
import com.example.communal.dto.CommunalDto;
import com.example.communal.service.CommunalService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("api/v1/communal")
@RequiredArgsConstructor
public class CommunalController {

    private final CommunalService communalService;

    @GetMapping("/citizen/{id}")
    public ResponseEntity<CommunalDto> getByCitizenId(@PathVariable UUID id) {
        return ResponseEntity.ok(communalService.calculateByCitizen(id));
    }

}
