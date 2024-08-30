CREATE TABLE IF NOT EXISTS fibo_data
(
    id             SERIAL PRIMARY KEY,
    request        int       NOT NULL,
    result         bigint    NOT NULL,
    execution_date timestamp NOT NULL default current_timestamp
);

        