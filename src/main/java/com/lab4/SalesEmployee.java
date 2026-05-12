package com.lab4;

public class SalesEmployee extends FullTimeEmployee {
    private double salesTarget;

    public SalesEmployee(String fullName, String position, double salary, String department,
                         int experienceYears, double bonusPercentage, double salesTarget) {
        super(fullName, position, salary, department, experienceYears, bonusPercentage);
        this.salesTarget = salesTarget;
    }

    @Override
    public String toString() {
        return super.toString() + " | План продажів: " + salesTarget + " грн";
    }
}