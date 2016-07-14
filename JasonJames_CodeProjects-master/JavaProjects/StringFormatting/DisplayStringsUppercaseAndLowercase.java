/*
 * File: DisplayStringsUppercaseAndLowercase.java
 * @author JasonJames
 * Description: CIS-18a Homework 8 Section 14.10 (Displaying Strings in Uppercase and Lowercase) 
 * Write an application that inputs a line of text and outputs the text twice—once in all uppercase 
 * letters and once in all lowercase letters.
 * Date: 10/29/2015
 */

package StringFormatting;

import java.util.Scanner;

/**
 *
 * @author jasonjames
 */
public class DisplayStringsUppercaseAndLowercase {
    public static void main(String[] args){
        
        Scanner input = new Scanner(System.in);
        
        System.out.println("Enter Text to change into Uppercase and Lowercase: ");
        String changeCase = input.nextLine();
        
        String result_Upper, result_Lower;
        result_Upper = changeCase.toUpperCase();
        result_Lower = changeCase.toLowerCase();
        
        System.out.println("\nString converted to Uppercase:\n" + result_Upper + "\n");
        System.out.println("String converted to Lowercase:\n" + result_Lower);
        
    }
}
