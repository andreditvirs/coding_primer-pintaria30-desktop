package com.assessment;

public class Expense {

    private String category;
    private double budgetAmount;
    private double expenseAmount;

    public Expense(String category, double budgetAmount){
        this.category = category;
        this.budgetAmount = budgetAmount;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getBudgetAmount() {
        return budgetAmount;
    }

    public void setBudgetAmount(double budgetAmount) {
        this.budgetAmount = budgetAmount;
    }

    public double getExpenseAmount() {
        return expenseAmount;
    }

    public void setExpenseAmount(double expenseAmount) {
        this.expenseAmount = expenseAmount;
    }
}
