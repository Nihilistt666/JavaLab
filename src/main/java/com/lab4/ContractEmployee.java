package com.lab4;

public class ContractEmployee extends Employee {
    private int contractDurationMonths;

    public ContractEmployee(String fullName, String position, double salary, String department,
                            int experienceYears, int contractDurationMonths) {
        super(fullName, position, salary, department, experienceYears);
        this.contractDurationMonths = contractDurationMonths;
    }

    @Override
    public String getType() { return "ContractEmployee"; }

    @Override
    public String toString() {
        return super.toString() + " | Контракт: " + contractDurationMonths + " міс.";
    }

    @Override
    public String toFileString() {
        return getType() + "|" + getFullName() + "|" + getPosition() + "|" + getSalary() + "|"
                + getDepartment() + "|" + getExperienceYears() + "|" + contractDurationMonths;
    }
}
