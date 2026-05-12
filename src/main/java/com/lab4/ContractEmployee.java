package com.lab4;

public class ContractEmployee extends Employee {
    private int contractDurationMonths;

    public ContractEmployee(String fullName, String position, double salary,
                            String department, int experienceYears,
                            String phoneNumber, boolean isFullTime, int contractDurationMonths) {
        super(fullName, position, salary, department, experienceYears, phoneNumber, isFullTime);
        this.contractDurationMonths = contractDurationMonths;
    }

    @Override
    public String toString() {
        return super.toString() + " | Тип: Контракт | Тривалість: " + contractDurationMonths + " міс.";
    }
}
