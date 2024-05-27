package com.prashanth;

import com.google.common.geometry.S2LatLng;
import com.google.common.geometry.S2Point;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        System.out.println("Open Google maps click one location, then right click you will see the lat, lan as first option. " +
                "Copy the latitude and longitude of your source and destination");

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the latitude and longitude of the source.");
        final String source = scanner.nextLine();
        final double sourceLatitude = Double.parseDouble(source.split(",")[0].trim());
        final double sourceLongitude = Double.parseDouble(source.split(",")[1].trim());

        System.out.println("Enter the latitude and longitude of the destination");
        final String destination = scanner.nextLine();
        final double destinationLatitude = Double.parseDouble(destination.split(",")[0].trim());
        final double destinationLongitude = Double.parseDouble(destination.split(",")[1].trim());

        final int distanceKm = getDistanceKm(
                sourceLatitude,
                sourceLongitude,
                destinationLatitude,
                destinationLongitude
        );

        System.out.println("If you draw a straight line between Point A to Point B, the distance would be: " + distanceKm + " km");
    }

    protected static int getDistanceKm(double sourceLatitude, double sourceLongitude, double destinationLatitude, double destinationLongitude) {

        // Create S2LatLng points
        S2LatLng point1 = S2LatLng.fromDegrees(sourceLatitude, sourceLongitude);
        S2LatLng point2 = S2LatLng.fromDegrees(destinationLatitude, destinationLongitude);

        // Convert S2LatLng points to S2Points
        S2Point s2Point1 = point1.toPoint();
        S2Point s2Point2 = point2.toPoint();

        // Compute the distance between the two points in radians
        double distanceRadians = s2Point1.angle(s2Point2);

        /*
        * In this line, distanceRadians is a variable that holds the distance between two points on the surface
        * of a sphere (in this case, Earth) measured in radians.
        * The number 6371.01 is the average radius of the Earth in kilometers.
        * The formula used here is based on the fact that the circumference of a circle (or a sphere) is 2 * π * radius.
        * Therefore, a radian, which is the measure of an angle subtended at the center of a circle by an arc equal in
        * length to the radius, corresponds to a distance on the surface of the Earth equal to the radius of the Earth.
        * So, to convert a distance from radians to kilometers, we multiply the distance in radians by the radius of
        * the Earth in kilometers.
        * This is exactly what the code snippet is doing.
        * The result, distanceKm, is the distance between the two points in kilometers.
        * */
        return (int) (distanceRadians * 6371.01);
    }
}