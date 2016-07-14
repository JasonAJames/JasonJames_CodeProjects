/**
 * File: CompareStrings.java
 * @author JasonJames
 * Description: CIS 18a homework 08 - section 14.3
 * (Comparing Strings) Write an application that uses String method compareTo to compare two strings
 * input by the user. Output whether the first string is less than, equal to or greater than the second.
 * Date: 10/29/2015
 */
package StringFormatting;

/**
 *
 * @author jasonjames
 */
import java.util.Scanner;
 
class CompareStrings
{
   public static void main(String args[])
   {
      String s1, s2;
      Scanner in = new Scanner(System.in);
 
      System.out.println("Enter the first string");
      s1 = in.nextLine();
 
      System.out.println("Enter the second string");
      s2 = in.nextLine();
 
      if ( s1.compareTo(s2) > 0 )
         System.out.println("First string is greater than second.");
      else if ( s1.compareTo(s2) < 0 )
         System.out.println("First string is smaller than second.");
      else   
         System.out.println("Both strings are equal.");
   }
}