/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Govind
 */
public class SequenceTest {

    private static String[] inputs;
    private static StringBuffer newSequence;
    private static int temp;
    public static int f = 0;

    public static String sequences(String input) {
        System.out.println("input  " + input);
        inputs = input.split(",");
        if (inputs.length == 1) {
            f = 2;
            return inputs[0];
        }
        newSequence = new StringBuffer("");
        for (int i = 0; i < inputs.length - 1; i++) {
            temp = Integer.parseInt(inputs[i + 1]) - Integer.parseInt(inputs[i]);
            newSequence.append(temp + ",");
        }
        if (f == 0) {
            f = 1;
        }
        return sequences(String.valueOf(newSequence));

    }

    public static void main(String[] args) {
        System.out.println("output : "+sequences("1,5,9,2,3,5,6"));
    }

}
