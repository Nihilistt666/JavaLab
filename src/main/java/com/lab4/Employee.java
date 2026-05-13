package com.lab4;

public abstract class Employee implements Comparable<Employee> {
    private String fullName;
    private String position;
    private double salary;
    private String department;
    private int experienceYears;

    public Employee(String fullName, String position, double salary, String department, int experienceYears) {
        setFullName(fullName);
        setPosition(position);
        setSalary(salary);
        setDepartment(department);
        setExperienceYears(experienceYears);
    }

    public void setFullName(String fullName) {
        if (fullName == null || fullName.trim().isEmpty()) throw new IllegalArgumentException("ПІБ не може бути порожнім");
        this.fullName = fullName.trim();
    }

    public void setPosition(String position) {
        if (position == null || position.trim().isEmpty()) throw new IllegalArgumentException("Посада не може бути порожньою");
        this.position = position.trim();
    }

    public void setSalary(double salary) {
        if (salary <= 0) throw new IllegalArgumentException("Зарплата повинна бути > 0");
        this.salary = salary;
    }

    public void setDepartment(String department) {
        if (department == null || department.trim().isEmpty()) throw new IllegalArgumentException("Відділ не може бути порожнім");
        this.department = department.trim();
    }

    public void setExperienceYears(int experienceYears) {
        if (experienceYears < 0 || experienceYears > 60) throw new IllegalArgumentException("Стаж має бути від 0 до 60");
        this.experienceYears = experienceYears;
    }

    public String getFullName() { return fullName; }
    public String getPosition() { return position; }
    public double getSalary() { return salary; }
    public String getDepartment() { return department; }
    public int getExperienceYears() { return experienceYears; }

    public abstract String getType();

    @Override
    public int compareTo(Employee other) {
        return this.fullName.compareToIgnoreCase(other.fullName);
    }

    @Override
    public String toString() {
        return String.format("Працівник: %s | Посада: %s | Зарплата: %.0f | Відділ: %s",
                fullName, position, salary, department);
    }

    public String toFileString() {
        return getType() + "|" + fullName + "|" + position + "|" + salary + "|" + department + "|" + experienceYears;
    }
}
