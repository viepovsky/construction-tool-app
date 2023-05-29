# Construction Tools App

This application calculates the lengths of rebars in reinforced beams and slabs. Upon entering the details of a beam or slab, the application provides a JSON response 
containing information about the lengths of rebars for each specified diameter.

I have created this application to fasten my work process, and I will continue to enhance it over time by adding new features. Feel free to use this code if you need a similar application.

## Technologies

The application currently uses the following frameworks and technologies:

- Spring Boot: Web, Validation
- Lombok
- Gradle

## How to run

To start the application, clone this repository and run the `ConstructionToolsApp` class or type `./gradlew bootRun` in your IDE terminal.

## Endpoints

The application provides the following endpoints:

1. Beam details: `http://localhost:8080/v1/counting/beam` 
-  retrieves rebars length for the given beam details
-  example request:
```json
{
    "beamClearSpan": 550,
    "widthOfSupport": 24,
    "upperRebarsDiameter": 12,
    "upperRebarsCount": 2,
    "lowerRebarsDiameter": 16,
    "lowerRebarsCount": 4,
    "beamWidth": 25,
    "beamHigh": 40,
    "stirrupDiameter": 8,
    "stirrupSpacing": 20,
    "stirrupSpacingDensity": 20,
    "stirrupSpacingDensityLength": 100
}
```
- example response
```json
{
    "rebars": {
        "16": 23.92,
        "8": 37.12,
        "12": 11.96
    }
}
```
2. Slab details: `http://localhost:8080/v1/counting/slab` 
-  retrieves rebars length for the given slab details
-  example request:
```json
{
    "slabWidth": 500,
    "slabLength": 200,
    "upperRebarsDiameter": 12,
    "lowerRebarsDiameter": 16,
    "upperSpacing": 15,
    "lowerSpacing": 10
}
```
- example response
```json
{
    "rebars": {
        "16": 207.0,
        "12": 138.0
    }
}
```

Please note that the application is a work in progress, and further improvements and enhancements will be made over time.
