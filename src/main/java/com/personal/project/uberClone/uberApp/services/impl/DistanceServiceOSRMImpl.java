package com.personal.project.uberClone.uberApp.services.impl;

import com.personal.project.uberClone.uberApp.dto.OSRMDtos.OSRMResponseDto;
import com.personal.project.uberClone.uberApp.services.DistanceService;
import org.locationtech.jts.geom.Point;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class DistanceServiceOSRMImpl implements DistanceService {

    private static final String OSRM_API_BASE_URL = "https://router.project-osrm.org/route/v1/driving/";

    private final RestTemplate restTemplate = new RestTemplate();

    @Override
    public double calculateDistance(Point src, Point dest) {
        // OSRM expects: longitude,latitude (NOT lat,lon)
        String url = OSRM_API_BASE_URL
                + src.getX() + "," + src.getY()    // src: lon,lat
                + ";"
                + dest.getX() + "," + dest.getY()  // dest: lon,lat
                + "?overview=false";

        try {
            OSRMResponseDto response = restTemplate.getForObject(url, OSRMResponseDto.class);

            if (response == null || response.getRoutes() == null || response.getRoutes().isEmpty()) {
                throw new RuntimeException("No routes found from OSRM");
            }

            // distance is in meters, convert to km
            return response.getRoutes().get(0).getDistance() / 1000.0;

        } catch (Exception e) {
            throw new RuntimeException("Error getting data from OSRM " + e.getMessage());
        }
    }
}


