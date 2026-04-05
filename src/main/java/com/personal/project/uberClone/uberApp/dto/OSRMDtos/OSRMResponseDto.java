package com.personal.project.uberClone.uberApp.dto.OSRMDtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class OSRMResponseDto {
    private String code;
    private List<OSRMRoute> routes;
}
