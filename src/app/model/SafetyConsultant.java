package app.model;

import java.util.ArrayList;

public class SafetyConsultant extends Specialist{
    private final boolean isInNBU;

    public SafetyConsultant(String name, boolean isTaken, double cost, String lengthOfPractice, String highestEducation, ArrayList<String> certificates, boolean isInNBU) {
        super(name, isTaken, cost, lengthOfPractice, highestEducation, certificates);
        this.isInNBU = isInNBU;
    }

    public boolean isInNBU() {
        return isInNBU;
    }
}
