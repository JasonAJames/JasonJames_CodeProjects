/**
 * File: Unique.java
 * @author JasonJames
 * Description: Test for Unique Numbers
 * Date: 6-14-2016
 */

package uniqueNumberChecker;

// Reads in 5 unique numbers.
import java.util.Scanner;
import javax.swing.JOptionPane;

public class Unique
{
   // gets 5 unique numbers from the user
   public void getNumbers()
   {
      Scanner input = new Scanner( System.in );

        /* Create an array of five elements*/ 
      int[] numbers = new int[5];
      int count = 0; // number of uniques read
      int entered = 0; // number of entered numbers
      int userInput = 0;
      
      while( count < numbers.length )
      {
         /* Write code here to retrieve the input from the user */
         userInput = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter a number: ", "Lab 6 - Arrays and Collections", JOptionPane.INFORMATION_MESSAGE));
         
         // validate the input
         if (userInput >= 10 && userInput <= 100)
         /* Write an if statement that validates the input */  
         {
            // flags whether this number already exists
            boolean containsNumber = false;
            

            // increment number of entered numbers
            entered++;
            
            /* Compare the user input to the unique numbers in the array using a for 
               statement. If the number is unique, store new number */
            for (int i = 0; i < numbers.length; i++)
            {
                if (userInput == numbers[i])
                {
                    containsNumber = true;
                }
            }
            /* add the user input to the array only if the number is not already 
               in the array */
            if ( !containsNumber )
            {
               /* Write code to add the number to the array and increment 
                  unique items input */
                numbers[count] = userInput;
                count++;
                
            } // end if
            else 
               System.out.printf( "%d has already been entered\n",
                  userInput );
         } // end if
         else
            System.out.println( "number must be between 10 and 100" );
         
         // print the list of unique values
          /* Write code to output the contents of the array */
         //Enhanced For Loop
        
        
      } // end while     
      
      for (int currentValue : numbers)
         {
             System.out.println(currentValue);
         }  
   } // end method getNumbers
} 
// end class Unique
