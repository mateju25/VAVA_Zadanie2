package app.model;

public class SafetyConsultant extends Specialist{
    private boolean isInNBU;

    public SafetyConsultant(boolean isTaken, double cost, String lengthOfPractice, String highestEducation, String certificates, boolean isInNBU) {
        super(isTaken, cost, lengthOfPractice, highestEducation, certificates);
        this.isInNBU = isInNBU;
    }

    public boolean isInNBU() {
        return isInNBU;
    }
}
