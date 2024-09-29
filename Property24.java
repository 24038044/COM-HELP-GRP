/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dion.mavenproject4;

/**
 *
 * @author Apex
 */
import javax.swing.JOptionPane;
import java.util.ArrayList;

class Person {
    protected String name = JOptionPane.showInputDialog("Enter your first name>>");
    protected String surname = JOptionPane.showInputDialog("Enter your last name>>");
}

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////0/////////

class PaySlip extends Person {
    ArrayList<Double> Income_tax = new ArrayList<Double>();
    protected double income;
    protected double taxDeduction;

    public PaySlip() {
        income = Double.parseDouble(JOptionPane.showInputDialog(name + " " + surname + ", please type in your Gross Monthly income (before deductions):"));
        Income_tax.add(income);
        taxDeduction = Double.parseDouble(JOptionPane.showInputDialog("Then type in your estimated monthly tax deduction:"));
        Income_tax.add(taxDeduction);
        JOptionPane.showMessageDialog(null, tax(income, taxDeduction));
    }
     //method for tax percentage%
    public String tax(double income, double taxDeduction) {
        if (income > taxDeduction) {
            double taxPercent = (taxDeduction / income) * 100;
            return "Your tax percentage is " + taxPercent + "%";
        } else {
            return "There has been an error; your estimated monthly tax deduction is greater than your income.";
        }
    }
}


///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


class Expenditures extends PaySlip { // Moved here for accessibility of PaySlip attributes
    protected double estimatedRemains; 

    public Expenditures() {
        ArrayList<Double> expenditureList = new ArrayList<>();
        double totalExpense = 0.0;

        int expenses = JOptionPane.showConfirmDialog(null, "Would you like to enter an estimated amount for the following categories of expenditures?", "Monthly Expenditures", JOptionPane.YES_NO_OPTION);
        
        if (expenses == JOptionPane.YES_OPTION) {
            double groceries = Double.parseDouble(JOptionPane.showInputDialog("Please enter your estimated grocery costs:"));
            expenditureList.add(groceries);
            
            double waterAndElectricity = Double.parseDouble(JOptionPane.showInputDialog("Please enter your estimated water and electricity costs:"));
            expenditureList.add(waterAndElectricity);
            
            double travel = Double.parseDouble(JOptionPane.showInputDialog("Please enter your estimated travel costs, including petrol, lodging, etc.:"));
            expenditureList.add(travel);
            
            double cell = Double.parseDouble(JOptionPane.showInputDialog("Please enter your cellphone and/or telephone costs combined:"));
            expenditureList.add(cell);
            
            if (JOptionPane.showConfirmDialog(null, "Do you have more/other expenses to list?") == JOptionPane.YES_OPTION) {
                double other = Double.parseDouble(JOptionPane.showInputDialog("Please enter the summed amount of all 'other' expenses:"));
                expenditureList.add(other);
            }
             //use for-each to loop everything on expenditureList array and then use its attribute expense to calculate the totalExpense
            for (double expense : expenditureList) {
                totalExpense += expense;
            }
              //then use the totalExpense to find the estimatedRemains which we will use on HousingOptions
            estimatedRemains = income - taxDeduction - totalExpense; 
            JOptionPane.showMessageDialog(null, "With tax deducted and total expenses paid for, your estimated account stands at R" + estimatedRemains);
        } else {
            JOptionPane.showMessageDialog(null, "You have not recorded any expenditure.");
        }
    }
}

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

class HousingOptions extends Expenditures {
    public HousingOptions() {
        
        int rentChoice = JOptionPane.showConfirmDialog(null, "Do you want to rent an apartment?", "Rent or Buy", JOptionPane.YES_NO_OPTION);
        
        if (rentChoice == JOptionPane.NO_OPTION) {
            if (JOptionPane.showConfirmDialog(null, "Do you want to buy property?", "Rent or Buy", JOptionPane.YES_NO_OPTION) == JOptionPane.NO_OPTION) {
                JOptionPane.showMessageDialog(null, "You do not have a place to stay.");
            } else {
                MonthlyHomeLoanRepayments();
            }
        } else {
            double rentAmount = Double.parseDouble(JOptionPane.showInputDialog("Enter the monthly rental amount:"));
            JOptionPane.showMessageDialog(null, "You have chosen to rent an apartment at R" + rentAmount);
            double availableAmount = estimatedRemains - rentAmount; // Use the calculated estimatedRemains from Expenditures
            JOptionPane.showMessageDialog(null, "Available monthly money after all specified deductions have been made: R" + availableAmount); 
        }
    }

    public static void MonthlyHomeLoanRepayments() {
        double amount = Double.parseDouble(JOptionPane.showInputDialog("Enter the purchase price of the property: "));
        double totalDeposit = Double.parseDouble(JOptionPane.showInputDialog("Enter the total deposit: "));
        double interestRate = Double.parseDouble(JOptionPane.showInputDialog("Enter the annual interest rate: "));
        int years = Integer.parseInt(JOptionPane.showInputDialog("Enter the Loan Term in years (Between 20 and 30): "));
        
        double loanAmount = amount - totalDeposit;
        int months = years * 12;
        double monthlyInterestRate = (interestRate / 12 / 100);
        
        displayAmortizationTable(loanAmount, monthlyInterestRate, months);
    }

    public static double MonthlyPayment(double amount, double rate, int months){
        return (rate * amount)/(1- Math.pow(1 + rate, -months));
        
    }
    // fuction to display Amortization Table
    public static void displayAmortizationTable(double amount, double rate, int months) {
        double balance = amount;
        double payment = MonthlyPayment(amount, rate, months);
        double irPaid, amountPaid, newBalance;
        
        // display the header row
        System.out.printf("%12s %12s %12s %12s %12s %12s%n", "Month",
           "Old Balance", "Payment", "Interest", "Principal", "New Balance");
        System.out.printf("%12s %12s %12s %12s %12s %12s%n", "============",
           "============", "============", "============", "============", "============");
        
        for (int month = 1; month<=months; month++){
            irPaid = balance * rate;
            amountPaid = payment - irPaid;
            newBalance = balance - amountPaid;
          //display the table row
            System.out.printf("%12d %12.2f %12.2f %12.2f %12.2f %12.2f%n", month,
           balance, payment, irPaid, amountPaid, newBalance);
            // update balance
            balance = newBalance;   
        }     
    }
}
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
class Cars extends HousingOptions {
    public static void OptionCars() {

    }

}

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

public class Property24 { ///now summary of everything in the main method 
    public static void main(String[] args) {
        new HousingOptions(); //then create an istance of class HousingOptions which inherited Attributes from personal to Payslip to Expenditure
    }
}

