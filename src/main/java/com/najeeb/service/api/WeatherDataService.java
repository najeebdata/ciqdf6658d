package com.najeeb.service.api;

import com.najeeb.model.MetricsBySensor;
import com.najeeb.request.WeatherData;
import org.joda.time.DateTime;

import java.util.List;

public interface WeatherDataService {
    /**
     * Saves the object data in DB
     *
     * @param weatherData
     * @return
     */
    MetricsBySensor save(WeatherData weatherData);

    /**
     *
     * @param sensorNames
     * @param allSensors
     * @param metricsRequested
     * @param Statistics
     * @param dateFrom
     * @param dateTo
     * @return
     */
    List<MetricsBySensor> getByCriteria(
            List<String> sensorNames, Boolean allSensors,
            List<String> metricsRequested, String Statistics, DateTime dateFrom, DateTime dateTo);

}
