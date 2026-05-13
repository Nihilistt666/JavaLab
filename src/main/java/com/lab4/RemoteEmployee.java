package com.lab4;

public class RemoteEmployee extends FullTimeEmployee {
    private String remoteLocation;

    public RemoteEmployee(String fullName, String position, double salary, String department,
                          int experienceYears, double bonusPercentage, String remoteLocation) {
        super(fullName, position, salary, department, experienceYears, bonusPercentage);
        this.remoteLocation = remoteLocation;
    }

    public String getRemoteLocation() {
        return remoteLocation;
    }

    @Override
    public String getType() { return "RemoteEmployee"; }

    @Override
    public String toString() {
        return super.toString() + " | Віддалена: " + remoteLocation;
    }

    @Override
    public String toFileString() {
        return getType() + "|" + getFullName() + "|" + getPosition() + "|" + getSalary() + "|"
                + getDepartment() + "|" + getExperienceYears() + "|" + getBonusPercentage() + "|" + remoteLocation;
    }
}