package com.personal.project.uberClone.uberApp.dto.OSRMDtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class OSRMRoute {
    private Double distance;   // total route distance in meters
    private Double duration;
    private List<OSRMLeg> legs;
}
