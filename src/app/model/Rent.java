package app.model;

import java.util.ArrayList;

public class Rent {
    private ArrayList<Specialist> employees;
    private Employer company;

    public Rent(ArrayList<Specialist> employees) {
        this.employees = employees;
    }

    public ArrayList<Specialist> getEmployees() {
        return employees;
    }

    public Employer getCompany() {
        return company;
    }


}
