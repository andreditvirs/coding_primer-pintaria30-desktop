package com.assessment;

import java.util.ArrayList;
import java.util.Scanner;

public class EmployeesExpense {
    public static void main(String[] args) {

        // Variabel temporary for Looping
        int i;
        double budget, salary, expense;
        String category, name, depart;
        ArrayList<Expense> expenses = new ArrayList<Expense>();
        ArrayList<Employee> employees = new ArrayList<Employee>();

        // Loop for Input Category
        int expenseCategoryCounter = inputInt("No of Categories (min. 3) "); // [!] need If < 3 else to keep up to >3 categories
        for(i=0;i<expenseCategoryCounter;i++){
            System.out.println("Enter the details of expense category "+(i+1));
            category = inputString("Category"); // [!] need try catch

            budget = inputDouble("Budget");

            expenses.add(new Expense(category, budget));
        }

        System.out.println("======================================="); // Separator beetwen input categories and employees data

        // Loop for Input Employee
        int employeeCounter;
        employeeCounter = inputInt("No of Employees (min. 3) ");
        for(i=0;i<employeeCounter;i++){
            System.out.println("Enter the details of expense employee "+(i+1));
            name = inputString("Name");
            depart = inputString("Department");
            employees.add(new Employee(name, depart));

            salary =  inputDouble("Salary");

            employees.get(i).setSalary(salary);

            for(int j=0;j<expenseCategoryCounter;j++){
                employees.get(i).getExpenses().add(expenses.get(j)); // Add expanses to all employees one by one
                expense = inputDouble("Expanse Ammount for the category "+expenses.get(j).getCategory());
                employees.get(i).getExpenses().get(j).setExpenseAmount(expense);
            }
        }

        System.out.println(); // Enter for spacing input process and output process


        // Loop for output
        // Declare temporary var to keep status above or bellow
        String status;
        int j, aboveCounter, belowCounter;

        for(i = 0; i<employeeCounter;i++){

            aboveCounter = 0; // Reset above counter for every looping
            belowCounter = 0; // Reset below counter for every looping

            System.out.println(employees.get(i).getName()+"\t\t\t\t\t"+employees.get(i).getDepartment()+"\t"+employees.get(i).getSalary());
            for(j = 0;j<expenseCategoryCounter;j++){
                status = showStatusofExpenses(expenses.get(j).getBudgetAmount(), expenses.get(j).getExpenseAmount());
                if(status.equals("Above")){
                    aboveCounter++;
                }else{
                    belowCounter++;
                }
                System.out.println("\t"+expenses.get(j).getCategory()+"\t\t\t"+expenses.get(j).getBudgetAmount()+"\t\t"+employees.get(i).getExpenses().get(j).getExpenseAmount()+" "+status);
            }
            System.out.println("Above Budget = "+aboveCounter+" categories");
            System.out.println("Below Budget = "+belowCounter+" categories");
            System.out.println("Savings = "+countSaving(employees.get(i).getSalary(), employees));
            System.out.println("-------------------------------------------------");

            System.out.println(); // Make a space to other empolyee's data
        }

        System.out.println("======================================="); // Make a space to mark End of Data Process
    }

    // Method to show status of expanses, is that above or below?
    private static String showStatusofExpenses(double budget, double expense){
        if(expense >= budget){
            return "Above";
        }else{
            return "Below";
        }
    }

    // Method to count saving every employee
    public static double countSaving(double salary, ArrayList<Employee> employees){
        double savings, sumExpanses=0;
        int i = 0, j = 0;
        while(i<employees.size()){
            while(j<employees.get(i).getExpenses().size()){
                sumExpanses += employees.get(i).getExpenses().get(j).getExpenseAmount();
                j++;
            }
            i++;
        }

        savings = salary - sumExpanses;
        return savings;
    }

    // Special scanner for inputing string
    public static String inputString(String message){
        Scanner sc = new Scanner(System.in);
        System.out.print(message+ " - ");
        String result =  sc.nextLine();
        return result;
    }

    public static Double inputDouble(String message){
        Scanner sc = new Scanner(System.in);
        System.out.print(message+ " - ");
        double result =  sc.nextDouble();
        return result;
    }

    public static int inputInt(String message){
        Scanner sc = new Scanner(System.in);
        System.out.print(message+ " - ");
        int result = sc.nextInt();
        return result;
    }
}
