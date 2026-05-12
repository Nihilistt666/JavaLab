package com.lab4;

public class Employee {
    private static int totalEmployeesCreated = 0;

    private String fullName;
    private Position position;
    private double salary;
    private String department;
    private int experienceYears;
    private String phoneNumber;
    private boolean isFullTime;

    public Employee(String fullName, Position position, double salary,
                    String department, int experienceYears,
                    String phoneNumber, boolean isFullTime) {

        setFullName(fullName);
        setPosition(position);
        setSalary(salary);
        setDepartment(department);
        setExperienceYears(experienceYears);
        setPhoneNumber(phoneNumber);
        setFullTime(isFullTime);

        totalEmployeesCreated++;
    }

    public Employee(Employee other) {
        this.fullName = other.fullName;
        this.position = other.position;
        this.salary = other.salary;
        this.department = other.department;
        this.experienceYears = other.experienceYears;
        this.phoneNumber = other.phoneNumber;
        this.isFullTime = other.isFullTime;
        totalEmployeesCreated++;
    }

    public static int getTotalEmployeesCreated() {
        return totalEmployeesCreated;
    }

    public void setFullName(String fullName) {
        if (fullName == null || fullName.trim().isEmpty()) {
            throw new IllegalArgumentException("ПІБ не може бути порожнім");
        }
        this.fullName = fullName.trim();
    }

    public void setPosition(Position position) {
        if (position == null) {
            throw new IllegalArgumentException("Посада не може бути null");
        }
        this.position = position;
    }

    public void setSalary(double salary) {
        if (salary <= 0) {
            throw new IllegalArgumentException("Зарплата повинна бути більшою за 0");
        }
        this.salary = salary;
    }

    public void setDepartment(String department) {
        if (department == null || department.trim().isEmpty()) {
            throw new IllegalArgumentException("Відділ не може бути порожнім");
        }
        this.department = department.trim();
    }

    public void setExperienceYears(int experienceYears) {
        if (experienceYears < 0 || experienceYears > 60) {
            throw new IllegalArgumentException("Стаж має бути від 0 до 60 років");
        }
        this.experienceYears = experienceYears;
    }

    public void setPhoneNumber(String phoneNumber) {
        if (phoneNumber == null || phoneNumber.trim().isEmpty()) {
            throw new IllegalArgumentException("Номер телефону не може бути порожнім");
        }
        this.phoneNumber = phoneNumber.trim();
    }

    public void setFullTime(boolean fullTime) {
        this.isFullTime = fullTime;
    }

    public String getFullName() { return fullName; }
    public Position getPosition() { return position; }
    public double getSalary() { return salary; }
    public String getDepartment() { return department; }
    public int getExperienceYears() { return experienceYears; }
    public String getPhoneNumber() { return phoneNumber; }
    public boolean isFullTime() { return isFullTime; }

    @Override
    public String toString() {
        return String.format("Працівник: %s | Посада: %s | Відділ: %s | Зарплата: %.0f грн | Стаж: %d | Тел: %s | Повна зайнятість: %s",
                fullName, position.getDisplayName(), department, salary, experienceYears, phoneNumber, isFullTime ? "Так" : "Ні");
    }
}
