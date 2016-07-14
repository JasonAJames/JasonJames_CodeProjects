package mortgage;
/**
 * File: mortgage.java
 * Description: Mortgage Total Loan Payment Calculator
 * Date: 6-14-2016
 */

/**
 *
 * @author JasonJames
 */
public class mortgage {
    public static void main(String args[]) {
        double amount;
        double principal = 316000.0;
        double rate = 0.04375;
        
        System.out.printf("%s%20s%n", "Year", "Amount on Deposit");
        
        for (int year = 1; year <= 30; ++year) {
            amount = principal * Math.pow(1.0 + rate, year);
            System.out.printf("%4d%,20.2f%n", year, amount);
        }
    }
}
