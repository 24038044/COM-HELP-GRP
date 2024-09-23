import java.util.*;
import javax.swing.*;
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
            System.out.println(tax(income,tax_deduction));
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
                                } else {
                                    JOptionPane.showMessageDialog(null,"You have cancelled the operation.");
                                }
                        /////////// 
                        total_expense = groceries + water_light + cell + other + travel;
                                     
                    } else if (expenses == JOptionPane.NO_OPTION) {
                        JOptionPane.showMessageDialog(null,"You have not recorded any expenditure.");
                        // Expenditure.add(0);
                    } else {
                        JOptionPane.showMessageDialog(null, "You have closed the queiry or have pressed on cancel");
                        JOptionPane.showMessageDialog(null, "You have cancelled the operation");
                        // Expenditure.get();
                    }
            double[] expenditurelist = {Expenditure.get(0),Expenditure.get(1),Expenditure.get(2),Expenditure.get(3),Expenditure.get(4)};
            estimated_remains  = income - (income-tax_deduction) - total_expense;  
        JOptionPane.showMessageDialog(null,"With tax deducted and total expenses paid for, your estimated account stands at R" + estimated_remains);
        
        
        /*After i called housingOptions to the main method
        @Apex*/ 
        
        HousingOptions();

    }
    ///This is the fomrlae to get the tax percentage deducted from income
     public static String tax(double income, double deduction) {
        if (income > deduction) {
            double t_perccent = (deduction/income)*100;
            return "Your tax percentage is " + t_perccent;
        } else {
            return  "There has been an error, your Estimated monthly tax deducted is bigger than your income";
        }
     }

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
     //part(1)>>2,3,4
     //@ author TheApex
     public static void HousingOptions() {
        Scanner scanner = new Scanner(System.in);
       
        //step 2 where the user will be able to select between renting and buying a property
        /*Used Confirm dialog to be able to have a yes or no option
         * Started with renting choice
         */

       double price_property, Total_deposit, Interest, Months;
        int rentChoice = JOptionPane.showConfirmDialog(null, "Do you want to rent an apartment?", "Please choose between yes and no", JOptionPane.YES_NO_OPTION);
         /*used a if statement that if it true that the user the GUI selected no 
         then the user must be asked if since he/she chose no want to buy a propery*/
         if (rentChoice == JOptionPane.NO_OPTION) {
            int buyPropertyChoice = JOptionPane.showConfirmDialog(null, "Do you want to buy property?", "Please choose between yes and no", JOptionPane.YES_NO_OPTION);
              /* therefore since we have buyproperty in a if (conditon) we can have another if inside the first if because
               * we want to use int buyproperychoice 
              */
            if (buyPropertyChoice == JOptionPane.NO_OPTION) {
                JOptionPane.showMessageDialog(null, "You do not have a place to stay.");
            } else {
                /*if the user chose yes for the second (if)vto buy property then fill in the details */

                System.out.println("You have chosen to buy property");

                System.out.println("Enter the Purchase price of the property >>");
                 price_property = scanner.nextDouble();

                System.out.println("Enter Total deposit >>");
                 Total_deposit = scanner.nextDouble();

                System.out.println("Enter Interest rate (percentage) >>");
                 Interest = scanner.nextDouble();


                System.out.println("Enter Number of months to repay (between 240 and 360) >>");
                 Months = scanner.nextDouble();

               ///Loan amount calculations
                double LoanAmount = price_property - Total_deposit;
             // convert yearly interest rate to monthly interest rate
              double monthlyIR = (Interest /Months /100); //Consider the user to enter decimals

                //call the Amortization method
                 displayAmortizationTable(price_property, monthlyIR, Months);
               

               
            }
        } else {
            //for the firts (if) if the user had selected yes .
               System.out.println("You have chosen to rent an apartment.");

               System.out.println("Enter the monthly rental amount");
               double rent_amount = scanner.nextDouble();
        }scanner.close();
    }
 ///Function for monthly payments
 public static double MonthlyPayment(double amount, double rate, int months){
        return (rate * amount)/(1- Math.pow(1 + rate, -months));
        
    }
 // fuction to display Amortization Table
    public static void displayAmortizationTable(double amount, double rate, int months) {
        double balance = price_property;
        double payment = MonthlyPayment(price_property, Interest, Months);
        double irPaid, amountPaid, newBalance;
        
        // display the header row
        System.out.printf("%12s %12s %12s %12s %12s %12s%n", "Month",
           "Old Balance", "Payment", "Interest", "Principal", "New Balance");
        System.out.printf("%12s %12s %12s %12s %12s %12s%n", "============",
           "============", "============", "============", "============", "============");
        
        for (int month = 1; month<=Months; month++){
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
    
