package app.model;

import javafx.scene.image.Image;

import java.util.ArrayList;

public class Employer {
    private final String name;
    private final String fieldOfBusiness;
    private final int count;
    private final Image logo;
    private final ArrayList<String> positions;

    public Employer(String name, String fieldOfBusiness, int count, Image logo,  ArrayList<String> positions) {
        this.name = name;
        this.fieldOfBusiness = fieldOfBusiness;
        this.count = count;
        this.logo = logo;
        this.positions = positions;
    }

    public String getName() {
        return name;
    }

    public String getFieldOfBusiness() {
        return fieldOfBusiness;
    }

    public int getCount() {
        return count;
    }

    public ArrayList<String> getPositions() {
        return positions;
    }

    public Image getLogo() {
        return logo;
    }
}
