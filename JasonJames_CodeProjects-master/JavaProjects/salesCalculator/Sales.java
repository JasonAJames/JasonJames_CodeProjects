/**
 * File: Sales.java
 * @author Jason James 
 * Description: Product Total Sales Calculator
 * Date: 10/8/2015
 */

package salesCalculator;

/**
 *
 * @author jasonjames
 */
import java.util.Scanner;
import javax.swing.JOptionPane;

public class Sales {

    // calculates sales for 5 products

    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);

        double product1 = 0.00;
        double product2 = 0.00;
        double product3 = 0.00;
        double product4 = 0.00;
        double product5 = 0.00;

        int productNum = 0;
        int qtySold = 0;
        boolean done = false;

        /* Ask the user to enter a product number */
        /* Create while statement that loops until sentinel is entered */
        while (!done) {
            System.out.println("Enter product number (1-5) (0 to stop): ");
            productNum = input.nextInt();
            /* Determine whether users' product number is in 1-5 */
            if (productNum > 0 && productNum <= 5) {

                /* If so, ask user to input the quantity sold */
                System.out.println("Enter quantity sold: ");
                qtySold = input.nextInt();
                /* Write a switch statement here that will compute the total for that product */

                switch (productNum) {
                    case 1:
                        product1 += 2.98 * qtySold;
//                System.out.printf("The total for product 1 is $%.2f", product1 + productNum);
                        break;
                    case 2:
                        product2 += 4.50 * qtySold;
                        break;
                    case 3:
                        product3 += 9.98 * qtySold;
                        break;
                    case 4:
                        product4 += 4.49 * qtySold;
                        break;
                    case 5:
                        product5 += 6.87 * qtySold;
                        break;
                    default:
                        System.out.printf("DEFAULT: You entered an invalid product number. Number must be 1 - 5: ");
                        break;
                }

            } /* If product number is not 1-5, test if product number is not 0 */ else if (productNum == 0) {
                done = true;
            } else {
                /* Display error message for invalid product number */
                System.out.printf("You entered an invalid product number.\n\n ");
            }

            /* end while loop */
        }

        /* 
         Write code here for the rest of the summary message.  It should contain
         the totals for the rest of the products, each on its own line.  
         */
// print summary
        System.out.println();
        System.out.printf("Product 1: $%.2f\n", product1);
        System.out.printf("Product 2: $%.2f\n", product2);
        System.out.printf("Product 3: $%.2f\n", product3);
        System.out.printf("Product 4: $%.2f\n", product4);
        System.out.printf("Product 5: $%.2f\n", product5);

    }
}
