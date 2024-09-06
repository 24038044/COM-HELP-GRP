import javax.swing.*;
// import java.util.Scanner;
import java.util.*;
 // @author Cee_J
public class Property24 {


    public static void main(String[] args) {
        // TODO code application logic here

        String names = JOptionPane.showInputDialog("Please type in your name and surname(separate by a space)");
        ArrayList<Double> income_tax = new ArrayList<Double>();
        Scanner scanner = new Scanner(System.in);

        System.out.println(names + " please type in your Gross Monthly income(before deductions) and estimated mothly tax deduction. Press ENTER after each value entered.");
        double income = scanner.nextDouble();
        income_tax.add(income);
        double tax_deduction = scanner.nextDouble();
        income_tax.add(tax_deduction);

        for (int i = 0; i <= income_tax.size(); i++) {
            System.out.println(income_tax.get(i));
        }
        

        



    }
    
}
