package com.lab4;

public class FullTimeEmployee extends Employee {
    private double bonusPercentage;

    public FullTimeEmployee(String fullName, String position, double salary, String department,
                            int experienceYears, double bonusPercentage) {
        super(fullName, position, salary, department, experienceYears);
        this.bonusPercentage = bonusPercentage;
    }

    public double getBonusPercentage() {
        return bonusPercentage;
    }

    @Override
    public String getType() { return "FullTimeEmployee"; }

    @Override
    public String toString() {
        return super.toString() + " | Повна зайнятість | Бонус: " + bonusPercentage + "%";
    }

    @Override
    public String toFileString() {
        return getType() + "|" + getFullName() + "|" + getPosition() + "|" + getSalary() + "|"
                + getDepartment() + "|" + getExperienceYears() + "|" + bonusPercentage;
    }
}
