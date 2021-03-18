package app.model;

public class Administrator extends Programator{
    private String preferedSystem;

    public Administrator(boolean isTaken, double cost, String lengthOfPractice, String highestEducation, String certificates, String focusType, String preferedSystem) {
        super(isTaken, cost, lengthOfPractice, highestEducation, certificates, focusType);
        this.preferedSystem = preferedSystem;
    }

    public String getPreferedSystem() {
        return preferedSystem;
    }
}
