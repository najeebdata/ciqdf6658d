package com.najeeb.service.impl;

import com.najeeb.dao.api.MetricsBySensorDao;
import com.najeeb.model.MetricsBySensor;
import com.najeeb.request.WeatherData;
import com.najeeb.service.api.WeatherDataService;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class WeatherDataServiceImpl implements WeatherDataService {
    private MetricsBySensorDao metricsBySensorDao;

    @Autowired
    public WeatherDataServiceImpl(MetricsBySensorDao metricsBySensorDao) {
        this.metricsBySensorDao = metricsBySensorDao;
    }

    @Override
    // permission evaluation can be added here for security use @PreAuthorize
    public MetricsBySensor save(WeatherData weatherData) {
            List<String> metricsReceived = new ArrayList<>();
            if (weatherData.getTemperature() != null) {
                metricsReceived.add("temperature");
            }

            if (weatherData.getHumidity() != null) {
                metricsReceived.add("humidity");
            }

            if (weatherData.getWindspeed() != null) {
                metricsReceived.add("windspeed");
            }

            MetricsBySensor metricsBySensor = new MetricsBySensor(UUID.randomUUID(), weatherData.getSensorName(),
                weatherData.getSensorLocation(), DateTime.now().toDate(), metricsReceived,
                    weatherData.getTemperature(), weatherData.getHumidity(), weatherData.getWindspeed());
            metricsBySensorDao.save(metricsBySensor);
            return metricsBySensor;
    }

    @Override
    // permission evaluation can be added here for security
    public List<MetricsBySensor> getByCriteria(
            List<String> sensorNames, Boolean allSensors, List<String> metricsRequested,
            String statistics, DateTime dateFrom, DateTime dateTo) {
        return metricsBySensorDao.getByCriteria(sensorNames, allSensors,
                metricsRequested, statistics, dateFrom, dateTo);
    }
}
