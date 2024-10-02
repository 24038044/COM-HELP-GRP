import javax.swing.*;
import java.util.ArrayList;

class Person {
    public String name;
    public String surname;
    public String[] categories = {"Groceries", "Water and Electricity", "Travel", "Cell", "Other"};
    public double other;
}

class PaySlip extends Person {
    
    public double income;
    public double taxDeduction;

    public PaySlip() {
        income = getValidDoubleInput(name + " " + surname + ", please type in your Gross Monthly income (before deductions):");
        if (income > 0) {
            taxDeduction = getValidDoubleInput("Then type in your estimated monthly tax deduction:");
            if (taxDeduction > 0) {
                JOptionPane.showMessageDialog(null, calculateTaxPercentage(income, taxDeduction));
            } else {
                showError("Please input a valid, non-zero and non-negative amount for tax deduction.");
            }
        } else {
            showError("Please input a valid, non-zero and non-negative amount for income.");
        }
        System.out.println(name + " " + surname + ", your monthly income before deduction is " + income + " and your deducted amount is " + taxDeduction);
    }

    public String calculateTaxPercentage(double income, double taxDeduction) {
        if (income > taxDeduction) {
            double taxPercent = (taxDeduction / income) * 100;
            return "Your tax percentage is " + taxPercent + "%";
        } else {
            return "Error: your estimated monthly tax deduction is greater than your income.";
        }
    }

    public double getValidDoubleInput(String message) {
        double value;
        while (true) {
            try {
                String input = JOptionPane.showInputDialog(message);
                value = Double.parseDouble(input);
                if (value >= 0) {
                    break;
                }else{
                JOptionPane.showMessageDialog(null, "Please enter a valid non-negative number.");
                }  
            } catch (NumberFormatException e) {
                showError("Please type in a numerical value");
            }

        }
        return value;
    }

    private void showError(String message) {
        JOptionPane.showMessageDialog(null, message);
    }
}

// The remaining classes should similarly incorporate the above improvements.
class Expenditures extends PaySlip { // Moved here for accessibility of PaySlip attributes
    protected double estimatedRemains; 
    ArrayList<Double> expenditureList = new ArrayList<>();

    public Expenditures() {
        
        double totalExpense = 0.0;

        int expenses = JOptionPane.showConfirmDialog(null, "Would you like to enter an estimated amount for the following categories of expenditures?", "Monthly Expenditures", JOptionPane.YES_NO_OPTION);
        
        if (expenses == JOptionPane.YES_OPTION) {
            double groceries = Double.parseDouble(JOptionPane.showInputDialog("Please enter your estimated grocery costs:"));
                if (groceries < 0) {
                    JOptionPane.showMessageDialog(null, "Please enter the correct value non-zero values");
                    // double groceries = Double.parseDouble(JOptionPane.showInputDialog("Please enter your estimated grocery costs:"));
                }else {
                    expenditureList.add(groceries);
                }
            
            double waterAndElectricity = Double.parseDouble(JOptionPane.showInputDialog("Please enter your estimated water and electricity costs:"));
                if (waterAndElectricity < 0) {
                    JOptionPane.showMessageDialog(null, "Please enter the correct value non-zero values");
                }else {
                    expenditureList.add(waterAndElectricity);
                }
            
            double travel = Double.parseDouble(JOptionPane.showInputDialog("Please enter your estimated travel costs, including petrol, lodging, etc.:"));
                if (travel < 0) {
                    JOptionPane.showMessageDialog(null, "Please enter the correct value non-zero values");
                }else {
                    expenditureList.add(travel);
                }
            
            double cell = Double.parseDouble(JOptionPane.showInputDialog("Please enter your cellphone and/or telephone costs combined:"));
                if (cell < 0) {
                    JOptionPane.showMessageDialog(null, "Please enter the correct value non-zero values");
                }else {
                    expenditureList.add(cell);
                }

                // for (int i = 0; i < expenditureList.size(); i++) {
                //     double expenses[] = {expenditureList.get(0),expenditureList.get(1),expenditureList.get(2),expenditureList.get(3)};
                // }
                    if (JOptionPane.showConfirmDialog(null, "Do you have more/other expenses to list?") == JOptionPane.YES_OPTION) {
                        other = Double.parseDouble(JOptionPane.showInputDialog("Please enter the summed amount of all 'other' expenses:"));
                        if (other < 0) {
                            JOptionPane.showMessageDialog(null,"Please enter a value above Zero(0)");
                        }else {
                            expenditureList.add(other);
                        }
                    }
                System.out.println(name + ", the amounts you have entered have been recorded as " + "\n" + "Groceries\t\t" + groceries + "\nWater and Electricity\t"+waterAndElectricity +"\nTravel Costs\t\t"+travel+"\nCellphone\t\t"+cell+"\nOther costs\t\t"+other);
                //use for-each to loop everything on expenditureList array and then use its attribute expense to calculate the totalExpense
                for (double expense : expenditureList) {
                    totalExpense += expense;
                    // totalExpense = totalExpense + expense;
                }
                //then use the totalExpense to find the estimatedRemains which we will use on HousingOptions
                estimatedRemains = income - taxDeduction - totalExpense; 
                    if (OverSpending(estimatedRemains)) {
                        JOptionPane.showMessageDialog(null,name + ", you are overspending...");
                    }else {
                        JOptionPane.showMessageDialog(null, "With tax deducted and total expenses paid for, your estimated account stands at R" + estimatedRemains);
                        }
        } else {
            JOptionPane.showMessageDialog(null, "You have not recorded any expenditure.");
        }
    }

