package app.model;

import java.util.ArrayList;

public class Administrator extends Programator{
    private final String preferedSystem;

    public Administrator(String name, boolean isTaken, double cost, String lengthOfPractice, String highestEducation, ArrayList<String> certificates, String focusType, String preferedSystem) {
        super(name, isTaken, cost, lengthOfPractice, highestEducation, certificates, focusType);
        this.preferedSystem = preferedSystem;
    }

    public String getPreferedSystem() {
        return preferedSystem;
    }
}
