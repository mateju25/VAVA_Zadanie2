package app.model;

import java.util.ArrayList;

public class Rent {
    private final ArrayList<Specialist> employees;
    private final Employer company;

    public Rent(ArrayList<Specialist> employees, Employer company) {
        this.employees = employees;
        this.company = company;
    }

    public ArrayList<Specialist> getEmployees() {
        return employees;
    }

    public String getInfo() {
        String res = "Firma " + company.getName() + " zamestnáva ";
        for (Specialist spec :
                employees) {
            res += spec.getName() + ", ";
        }
        return res;
    }


}
