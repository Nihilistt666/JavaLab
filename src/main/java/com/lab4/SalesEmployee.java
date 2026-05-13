package com.lab4;

public class SalesEmployee extends FullTimeEmployee {
    private double salesTarget;

    public SalesEmployee(String fullName, String position, double salary, String department,
                         int experienceYears, double bonusPercentage, double salesTarget) {
        super(fullName, position, salary, department, experienceYears, bonusPercentage);
        this.salesTarget = salesTarget;
    }

    public double getSalesTarget() {
        return salesTarget;
    }

    @Override
    public String getType() { return "SalesEmployee"; }

    @Override
    public String toString() {
        return super.toString() + " | План продажів: " + salesTarget;
    }

    @Override
    public String toFileString() {
        return getType() + "|" + getFullName() + "|" + getPosition() + "|" + getSalary() + "|"
                + getDepartment() + "|" + getExperienceYears() + "|" + getBonusPercentage() + "|" + salesTarget;
    }
}