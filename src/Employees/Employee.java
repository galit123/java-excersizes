package Employees;


import java.util.ArrayList;
import java.util.List;

public class Employee {

//    Employee -name,Id,department
//    Manager -
//    list of employees(Employee)

    private String name;
    private String id;

    public Employee(String name, String id, String department) {
        this.name = name;
        this.id = id;
        this.department = department;
    }

    private String department;

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public String getDepartment() {
        return department;
    }

    public String getType() {
        return "Employee";
    }

    public static List<Employee> alreadyPrinted = new ArrayList<Employee>();

    public void print(String pref) {
        System.out.println(pref + "Role: " + getType() + " ");
        System.out.println(pref + "Name: " + getName());
        System.out.println(pref + "Id: " + getId());
        System.out.println(pref + "Department: " + getDepartment());
    }

    public static void printEmployeesHirarchy(Employee e) {
        alreadyPrinted.clear();
        if (e == null) {
            throw new RuntimeException("employee not found");
        }

        e.print("\t");
    }

    public static void main(String[] args) {

        Employee e1 = new Employee("Shaul", "0001", "RND");
        Employee e2 = new Employee("Yossi", "0002", "RND");
        Employee e3 = new Employee("Meni", "0003", "RND");
        Manager m1 = new Manager("Yaki", "0004", "RND");
        Manager m2 = new Manager("Kobi", "0005", "RND");
        Manager e4 = new Manager("Hana", "0006", "HR");


        m1.add(e1);
        m1.add(e2);
        m2.add(e3);
        m2.add(m1);
        m2.add(e4);
        m1.add(m2);

        printEmployeesHirarchy(m2);

    }
}