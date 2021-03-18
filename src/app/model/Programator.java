package app.model;

public class Programator extends Specialist{
    private String focusType;

    public Programator(boolean isTaken, double cost, String lengthOfPractice, String highestEducation, String certificates, String focusType) {
        super(isTaken, cost, lengthOfPractice, highestEducation, certificates);
        this.focusType = focusType;
    }

    public String getFocusType() {
        return focusType;
    }
}
