/*
 * File: SearchingStrings.java
 * @author JasonJames
 * Description:CIS 18A Homework 8 Section 14.11 (Searching Strings) Write an application
 * that inputs a line of text and a search character and uses String method indexOf to 
 * determine the number of occurrences of the character in the text.
 * Date: 10/29/2015
 */

package StringFormatting;

import java.util.Scanner;

/**
 *
 * @author jasonjames
 */

public class SearchingStrings {
    public static void main(String[] args) {


        Scanner input=new Scanner(System.in);
        System.out.println("Enter a String line of text: ");
        String str=input.nextLine();

        int count=0;
        String temp="";

        for(int i=0;i<str.length();i++)
        {

            char c=str.charAt(i);

            for(int j=i;j<str.length();j++)
            {

                char k=str.charAt(j);  
    
                if(c==k && temp.indexOf(c)==-1)                                                                          
                {
                    count=count+1;
                }

            }

             if(temp.indexOf(c)==-1)  // if it is not previously counted
             {


            temp=temp+c; // append the character to the temp (already counted)

System.out.println("Character " + c + " occurs " + count + " times");
             }  
            // reset the counter for next iteration 
              count=0;
        }


    }
}