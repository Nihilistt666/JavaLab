package com.lab4;

public class RemoteEmployee extends FullTimeEmployee {
    private String remoteLocation;

    public RemoteEmployee(String fullName, String position, double salary, String department,
                          int experienceYears, double bonusPercentage, String remoteLocation) {
        super(fullName, position, salary, department, experienceYears, bonusPercentage);
        this.remoteLocation = remoteLocation;
    }

    @Override
    public String toString() {
        return super.toString() + " | Віддалена робота: " + remoteLocation;
    }
}
