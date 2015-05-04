
import java.io.*;
import java.util.*;

public class LongestPalindrumCheck2 {

    public static void main(String[] args) {
        System.out.print(PalindromeLengthPuzzle(new String[]{"B", "B", "A", "B", "C", "B", "C", "A", "B"}));
    }

    public static int PalindromeLengthPuzzle(String[] input1) {
        int len = input1.length;

        String name = "";
        for (int i = 0; i < len; i++) {
            name += input1[i].charAt(0);
        }

        LongestPalindrumCheck2 code = new LongestPalindrumCheck2();
        System.out.println(code.combine(0, name));
        return max;
        //longestPalindrome.length();
    }
    static int max = 0;
    private StringBuilder output = new StringBuilder();

    private int combine(int start, String inputstring) {

        for (int i = start; i < inputstring.length(); ++i) {
            output.append(inputstring.charAt(i));

            if (isPalindrome(output.toString())) {
                max = max > output.length() ? max : output.length();
            }
            System.out.println(output);

            if (i < inputstring.length()) {
                combine(i + 1, inputstring);
            }
            output.setLength(output.length() - 1);
        }
        return max;
    }

    public static boolean isPalindrome(String s) {

        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
                return false;
            }
        }

        return true;
    }

}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
