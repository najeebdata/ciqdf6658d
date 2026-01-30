package com.najeeb.model;

import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Table("metrics_by_sensor")
public class MetricsBySensor {
    @PrimaryKey
    private UUID id;

    @Column("name")
    private String name;

    @Column("location")
    private String location;

    @Column("metrics_received_at")
    private Date metricsReceivedAt;

    @Column("metrics_received")
    private List<String> metricsReceived;

    @Column
    private Integer temperature;

    @Column
    private Integer humidity;

    @Column("wind_speed")
    private Integer windSpeed;

    public MetricsBySensor(UUID id, String name, String location, Date metricsReceivedAt,
                           List<String> metricsReceived, Integer temperature, Integer humidity, Integer windSpeed) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.metricsReceivedAt = metricsReceivedAt;
        this.metricsReceived = metricsReceived;
        this.temperature = temperature;
        this.humidity = humidity;
        this.windSpeed = windSpeed;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Date getMetricsReceivedAt() {
        return metricsReceivedAt;
    }

    public void setMetricsReceivedAt(Date metricsReceivedAt) {
        this.metricsReceivedAt = metricsReceivedAt;
    }

    public List<String> getMetricsReceived() {
        return metricsReceived;
    }

    public void setMetricsReceived(List<String> metricsReceived) {
        this.metricsReceived = metricsReceived;
    }

    public Integer getTemperature() {
        return temperature;
    }

    public void setTemperature(Integer temperature) {
        this.temperature = temperature;
    }

    public Integer getHumidity() {
        return humidity;
    }

    public void setHumidity(Integer humidity) {
        this.humidity = humidity;
    }

    public Integer getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(Integer windSpeed) {
        this.windSpeed = windSpeed;
    }

}
