package com.personal.project.uberClone.uberApp.dto.OSRMDtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class OSRMLeg {
    private Double distance;
    private Double duration;
}
