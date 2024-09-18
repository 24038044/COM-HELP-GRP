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
    
}