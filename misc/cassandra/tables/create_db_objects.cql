CREATE TABLE metrics_by_sensor (
    id                          UUID,
    name                        TEXT,
    location                    TEXT,
    metrics_received_at     TIMESTAMP,
    metrics_received            LIST<TEXT>,
    temperature                 INT,
    humidity                    INT,
    wind_speed                  INT,
PRIMARY KEY(id));

CREATE TABLE user (
    email                       TEXT,
    password                    TEXT,
    registered_at               TIMESTAMP,
    last_login_at               TIMESTAMP,
    failed_login_attempts       INT,
PRIMARY KEY(email));
