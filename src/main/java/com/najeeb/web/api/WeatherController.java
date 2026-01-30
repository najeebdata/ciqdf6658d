package com.najeeb.web.api;

import com.najeeb.WeatherResource;
import com.najeeb.request.WeatherData;
import org.joda.time.DateTime;
import org.springframework.hateoas.CollectionModel;

import java.util.List;

public interface WeatherController {
    /**
     * Receives weather data from a sensor
     *
     * @param input
     * @param loggedInUser
     */
    void receiveWeatherData(WeatherData input, User loggedInUser); //User class not implemented

    CollectionModel<WeatherResource> getWeatherData(
            List<String> sensorNames, Boolean allSensors, List<String> metricsRequested,
            String statistics, DateTime dateFrom, DateTime dateTo);




}
