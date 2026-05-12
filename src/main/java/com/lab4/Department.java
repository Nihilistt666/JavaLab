package com.lab4;

import java.util.ArrayList;
import java.util.List;

/**
 * Клас Department демонструє агрегацію.
 * Один відділ може містити багато працівників (агрегація).
 */
public class Department {
    private String name;
    private String location;
    private List<Employee> employees;

    public Department(String name, String location) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Назва відділу не може бути порожньою");
        }
        this.name = name.trim();
        this.location = location != null ? location.trim() : "Не вказано";
        this.employees = new ArrayList<>();
    }

    // Конструктор копіювання
    public Department(Department other) {
        this.name = other.name;
        this.location = other.location;
        this.employees = new ArrayList<>(other.employees);
    }

    public void addEmployee(Employee employee) {
        if (employee != null) {
            employees.add(employee);
        }
    }

    public List<Employee> getEmployees() {
        return new ArrayList<>(employees); // повертаємо копію
    }

    public String getName() { return name; }
    public String getLocation() { return location; }

    public int getEmployeeCount() {
        return employees.size();
    }

    @Override
    public String toString() {
        return String.format("Відділ: %s | Локація: %s | Кількість працівників: %d",
                name, location, employees.size());
    }
}