    public static boolean OverSpending(double number) {
        return number < 0;
    }
}

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
class HousingOptions extends Expenditures {
    public double processHousing() {
        double availableAmount;
        availableAmount = estimatedRemains;
        if (OverSpending(availableAmount)) {
            JOptionPane.showMessageDialog(null,name + ", you are overspending and cannot afford a place to stay");
        } else {
            
            // System.out.println("Welcome, " + name + " " + surname);
            // System.out.println("These are the expenditures paid...");

            // double[] expenditurelist = new double[expenditureList.size()];
            // expenditurelist = expenditureList.toArray(expenditurelist);
            // int count = 0;
            int rentChoice = JOptionPane.showConfirmDialog(null, "Do you want to rent an apartment?", "Rent or Buy", JOptionPane.YES_NO_OPTION);
                
            if (rentChoice == JOptionPane.NO_OPTION) {
                
                int buyingchoice = JOptionPane.showConfirmDialog(null, "Do you want to buy property?", "Rent or Buy", JOptionPane.YES_NO_OPTION);

                if (buyingchoice == JOptionPane.NO_OPTION) {
                    JOptionPane.showMessageDialog(null, "You do not have a place to stay.");
                } else {
                    MonthlyHomeLoanRepayments(availableAmount);
                }
            } else {
                double rentAmount = Double.parseDouble(JOptionPane.showInputDialog("Enter the monthly rental amount:"));
                if (OverSpending(estimatedRemains)) {
                    JOptionPane.showMessageDialog(null, name +", you are overspending and do not qualify for a house or to rent.");
                }else{
                    if (rentAmount < 0) {
                        JOptionPane.showMessageDialog(null, name + " please type in the correct no-zero amount.");
                    } else {
                        JOptionPane.showMessageDialog(null, "You have chosen to rent an apartment at R" + rentAmount);
                        availableAmount = estimatedRemains - rentAmount; // Use the calculated estimatedRemains from Expenditures
                        System.out.println(name + ", you have chosen to rent a R" + rentAmount + " apartment\nYour remaining balance after paying your rent is R"+availableAmount);
                        // choice(availableAmount);
                        if (availableAmount < 0) {
                            JOptionPane.showMessageDialog(null, "You do not qualify for a R" + rentAmount + " apartment.");
                        }else {
                            JOptionPane.showMessageDialog(null, "Available monthly money after all specified deductions have been made: R" + availableAmount); 
                        }
                    }
                }
            }
            // new CarChoice();
            return estimatedRemains;
        }
        return estimatedRemains;  // Always return the remaining balance.
    }
    public static void MonthlyHomeLoanRepayments(double remaining) {
        double amount = Double.parseDouble(JOptionPane.showInputDialog("Enter the purchase price of the property: "));
        double totalDeposit = Double.parseDouble(JOptionPane.showInputDialog("Enter the total deposit: "));
        double interestRate = Double.parseDouble(JOptionPane.showInputDialog("Enter the annual interest rate: "));
        int years = Integer.parseInt(JOptionPane.showInputDialog("Enter the Loan Term in years (Between 20 and 30): "));
            if ((amount < 0) || (totalDeposit < 0) || (interestRate < 0 ) || (years < 0)) {
                JOptionPane.showMessageDialog(null,"Please enter the correct amount, as asked. No negative numbers");
                MonthlyHomeLoanRepayments(remaining);
            }else {    
                remaining = remaining - totalDeposit;    
                double loanAmount = amount - totalDeposit;
                if (OverSpending(remaining)){
                    JOptionPane.showMessageDialog(null,"You do not qualify to buy this property.");
                    // new HousingOptions();
                }else {
                    int months = years * 12;
                    double monthlyInterestRate = (interestRate / 12 / 100);
                    displayAmortizationTable(loanAmount, monthlyInterestRate, months);
                }
            }
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
        if (payment > balance) {

        JOptionPane.showMessageDialog(null, "You do not qualify to buy this property.");

        }else{

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
}


///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////This is the slot for the caarchoice extension
class CarChoice {
    public static void choice(double remainingAmount) {
        int buyingCars = JOptionPane.showConfirmDialog(null, "Do you want to purchase a vehicle?", "WeBuyCars.com", JOptionPane.YES_NO_OPTION);
        double price, deposit, insurance, interest, loanAmount, monthlyPayment;
        int loanTerm = 60; // Example: loan term of 5 years (60 months)

        if (buyingCars == JOptionPane.YES_OPTION) {
            System.out.println("These are the options you have, please choose from 1 - 5");

            String[][] carChoices = {
                {"Model & Make", "Purchase Price", "Total Deposit", "Interest Rate", "Insurance"},
                {"Toyota Corolla", "428402.00", "85680.40", "4.54543", "20563.30"},
                {"Honda Civic", "376993.76", "68544.32", "5.90038", "18849.69"},
                {"Ford Focus", "342721.60", "59976.28", "6.44007", "22276.90"},
                {"BMW 3 Series", "685443.20", "137088.64", "4.44573", "30844.94"},
                {"Tesla Model 3", "771123.60", "171360.80", "4.89577", "34272.16"}
            };

            // Display car choices
            for (int row = 0; row < carChoices.length; row++) {
                System.out.print(row + "\t");
                for (int column = 0; column < carChoices[row].length; column++) {
                    System.out.print(carChoices[row][column] + "\t");
                }
                System.out.println();
            }
            // Get user choice
            int choice = Integer.parseInt(JOptionPane.showInputDialog(null, "Please insert the choice of your vehicle (1 - 5)"));
            if (choice >= 1 && choice <= 5) {
                JOptionPane.showMessageDialog(null, "You have chosen the following model and make: " + carChoices[choice][0]);

                // Assign car details
                price = Double.parseDouble(carChoices[choice][1]);
                deposit = Double.parseDouble(carChoices[choice][2]);
                interest = Double.parseDouble(carChoices[choice][3]);
                insurance = Double.parseDouble(carChoices[choice][4]);

                if (OverSpending(remainingAmount)) {
                    JOptionPane.showMessageDialog(null,"You do not qualify to buy a car, you are overspending");
                } else {
                    // Loan and monthly payment calculation
                    loanAmount = price - deposit;
                    double monthlyInterestRate = interest / 100 / 12;
                    monthlyPayment = (loanAmount * monthlyInterestRate) / (1 - Math.pow(1 + monthlyInterestRate, -loanTerm));
                    monthlyPayment += insurance / 12; // Include insurance

                    double affordabilityThreshold = remainingAmount * 0.30;

                    if (monthlyPayment <= affordabilityThreshold) {
                        JOptionPane.showMessageDialog(null, "Congratulations! You qualify to purchase this vehicle. Your monthly payment is: R" + String.format("%.2f", monthlyPayment));
                    } else {
                        JOptionPane.showMessageDialog(null, "Unfortunately, you do not qualify to purchase this vehicle. Your monthly payment is: R" + String.format("%.2f", monthlyPayment) + ", which exceeds 30% of your available balance.");
                    }
                }

            } else {
                JOptionPane.showMessageDialog(null, "Please insert a number between 1 and 5.");
            }
        }
    }
}

public class Property24_1 {
    public static void main(String[] args) {
        HousingOptions housingOptions = new HousingOptions();
        double remainingBalance = housingOptions.processHousing();
        CarChoice.choice(remainingBalance);
    }
}
