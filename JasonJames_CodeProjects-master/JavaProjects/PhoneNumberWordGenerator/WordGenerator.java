/**
 * File: WordGenerator.java
 * @author JasonJames
 * Description: (Telephone-Number Word Generator) 
 * Date: 10/29/2015
 */
 

package PhoneNumberWordGenerator;

/**
 *
 * @author jasonjames
 */
import java.io.IOException;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class WordGenerator {

    private static final Map<Character, char[]> digitMap;
    static {
        digitMap = new HashMap<>();

        digitMap.put(Character.valueOf('0'), new char[] { ' ' });
        digitMap.put(Character.valueOf('1'), new char[] { ' ' });
        digitMap.put(Character.valueOf('2'), new char[] { 'a', 'b', 'c' });
        digitMap.put(Character.valueOf('3'), new char[] { 'd', 'e', 'f' });
        digitMap.put(Character.valueOf('4'), new char[] { 'g', 'h', 'i' });
        digitMap.put(Character.valueOf('5'), new char[] { 'j', 'k', 'l' });
        digitMap.put(Character.valueOf('6'), new char[] { 'm', 'n', 'o' });
        digitMap.put(Character.valueOf('7'), new char[] { 'p', 'r', 's' });
        digitMap.put(Character.valueOf('8'), new char[] { 't', 'u', 'v' });
        digitMap.put(Character.valueOf('9'), new char[] { 'w', 'x', 'y' });
    }

    public static void convert(String input, String resultSoFar, List<String> allResults) {

        if (input.length() == 0) {

            allResults.add(resultSoFar);
        } else {

            Character nextDigit = Character.valueOf(input.charAt(0));

            char[] mappingArray = digitMap.get(nextDigit);

            if (mappingArray != null) {

                String inputTail = input.substring(1);

                for (char nextLetter : mappingArray) {

                    convert(inputTail, resultSoFar + nextLetter, allResults);
                }
            }
        }

    }
    public static void main(String[] args) throws IOException {

       
        String prefix_input;
        String suffix_input;
        Scanner input = new Scanner(System.in);
        // Path path = Paths.get(input.nextLine());
        System.out.println("Find all the possible words that can be generated from a phone number.\n");
        System.out.println("Enter the phone number Prefix (X): (ex: XXX ****)");
        prefix_input = input.nextLine();
        System.out.println("Enter the phone number Suffix (X): (ex: *** XXXX)");
        suffix_input = input.nextLine();
        
        String num = prefix_input + suffix_input;
        String phoneNumberFormatted = prefix_input + "-" + suffix_input;
        List<String> results = new ArrayList<String>();

        convert(num, "", results);

//        if(Files.exists(path)) {
//            for (String nextResult : results) {
//            System.out.println(nextResult);
//            }
//            System.out.println("\nBelow are all of the possible words generated from the phone number: " + phoneNumberFormatted + "\n\nGenerated Words:");
//            System.out.println("End of Possible Telephone Number Words Generated results.\nTotal words generated: " + results.size() + " from Phone Number: " + phoneNumberFormatted);
// 
//        }
        Formatter f = new Formatter("outputInformation.txt");
        
        f.format("\nBelow are all of the possible words generated from the phone number: " + phoneNumberFormatted + "\n\nGenerated Words:\n");
        for (String nextResult : results) {
            f.format("%s%n", nextResult);
            
            System.out.println(nextResult);
        }
        f.close();

        System.out.println("End of Possible Telephone Number Words Generated results.\nTotal words generated: " + results.size() + " from Phone Number: " + phoneNumberFormatted);
    }
}
