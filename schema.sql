CREATE TABLE IF NOT EXISTS employees (
                                         id SERIAL PRIMARY KEY,
                                         type VARCHAR(50) NOT NULL,
    full_name VARCHAR(100) NOT NULL,
    position VARCHAR(100) NOT NULL,
    salary NUMERIC(12,2) NOT NULL,
    department VARCHAR(100) NOT NULL,
    experience_years INT NOT NULL,
    contract_months INT,
    bonus_percentage NUMERIC(5,2),
    remote_location VARCHAR(100),
    sales_target NUMERIC(12,2)
    );