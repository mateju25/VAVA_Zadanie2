package app.model;

public class Specialist {
    protected boolean isTaken;
    protected double cost;
    protected String lengthOfPractice;
    protected String highestEducation;
    protected String certificates;

    public Specialist(boolean isTaken, double cost, String lengthOfPractice, String highestEducation, String certificates) {
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

    public String getCertificates() {
        return certificates;
    }

    public void setTaken(boolean taken) {
        isTaken = taken;
    }
}
