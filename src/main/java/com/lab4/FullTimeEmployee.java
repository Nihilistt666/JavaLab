package com.lab4;

public class FullTimeEmployee extends Employee {
    private double bonusPercentage;

    public FullTimeEmployee(String fullName, String position, double salary,
                            String department, int experienceYears,
                            String phoneNumber, boolean isFullTime, double bonusPercentage) {
        super(fullName, position, salary, department, experienceYears, phoneNumber, isFullTime);
        this.bonusPercentage = bonusPercentage;
    }

    @Override
    public String toString() {
        return super.toString() + " | Тип: Повна зайнятість | Бонус: " + bonusPercentage + "%";
    }
}
