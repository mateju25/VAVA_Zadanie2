package app.model;

import java.util.ArrayList;

public class RentSystem {
    private static RentSystem single_instance = null;
    private final ArrayList<Rent> listOfRents = new ArrayList<>();
    private final ArrayList<Employer> listOfEmployers = new ArrayList<>();
    private final ArrayList<Specialist> listOfSpecialists = new ArrayList<>();

    private RentSystem() {
        ArrayList<String> list = new ArrayList<>();
        list.add("Programátor");
        listOfEmployers.add(new Employer("Siemens", "Healthcare", 400, null, list));
        list = new ArrayList<>();
        list.add("Java oracle certificate");
        listOfSpecialists.add(new SafetyConsultant("Matej Delincak", false, 123, "2 roky", "STU FIIT", list, false));
    }

    public static RentSystem getInstance()
    {
        if (single_instance == null) {
            single_instance = new RentSystem();
        }

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

    public void addEmployer(Employer newEmp) {
        for (Employer old :
                listOfEmployers) {
            if (newEmp.getName().equals(old.getName()))
                return;
        }
        listOfEmployers.add(newEmp);
    }

    public void addSpecialist(Specialist newEmp) {
        for (Specialist old :
                listOfSpecialists) {
            if (newEmp.getName().equals(old.getName()))
                return;
        }
        listOfSpecialists.add(newEmp);
    }

    public boolean removeEmployer(Employer newEmp) {
        for (Employer old :
                listOfEmployers) {
            if (newEmp.getName().equals(old.getName())) {
                listOfEmployers.remove(old);
                return true;
            }
        }
        return false;
    }

    public boolean removeSpecialist(Specialist newEmp) {
        for (Specialist old :
                listOfSpecialists) {
            if (newEmp.getName().equals(old.getName())) {
                listOfSpecialists.remove(old);
                return true;
            }
        }
        return false;
    }
}
