/**
 * File: TokenizingTelephoneNumbers.java
 * @author JasonJames
 * Description: (Tokenizing Telephone Numbers) Write an application that inputs a telephone number as a
 * string in the form (555) 555-5555. The application should use String method split to extract the
 * area code as a token, the first three digits of the phone number as a token and the last four digits of
 * the phone number as a token. The seven digits of the phone number should be concatenated into
 * one string. Both the area code and the phone number should be printed. Remember that you’ll have
 * to change delimiter characters during the tokenization process.
 * Date: 10/29/2015
 */
package StringFormatting;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 *
 * @author JasonJames
 */

public class TokenizingTelephoneNumbers {
    public static void main(String[] args) {
        String fullNumber = "1-951-555-9432";
String[] splitNumber = fullNumber.split("-");

String countryCode = splitNumber[0];
String areaCode = splitNumber[1];
String prefix = splitNumber[2];
String suffix = splitNumber[3];

System.out.printf("%s ( %s ) %s - %s", countryCode, areaCode, prefix, suffix);

    }
}

