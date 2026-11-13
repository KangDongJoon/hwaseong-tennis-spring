CREATE TABLE slots (
    court_id INT NOT NULL,
    `date` DATE NOT NULL,
    `begin` TIME NOT NULL,
    `end` TIME NOT NULL,
    status VARCHAR(16) NOT NULL,
    fetched_at DATETIME NOT NULL,
    PRIMARY KEY (court_id, `date`, `begin`),
    CONSTRAINT ck_slots_status
        CHECK (status IN ('available', 'reserved', 'pending', 'hold', 'closed', 'unavailable'))
);

CREATE TABLE fetch_logs (
    id BIGINT NOT NULL AUTO_INCREMENT,
    court_id INT NOT NULL,
    `year_month` VARCHAR(7) NOT NULL,
    ok BOOLEAN NOT NULL,
    error TEXT,
    fetched_at DATETIME NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE alerts (
    id BIGINT NOT NULL AUTO_INCREMENT,
    token VARCHAR(32) NOT NULL,
    subscription_enc TEXT NOT NULL,
    endpoint_hash VARCHAR(64) NOT NULL,
    date_from DATE NOT NULL,
    date_to DATE NOT NULL,
    day_type VARCHAR(8) NOT NULL,
    time_from TIME,
    time_to TIME,
    notified MEDIUMTEXT NOT NULL,
    last_notified_at DATETIME,
    created_at DATETIME NOT NULL,
    PRIMARY KEY (id),
    CONSTRAINT uq_alerts_token UNIQUE (token),
    CONSTRAINT ck_alerts_day_type CHECK (day_type IN ('all', 'weekday', 'weekend'))
);

-- 알림이 고른 시설. 행이 하나도 없으면 전체 시설.
CREATE TABLE alert_facilities (
    alert_id BIGINT NOT NULL,
    facility VARCHAR(20) NOT NULL,
    PRIMARY KEY (alert_id, facility),
    CONSTRAINT fk_alert_facilities_alert
        FOREIGN KEY (alert_id) REFERENCES alerts (id) ON DELETE CASCADE
);

CREATE TABLE visits (
    id BIGINT NOT NULL AUTO_INCREMENT,
    `date` DATE NOT NULL,
    visitor_hash VARCHAR(64) NOT NULL,
    views INT NOT NULL,
    PRIMARY KEY (id),
    CONSTRAINT uq_visits_date_visitor UNIQUE (`date`, visitor_hash)
);
