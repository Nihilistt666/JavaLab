package com.lab4;

import java.io.FileInputStream;
import java.sql.*;
import java.util.Properties;

public class DatabaseManager {
    private String url;
    private String user;
    private String password;

    public DatabaseManager(String configFile) {
        loadConfig(configFile);
    }

    private void loadConfig(String configFile) {
        try (FileInputStream fis = new FileInputStream(configFile)) {
            Properties props = new Properties();
            props.load(fis);
            this.url = props.getProperty("db.url");
            this.user = props.getProperty("db.user");
            this.password = props.getProperty("db.password");
        } catch (Exception e) {
            System.out.println("Помилка завантаження конфігурації: " + e.getMessage());
        }
    }

    public void saveEmployee(Employee emp) {
        String sql = "INSERT INTO employees (type, full_name, position, salary, department, " +
                "experience_years, contract_months, bonus_percentage, remote_location, sales_target) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, emp.getType());

            ps.setString(2, emp.getFullName());
            ps.setString(3, emp.getPosition());
            ps.setDouble(4, emp.getSalary());
            ps.setString(5, emp.getDepartment());
            ps.setInt(6, emp.getExperienceYears());

            if (emp instanceof ContractEmployee c) {
                ps.setInt(7, c.getContractDurationMonths());
                ps.setNull(8, Types.NUMERIC);
                ps.setNull(9, Types.VARCHAR);
                ps.setNull(10, Types.NUMERIC);
            } else if (emp instanceof RemoteEmployee r) {
                ps.setNull(7, Types.INTEGER);
                ps.setDouble(8, r.getBonusPercentage());
                ps.setString(9, r.getRemoteLocation());
                ps.setNull(10, Types.NUMERIC);
            } else if (emp instanceof SalesEmployee s) {
                ps.setNull(7, Types.INTEGER);
                ps.setDouble(8, s.getBonusPercentage());
                ps.setNull(9, Types.VARCHAR);
                ps.setDouble(10, s.getSalesTarget());
            } else if (emp instanceof FullTimeEmployee f) {
                ps.setNull(7, Types.INTEGER);
                ps.setDouble(8, f.getBonusPercentage());
                ps.setNull(9, Types.VARCHAR);
                ps.setNull(10, Types.NUMERIC);
            } else {
                ps.setNull(7, Types.INTEGER);
                ps.setNull(8, Types.NUMERIC);
                ps.setNull(9, Types.VARCHAR);
                ps.setNull(10, Types.NUMERIC);
            }

            ps.executeUpdate();
            System.out.println("Збережено в БД: " + emp.getFullName());
        } catch (SQLException e) {
            System.out.println("Помилка збереження в БД: " + e.getMessage());
        }
    }
}
