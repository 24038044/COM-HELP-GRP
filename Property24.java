import java.util.*;
import javax.swing.*;
import jdk.jshell.ImportSnippet;
    // @author Cee_J
public class Property24 {


    public static void main(String[] args) {
        // TODO code application logic here
        //This is just to get the information of the client in particular...
        //we could also dedicate an array or 10/20 spaces just so we have a record of clients who have used the application and can create a report from it...
        String sname,fsurname;
        sname = JOptionPane.showInputDialog("Enter your first name>>");
        fsurname= JOptionPane.showInputDialog("Enter your last name>>");
        
        //This will be the first dedicated arraylist and the array will be created from the array.size, after all the questions have been answered...
        //We can work on coding that later
        ArrayList<Double> income_tax = new ArrayList<Double>();
            //I think using a scanner here is better for structure purposes and there wont be a messagebox/dialogbox popping out everytime something needs to be typed in...
            Scanner scanner = new Scanner(System.in);
            System.out.println(sname +" "+ fsurname+ ", please type in your Gross Monthly income (before deductions):");
        
            //Collecting data and sending it to the array list, since its an arraylist of only double, it would be best to use it for only prices of expenses and other things...
        double income = scanner.nextDouble();
        income_tax.add(income);
        /////////////////////////////////////////////////////////////////////////////////////////////////////////////
            System.out.println("Then type in your estimated monthly tax deduction:");
            double tax_deduction = scanner.nextDouble();
            income_tax.add(tax_deduction);
        /////////////////////////////////////////////////////////////////////////////////////////////////////////////
            //SHowing your tax percentage
            System.out.println("Your tax percentage is as follows: " + tax(income,tax_deduction));
        /////////////////////////////////////////////////////////////////////////////////////////////////////////////
            int expenses = JOptionPane.showConfirmDialog(null, "May you please type in an estimated amount for the following category of expenditures", "Monthly Ependitures", JOptionPane.YES_NO_CANCEL_OPTION);
            ArrayList<Double> Expenditure = new ArrayList<Double>();
            double groceries, water_light, travel, cell, other = 0.0;
            double total_expense = 0.0;
            double estimated_remains = 0.0;

                if (expenses == JOptionPane.YES_OPTION) {
                        //This will be a JOptionPane input type, for the user to type in their infofrmatiom about their expenses
                        //The input inserted in this ArrayList will be according to order, as in, it will be in the order it is asked
                        //Which means it will be limitted, which can also help in creating an array itself
                        groceries = Integer.parseInt(JOptionPane.showInputDialog(null, "Please enter your estimated grocery costs(Write only the number)"));
                        Expenditure.add(groceries);
                        /////
                        water_light = Integer.parseInt(JOptionPane.showInputDialog(null, "Please enter your estimated water and electricity expense costs"));
                        Expenditure.add(water_light);
                        ////
                        travel = Integer.parseInt(JOptionPane.showInputDialog(null, "Please enter you estimated Travel costs, including petrol, louging etc."));
                        Expenditure.add(travel);
                        //////
                        cell = Integer.parseInt(JOptionPane.showInputDialog(null, "Please enter your cellphone and/or telephone costs combined"));
                        Expenditure.add(cell);
                        /////
                        int more = JOptionPane.showConfirmDialog(null,"Do you have more/other expenses to list?");
                                if (more == JOptionPane.YES_OPTION) {
                                    other = Double.parseDouble(JOptionPane.showInputDialog(null, "Please enter the summed amount of all 'other' expenses costs together"));
                                    Expenditure.add(other);
                                } else if (more == JOptionPane.NO_OPTION) {
                                    JOptionPane.showMessageDialog(null, "You have no other expenses to add.");
                                    other = 0.0;
                                    Expenditure.add(other);
                                } else {
                                    JOptionPane.showMessageDialog(null,"You have cancelled the operation.");
                                    other = 0.0;
                                    Expenditure.add(other);
                                }
                        ////////////////////////////////////////////////////////////////////////////////////////////////////////////// 
                        total_expense = groceries + water_light + cell + other + travel;
                                     
                    } else if (expenses == JOptionPane.NO_OPTION) {
                        JOptionPane.showMessageDialog(null,"You have not recorded any expenditure.");
                        total_expense = 0;
                        // Expenditure.add(0);
                    }
            String[] expenditure_li = {"Groceries","Water and Electricity","Travel costs","Cellphone","Other"};
            double[] expenditurelist = {Expenditure.get(0),Expenditure.get(1),Expenditure.get(2),Expenditure.get(3),Expenditure.get(4)};


            ///Displaying the information gathered
            System.out.println("Expenditure list is as follows.");
            for (int i = 0; i < expenditure_li.length; i++) {
                System.out.print(expenditure_li[i] + "\t");
            }
            System.out.println(""); 
            for (int j = 0; j < expenditure_li.length; j++){
                System.out.print(expenditurelist[j] + "\t");   
            }

            estimated_remains  = income - (tax_deduction + total_expense);  
            JOptionPane.showMessageDialog(null,"With tax deducted and total expenses paid for, your estimated account stands at R" + estimated_remains);

        /*After i called housingOptions to the main method
        @Apex*/ 
        
        // HousingOptions();
        MonthlyHomeLoanRepayments();

    }
        ///This is the formulae to get the tax percentage deducted from income
        public static String tax(double income, double tax_deduction) {
            if (income > tax_deduction) {
                double t_perccent = (tax_deduction/income)*100;
                return "Your tax percentage is " + t_perccent;
            } else {
                return  "There has been an error, your Estimated monthly tax deducted is bigger than your income";
            }
}
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//  //part(1)>>2,3,4
//      //@ author TheApex
//     public static void HousingOptions() {
//         Scanner scanner = new Scanner(System.in);
       
//         //step 2 where the user will be able to select between renting and buying a property
//         /*Used Confirm dialog to be able to have a yes or no option
//          * Started with renting choice
//          */

//         int rentChoice = JOptionPane.showConfirmDialog(null, "Do you want to rent an apartment?", "Please choose between yes and no", JOptionPane.YES_NO_OPTION);
//          /*used a if statement that if it true that the user the GUI selected no 
//          then the user must be asked if since he/she chose no want to buy a propery*/
//          if (rentChoice == JOptionPane.NO_OPTION) {
//             int buyPropertyChoice = JOptionPane.showConfirmDialog(null, "Do you want to buy property?", "Please choose between yes and no", JOptionPane.YES_NO_OPTION);
//               /* therefore since we have buyproperty in a if (conditon) we can have another if inside the first if because
//                * we want to use int buyproperychoice 
//               */
//             if (buyPropertyChoice == JOptionPane.NO_OPTION) {
//                 JOptionPane.showMessageDialog(null, "You do not have a place to stay.");
//             } else {
//                 /*if the user chose yes for the second (if)vto buy property then fill in the details */
//                 MonthlyHomeLoanRepayments1();
//             }
//         } else {
//             //for the firts (if) if the user had selected yes .
//                System.out.println("You have chosen to rent an apartment.");

//                System.out.println("Enter the monthly rental amount");
//                double rent_amount = scanner.nextDouble();
//         }scanner.close();
//     }
// import javax.swing.JOptionPane;
public static void MonthlyHomeLoanRepayments() {

int MONTHS_IN_A_YEAR =12;
    int choices = JOptionPane.showConfirmDialog(null, "Would you like to rent an apratment", "Property Choice", JOptionPane.YES_NO_CANCEL_OPTION);

    double monthlypayments;
    double total_balance = 0;
    double newBalance = 0;
    int num_years = 0;

        if (choices == JOptionPane.YES_OPTION) {
            double monthlyE = Double.parseDouble(JOptionPane.showInputDialog(null, "Please type in the monthly rent paid for the apartment"));

            int length = JOptionPane.showConfirmDialog(null,"Do you know how long you will be renting this particular apartment?","Please select an option", JOptionPane.YES_NO_OPTION);

                if (length == JOptionPane.YES_OPTION) {
                    num_years = Integer.parseInt(JOptionPane.showInputDialog(null, "Please enter the amount of years you will be staying"));
                } else if (length == JOptionPane.NO_OPTION) {
                    num_years = 2;
                }
            System.out.printf("%12s %12s %12s %12s%n", "Month", "Payment", "Total Balance");
            // System.out.printf("%12s  %12s %12s%n", "============","============", "============", "============", "============", "============");
                    for (int i = 1; i < (num_years * MONTHS_IN_A_YEAR); i++) {
                        total_balance = total_balance + monthlyE;
                        System.out.printf("%12s %12s %12n",i,monthlyE,total_balance); 
                    }
                
        } else if (choices == JOptionPane.NO_OPTION) {
            JOptionPane.showMessageDialog(null,"You have chosen not to rent, you will buy a property. Please fill in the required information");
            Scanner input = new Scanner(System.in);    
                
            System.out.println("Enter the purchase price of the property: ");
            double amount = input.nextDouble();
            
            System.out.println("Enter the total deposit: ");
            double totalDeposit = input.nextDouble();
            
            System.out.println("Enter the annual interest rate: ");
            double InterestRate = input.nextDouble();
            
        
            System.out.println("Enter the Loan Term in years(Between 20 and 30): ");
            int years = input.nextInt();
            
            double loanAmount = amount - totalDeposit; 

            int months = years * MONTHS_IN_A_YEAR; 

            double monthlyIR = (InterestRate /MONTHS_IN_A_YEAR /100);       
            // displayAmortizationTable(amount, monthlyIR, months);
            // double monthlyrepayment = amount*(InterestRate*(Math.pow((1.00+InterestRate),years))/(Math.pow((1.00+InterestRate),years)-1));
            input.close();

            monthlypayments = amount*(monthlyIR*(Math.pow((1.00+monthlyIR),months))/(Math.pow((1.00+monthlyIR),months)-1));
            System.out.printf("%12s %12s %12s%n", "Month", "Payment", "loan Balance");
                for (int j = 1; j < months; j++) {
                    newBalance = newBalance + (loanAmount - monthlypayments);
                    System.out.printf("%12s %12s %12s%n", j, monthlypayments, newBalance);
                }
                System.out.println("//////////////////////////////////////////////////////////////////////////");
                System.out.println("The total cost of the house amounted to: " + newBalance);

            }   else {
                JOptionPane.showMessageDialog(null, "You have no place to stay");
            }
}
}