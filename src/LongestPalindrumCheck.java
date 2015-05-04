

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Govind
 */
public class LongestPalindrumCheck {

    static int maxLength = 0;
    static StringBuffer outputText = new StringBuffer("");

    static void prepareNameString(String[] names) {
        String nameString = "";
        for (int i = 0; i < names.length; i++) {
            nameString += names[i].charAt(0);
        }
        System.out.println("findLongestPalindrumLength: " + findLongestPalindrumLength(0, nameString));
    }

    static int findLongestPalindrumLength(int start, String nameString) {
        for (int pos = start; pos < nameString.length(); pos++) {
            outputText.append(nameString.charAt(pos));
            System.out.println("outputText : " + outputText);
            if (isPalindrum(outputText.toString())) {
                maxLength = (maxLength < outputText.length()) ? outputText.length() : maxLength;
            }
            if (pos < nameString.length()) {
                findLongestPalindrumLength(pos + 1, nameString);
            }
            outputText.setLength(outputText.length() - 1);
        }
        return maxLength;
    }

    public static boolean isPalindrum(String s) {

        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        //prepareNameString(new String[]{"Bharti", "Bharat", "Akash", "Bhavya", "Chand", "Brijesh", "Chetak", "Arvind", "Bhavna"});
        prepareNameString(new String[]{"A", "B", "C"});
    }

}
