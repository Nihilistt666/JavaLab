package com.lab4;

import java.util.Objects;

public class Employee {
    private String fullName;
    private String position;
    private double salary;
    private String department;
    private int experienceYears; // стаж у роках

    // Конструктор з параметрами
    public Employee(String fullName, String position, double salary,
                    String department, int experienceYears) {
        this.fullName = fullName;
        this.position = position;
        this.salary = salary;
        this.department = department;
        this.experienceYears = experienceYears;
    }

    // Гетери
    public String getFullName() { return fullName; }
    public String getPosition() { return position; }
    public double getSalary() { return salary; }
    public String getDepartment() { return department; }
    public int getExperienceYears() { return experienceYears; }

    // Сетери
    public void setFullName(String fullName) { this.fullName = fullName; }
    public void setPosition(String position) { this.position = position; }
    public void setSalary(double salary) { this.salary = salary; }
    public void setDepartment(String department) { this.department = department; }
    public void setExperienceYears(int experienceYears) {
        this.experienceYears = experienceYears;
    }

    @Override
    public String toString() {
        return String.format("Працівник: %s | Посада: %s | Відділ: %s | Зарплата: %.2f грн | Стаж: %d років",
                fullName, position, department, salary, experienceYears);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Double.compare(salary, employee.salary) == 0 &&
                experienceYears == employee.experienceYears &&
                Objects.equals(fullName, employee.fullName) &&
                Objects.equals(position, employee.position) &&
                Objects.equals(department, employee.department);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fullName, position, salary, department, experienceYears);
    }
}
