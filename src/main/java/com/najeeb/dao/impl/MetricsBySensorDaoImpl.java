package com.najeeb.dao.impl;

import com.datastax.oss.driver.api.querybuilder.QueryBuilder;
import com.datastax.oss.driver.api.querybuilder.select.Select;
import com.datastax.oss.driver.api.querybuilder.term.Term;
import com.najeeb.dao.api.MetricsBySensorDao;
import com.najeeb.model.MetricsBySensor;
import org.apache.commons.collections4.CollectionUtils;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.cassandra.core.CassandraOperations;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

import static com.datastax.oss.driver.api.querybuilder.QueryBuilder.literal;

@Repository
public class MetricsBySensorDaoImpl implements MetricsBySensorDao {
    private CassandraOperations cassandraOperations;

    @Autowired
    public MetricsBySensorDaoImpl(CassandraOperations cassandraOperations) {
        this.cassandraOperations = cassandraOperations;
    }

    @Override
    public void save(MetricsBySensor metricsBySensor) {
        cassandraOperations.insert(metricsBySensor);
    }

    @Override
    public List<MetricsBySensor> getByCriteria(List<String> sensorNames, Boolean allSensors,
                                               List<String> metricsRequested, String statistics,
                                               DateTime dateFrom, DateTime dateTo) {
        Select select = null;
        if (CollectionUtils.isNotEmpty(metricsRequested)) {
            select = QueryBuilder.selectFrom("metrics_by_sensor").columns(metricsRequested);
        } else {
            select = QueryBuilder.selectFrom("metrics_by_sensor").all();
        }

        if (CollectionUtils.isNotEmpty(sensorNames)) {
            List<Term> sensorNameTerms = sensorNames.stream().map(QueryBuilder::literal).collect(Collectors.toList());
            select.whereColumn("sensor_name").in(sensorNameTerms);
        }

        if (dateFrom != null && dateTo != null) {
            select.whereColumn("metrics_received_at").isGreaterThanOrEqualTo(literal(dateFrom))
                    .whereColumn("metrics_received_at").isLessThanOrEqualTo(literal(dateTo));
        }

        return cassandraOperations.select(select.asCql(), MetricsBySensor.class);
    }
}
