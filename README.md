Receiving Weather Data:
======================

curl -X POST http://localhhost:8080/weatherdata -H "Content-Type: application/json" -d '{"sensor_name": "mysensor", "sensor_location": "toronto", "temperature": 15, "humidity": 70, "windspeed": 65}'

Querying Weather Data:
======================
curl -G http://localhhost:8080/weatherdata --data-urlencode "sensor_names="mysensor, abcsensor"--data-urlencode "metrics="temperature, humidity" --data-urlencode "statistics=max" --data-urlencode "date_from=2025-01-20" --data-urlencode "date_to=2026-01-20"

The avg and statistics calculation has not been done in this change but ideally, it could be through in the DB query itself or in the resouce assembler which I have not implemented.
