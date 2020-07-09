package Employees;

import java.util.ArrayList;
import java.util.List;

public class Manager extends Employee {
    List<Employee> workers = new ArrayList<Employee>();

    public void add(Employee e) {
        workers.add(e);
    }

    public Manager(String name, String id, String department) {
        super(name, id, department);
    }

    @Override
    public void print(String pref) {
        super.print(pref);

        System.out.println(pref + "List of workers: ");

        String newPref = "\t" + pref;
        int i = 1;
        for (Employee e : workers) {
            if (!alreadyPrinted.contains(e)) {
                alreadyPrinted.add(e);

                System.out.print(newPref + i + ") ");
                e.print(newPref);
                System.out.println();
                i++;
            }
        }
        System.out.println();
    }

    @Override
    public String getType() {
        return "Manager";
    }
}

