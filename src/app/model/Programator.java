package app.model;

import java.util.ArrayList;

public class Programator extends Specialist{
    private final String focusType;

    public Programator(String name, boolean isTaken, double cost, String lengthOfPractice, String highestEducation, ArrayList<String> certificates, String focusType) {
        super(name, isTaken, cost, lengthOfPractice, highestEducation, certificates);
        this.focusType = focusType;
    }

    public String getFocusType() {
        return focusType;
    }
}
