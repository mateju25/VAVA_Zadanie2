package app.model;

import java.util.ArrayList;

public class RentSystem {
    private static RentSystem single_instance = null;
    private final ArrayList<Rent> listOfRents = new ArrayList<>();
    private final ArrayList<Employer> listOfEmployers = new ArrayList<>();
    private final ArrayList<Specialist> listOfSpecialists = new ArrayList<>();

    private RentSystem() {}

    public static RentSystem getInstance()
    {
        if (single_instance == null)
            single_instance = new RentSystem();

        return single_instance;
    }

    public ArrayList<Rent> getListOfRents() {
        return listOfRents;
    }

    public ArrayList<Employer> getListOfEmployers() {
        return listOfEmployers;
    }

    public ArrayList<Specialist> getListOfSpecialists() {
        return listOfSpecialists;
    }
}
