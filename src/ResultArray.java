/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Govind
 */
public class ResultArray {

    public static int output(int[] input) {
        if (input.length == 1) {
            return input[0];
        }
        int[] localArray = new int[input.length - 1];
        for (int i = 0; i < input.length; i++) {
            if (i < localArray.length) {
                localArray[i] = input[i + 1] - input[i];
            }
        }
        return output(localArray);
    }

    public static void main(String[] args) {
        //System.out.println(output(new int[]{1, 5, 9, 2, 3, 5, 6}));
        System.out.println(output(new int[]{1, 5, 9, 2, 3, 5}));

    }

}
