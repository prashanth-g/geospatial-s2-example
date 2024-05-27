package com.prashanth;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainTest {

    @Test
    public void distanceCalculationForKnownPoints() {
        double sourceLatitude = 37.7749;
        double sourceLongitude = -122.4194;
        double destinationLatitude = 34.0522;
        double destinationLongitude = -118.2437;

        double expectedDistance = 559; // This is a known distance between San Francisco and Los Angeles

        double actualDistance = Main.getDistanceKm(sourceLatitude, sourceLongitude, destinationLatitude, destinationLongitude);

        assertEquals(expectedDistance, actualDistance, 0.001);
    }

    @Test
    public void distanceCalculationForSamePoint() {
        double sourceLatitude = 37.7749;
        double sourceLongitude = -122.4194;
        double destinationLatitude = 37.7749;
        double destinationLongitude = -122.4194;

        double expectedDistance = 0.0; // The distance between a point and itself should be 0

        double actualDistance = Main.getDistanceKm(sourceLatitude, sourceLongitude, destinationLatitude, destinationLongitude);

        assertEquals(expectedDistance, actualDistance, 0.001);
    }
}
