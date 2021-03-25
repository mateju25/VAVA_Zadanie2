package app.model;

import java.util.ArrayList;

public class Specialist {
    protected final String name;
    protected boolean isTaken;
    protected final double cost;
    protected final String lengthOfPractice;
    protected final String highestEducation;
    protected final ArrayList<String> certificates;

    public Specialist(String name, boolean isTaken, double cost, String lengthOfPractice, String highestEducation, ArrayList<String> certificates) {
        this.name = name;
        this.isTaken = isTaken;
        this.cost = cost;
        this.lengthOfPractice = lengthOfPractice;
        this.highestEducation = highestEducation;
        this.certificates = certificates;
    }

    public boolean isTaken() {
        return isTaken;
    }

    public double getCost() {
        return cost;
    }

    public String getLengthOfPractice() {
        return lengthOfPractice;
    }

    public String getHighestEducation() {
        return highestEducation;
    }

    public ArrayList<String> getCertificates() {
        return certificates;
    }

    public String getName() {
        return name;
    }

    public void setTaken(boolean taken) {
        isTaken = taken;
    }
}
