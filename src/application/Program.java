package application;

import entities.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.CANADA);
        Scanner scan = new Scanner(System.in);

        System.out.print("How many employees will be registered: ");
        int numOfEmp = scan.nextInt();

        List<Employee> emps = new ArrayList<>();
        for (int i = 0; i < numOfEmp; i++){
            System.out.println("Employee #" + (i + 1));
            System.out.print("Id: ");
            Integer id = scan.nextInt();
            System.out.print("Name: ");
            scan.nextLine();
            String name = scan.nextLine();
            System.out.print("salary: ");
            Double salary = scan.nextDouble();

            emps.add(new Employee(id, name, salary));
        }

        makeDiv();
        showEmps(emps);

        makeDiv();
        System.out.println("Id of employee to receive a salary increase: ");
        int increaseId  = scan.nextInt();
        Employee emp = emps.stream().filter(x -> x.getId() == increaseId).findFirst().orElse(null);
        if (emp != null){
            System.out.println("Percentage of salary increment: ");
            double percentage = scan.nextDouble();
            emp.increaseSalary(percentage);
        } else {
            System.out.println("There is no occurrence of this ID in our system.");
        }

        makeDiv();
        showEmps(emps);

        scan.close();
    }

    public static void showEmps(List<Employee> emps){
        System.out.println("Employees: ");
        for (Employee x : emps){
            System.out.println(x);
        }
    }
    public static void makeDiv(){
        for (int i = 0; i < 20; i++){
            System.out.print("=");
        }
        System.out.println("\n");
    }
}
