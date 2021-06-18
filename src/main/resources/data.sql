DROP TABLE IF EXISTS request_counters;

CREATE TABLE request_counters
(
    LOGIN         VARCHAR(255) PRIMARY KEY,
    REQUEST_COUNT INT NOT NULL
);

