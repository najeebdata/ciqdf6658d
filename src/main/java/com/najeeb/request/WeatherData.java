package com.najeeb.request;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class WeatherData {
    private String sensorName;
    private String sensorLocation;
    private Integer temperature;
    private Integer humidity;
    private Integer windspeed;

    @JsonCreator
    public WeatherData(
            @JsonProperty("sensor_name") String sensorName,
            @JsonProperty("sensor_location") String sensorLocation,
            @JsonProperty("temperature") Integer temperature,
            @JsonProperty("humidity") Integer humidity,
            @JsonProperty("windspeed") Integer windspeed) {
        this.sensorName = sensorName;
        this.sensorLocation = sensorLocation;
        this.temperature = temperature;
        this.humidity = humidity;
        this.windspeed = windspeed;
    }

    public String getSensorName() {
        return sensorName;
    }

    public String getSensorLocation() {
        return sensorLocation;
    }

    public Integer getTemperature() {
        return temperature;
    }

    public Integer getHumidity() {
        return humidity;
    }

    public Integer getWindspeed() {
        return windspeed;
    }
}
