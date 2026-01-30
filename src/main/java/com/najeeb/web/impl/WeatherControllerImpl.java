package com.najeeb.web.impl;

import com.najeeb.WeatherResource;
import com.najeeb.model.MetricsBySensor;
import com.najeeb.request.WeatherData;
import com.najeeb.service.api.WeatherDataService;
import com.najeeb.web.api.WeatherController;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/weatherdata")
public class WeatherControllerImpl implements WeatherController {
    private WeatherDataService weatherDataService;
    private WeatherResourceAssembler assembler; //WeatherResourceAssembler class implemented for time constraints

    @Autowired
    public WeatherControllerImpl(WeatherDataService weatherDataService, WeatherResourceAssembler assembler) {
        this.weatherDataService = weatherDataService;
        this.assembler = assembler;
    }

    @Override
    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    //User class not implemented
    public void receiveWeatherData(@RequestBody WeatherData input, @AuthenticationPrincipal User loggedInUser) {
        weatherDataService.save(input);
    }

    @Override
    public CollectionModel<WeatherResource> getWeatherData(
            @RequestParam(value = "sensor_names", required = false) List<String> sensorNames,
            @RequestParam(value = "all_sensors", required = false, defaultValue = "false") Boolean allSensors,
            @RequestParam(value = "metrics", required = true) List<String> metricsRequested,
            @RequestParam(value = "statistics", required = false, defaultValue = "average") String statistics,
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
            @RequestParam(value = "date_from", required = false) DateTime dateFrom,
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
            @RequestParam(value = "date_to", required = false) DateTime dateTo) {

        List<MetricsBySensor> metrics = weatherDataService.getByCriteria(sensorNames, allSensors,
                metricsRequested, statistics, dateFrom, dateTo);
        // if assembler was implemented - then we must add exception handling in the "toModel" which Spring calls as it iterates over the collection
        // so that we can return the records that didn't had any exception and logging the ones that had exceptions for later investigation.
        return assembler.toCollectionModel(metrics);
    }
}



















