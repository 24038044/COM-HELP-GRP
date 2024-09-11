import javax.swing.*;
//I purposely imported everything from both the java.util and javax.swing because i didnt want to have forgotten or mispelled something
// import java.util.Scanner;
import java.util.*;
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

        
        

        



    }
    
}
