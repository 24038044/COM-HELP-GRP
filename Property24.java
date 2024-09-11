import javax.swing.*;
// import java.util.Scanner;
import java.util.*;
 // @author Cee_J
public class Property24 {


    public static void main(String[] args) {
        // TODO code application logic here

        String fname,Lname;
        fname = JOptionPane.showInputDialog("Enter your first name>>");
        Lname= JOptionPane.showInputDialog("Enter your last name>>");
        ArrayList<Double> income_tax = new ArrayList<Double>();
        Scanner scanner = new Scanner(System.in);

        System.out.println(fname +" "+Lname+ ", please type in your Gross Monthly income (before deductions):");
        double income = scanner.nextDouble();
        income_tax.add(income);
        System.out.println("Then type in your estimated monthly tax deduction:");
        double tax_deduction = scanner.nextDouble();
        income_tax.add(tax_deduction);

        for (int i = 0; i <= income_tax.size(); i++) {
            System.out.println(income_tax.get(i));
        }
        

        



    }
    
}
