package com.example.communal.client;

import com.example.communal.dto.CitizenInfoDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.UUID;

@FeignClient(
        name = "neighbour-service",
        path = "/api/v1/citizen",
        url = "${neighbour-service.url}"
)
public interface NeighbourCitizen {

    @RequestMapping(value = "/{id}/info", method = RequestMethod.GET)
    CitizenInfoDto findByCitizen(@PathVariable("id") UUID id);

}
