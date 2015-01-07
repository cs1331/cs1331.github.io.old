package edu.gatech.cs1331.companygui;

import java.util.Calendar;
import java.util.Date;

public abstract class Employee {

    private String name;
    private Date hireDate;

    public Employee(Employee other) {
        this.name = other.name;
        this.hireDate = other.hireDate;
    }

    public Employee(String aName, Date aHireDate) {
        disallowNullArguments(aName, aHireDate);
        name = aName;
        hireDate = aHireDate;
    }

    public double monthlyPay() {
        Calendar rightNow = Calendar.getInstance();
        return monthlyPay(rightNow);
    }

    public abstract double monthlyPay(Calendar calendar);

    public String getName() {
        return name;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public String toString() {
        return name + "; " + hireDate;
    }

    public boolean equals(Object other) {
        if (other == null) return false;
        if (this == other) return true;
        if (!(other instanceof Employee)) return false;
        Employee that = (Employee) other;
        return name.equals(that.name) && hireDate.equals(that.hireDate);
    }

    private void disallowNullArguments(Object ... args) {
        boolean shouldThrowException = false;
        String nullArgs = "";
        for (Object arg: args) {
            if (arg == null) {
                shouldThrowException = true;
                nullArgs += arg + " ";
            }
        }
        if (shouldThrowException) {
            String msg = "null arguments not allowed. ";
            throw new IllegalArgumentException(msg);
        }
    }

    protected void disallowZeroesAndNegatives(double ... args) {
        boolean shouldThrowException = false;
        String nonPositives = "";
        for (double arg: args) {
            if (arg <= 0.0) {
                shouldThrowException = true;
                nonPositives += arg + " ";
            }
        }
        if (shouldThrowException) {
            String msg = "Following arguments were <= 0: " + nonPositives;
            throw new IllegalArgumentException(msg);
        }
    }
}
