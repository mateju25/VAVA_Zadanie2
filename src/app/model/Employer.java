package app.model;

import java.awt.image.BufferedImage;

public class Employer {
    private String name;
    private String fieldOfBusiness;
    private int count;
    private BufferedImage logo;

    public Employer(String name, String fieldOfBusiness, int count, BufferedImage logo) {
        this.name = name;
        this.fieldOfBusiness = fieldOfBusiness;
        this.count = count;
        this.logo = logo;
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

    public BufferedImage getLogo() {
        return logo;
    }
}
