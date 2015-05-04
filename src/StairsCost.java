/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Govind
 */
public class StairsCost {

    static int minSteps = 0;

    public static int findMinimumStairCost(int[] inputs) {
        return finMinSteps(0, inputs);
    }

    public static int finMinSteps(int step, int[] steps) {
        if (step == steps.length - 1) {
            return 0;
        }
        System.out.println("step  " + step);
        if (steps[step] == 0) {
            return -1;
        }
        int minCost = 2147483647;
        for (int cstep = step + 1; cstep <= step + steps[step] && cstep < steps.length; cstep++) {
            int temp = finMinSteps(cstep, steps);
            if (temp != 2147483647 && temp + 1 < minCost) {
                minCost = temp + 1;
            }
        }
        return minCost;
    }

    public static void main(String[] args) {
        //System.out.println(findMinimumStairCost(new int[]{1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9}));

    }

}
