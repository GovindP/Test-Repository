/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Govind
 */
public class ResultArray2 {

    public static int k = 0;

    public static int output(int[] input) {
        System.out.println("K value " + k);
        if (k == input.length - 1) {
            return input[0];
        }
        for (int i = 0; i < input.length - k; i++) {
            if (i < input.length - k - 2) {
                input[i] = input[i + 1] - input[i];
                System.out.println();
            }
        }
        /*for (int i = 0; i < input.length - k; i++) {
         System.out.print(input[i] + "  ");
         }
         System.out.println();*/
        k++;
        return output(input);
    }

    public static void main(String[] args) {
        System.out.println(output(new int[]{1, 5, 9, 2, 3, 5, 6}));
    }

}
