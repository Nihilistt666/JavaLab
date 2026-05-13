package com.lab4;

import java.util.ArrayList;

public class Company {
    private String name;
    private ArrayList<Employee> employees;

    public Company(String name) {
        this.name = name;
        this.employees = new ArrayList<>();
    }

    public void addEmployee(Employee emp, int quantity) {
        if (emp == null || quantity <= 0) return;


        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).equals(emp)) {
                for (int j = 0; j < quantity; j++) {
                    employees.add(emp);
                }
                return;
            }
        }

        for (int i = 0; i < quantity; i++) {
            employees.add(emp);
        }
    }

    public ArrayList<Employee> getEmployees() {
        return new ArrayList<>(employees);
    }

    public int getTotalEmployees() {
        return employees.size();
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Компанія: " + name + " | Кількість працівників: " + employees.size();
    }
}