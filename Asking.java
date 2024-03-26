/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Cee_J
 */
import javax.swing.JOptionPane;
import java.util.Scanner;

public class Asking {
    public static void main(String[] args) {
        // double shoe = Double.parseDouble(JOptionPane.showInputDialog(null, "What is
        // the size of your shoe? "));
        Scanner scanner = new Scanner(System.in);
        double shoe = scanner.nextDouble();
     
             boolean statement;

              // if (shoe >= 6) {
            //statement = true;
            //       } else {
          //  statement = false;
          //        }
               
              if (shoe >= 6){
               
                   System.out.println("You are damn old buddy");
               }else {
                   System.out.println("You are young shame");
               }

        // Find a way to get the information from the dialog box
        // get it a boolean true/false value(Important)
        // figure out how to implement the boolean statement in the if-else statement
        

                 // if (statement) {
                    //    JOptionPane.showMessageDialog(null, "You are an adult" + toString(shoe));
                 //     } else {
                 // JOptionPane.showMessageDialog(null, "You are young dawg!! " + toString(shoe));
        }
    }

 //   private static String toString(double shoe) {
   //     throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  //  }
//}
