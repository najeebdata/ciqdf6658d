package com.najeeb.dao.api;

import com.najeeb.model.MetricsBySensor;
import org.joda.time.DateTime;

import java.util.List;

public interface MetricsBySensorDao {
    /**
     * Saves the object in DB
     * @param metricsBySensor
     */
    void save(MetricsBySensor metricsBySensor);

    /**
     * Gets the metrics by the givenc criteria
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
