/**
 * File: CompareStringsRegoinMatches.java
 * @author JasonJames
 * Description: CIS 18a homework 08 - section 14.4
 * (Comparing Portions of Strings) Write an application that uses String method region-
 * Matches to compare two strings input by the user. The application should input the number of characters
 * to be compared and the starting index of the comparison. The application should state
 * whether the strings are equal. Ignore the case of the characters when performing the comparison.
 * Date: 10/29/2015
 */
package StringFormatting;

import java.util.Scanner;

/**
 *
 * @author JasonJames
 */
public class CompareStringsRegionMatches {
    public static void main(String args[])
   {
      String s1, s2;
      Scanner in = new Scanner(System.in);
 
      System.out.println("Enter the first string");
      s1 = in.nextLine();
 
      System.out.println("Enter the second string");
      s2 = in.nextLine();
 
      if ( s1.compareTo(s2) > 0 )
         System.out.println("First string is greater than second.\nThe strings are not equal.");
      else if ( s1.compareTo(s2) < 0 )
         System.out.println("First string is smaller than second.\nThe strings are not equal.");
      else   
         System.out.println("Both strings are equal.");
   }
}
