package com.assessment;

import java.util.ArrayList;

public class Employee implements IExpense{
    private String name;
    private String department;
    private double salary;
    private ArrayList<Expense> expenses = new ArrayList<Expense>();

    public Employee(String name, String department){
        this.name = name;
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public ArrayList<Expense> getExpenses() {
        return expenses;
    }

    public void setExpenses(ArrayList<Expense> expenses) {
        this.expenses = expenses;
    }

    @Override
    public double calculateSavings(ArrayList<Expense> expenses) {
        return 0;
    }
}
