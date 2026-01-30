package com.najeeb;

import com.fasterxml.jackson.annotation.JsonProperty;

public class WeatherResource {
    private Integer tempAvg;
    private Integer humidityAvg;
    private Integer windSpeedAvg;
    private Integer statistics;

    public WeatherResource(Integer tempAvg, Integer humidityAvg, Integer windSpeedAvg, Integer statistics) {
        this.tempAvg = tempAvg;
        this.humidityAvg = humidityAvg;
        this.windSpeedAvg = windSpeedAvg;
        this.statistics = statistics;
    }

    @JsonProperty("temperature_avg")
    public Integer getTempAvg() {
        return tempAvg;
    }

    @JsonProperty("humidity_avg")
    public Integer getHumidityAvg() {
        return humidityAvg;
    }

    @JsonProperty("windspeed_avg")
    public Integer getWindSpeedAvg() {
        return windSpeedAvg;
    }

    @JsonProperty("statistics")
    public Integer getStatistics() {
        return statistics;
    }
}
