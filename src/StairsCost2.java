import java.util.HashMap;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Govind
 */
public class StairsCost2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         findMinimumStairCost(new int[]{1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9});
    }

    public static int findMinimumStairCost (int[] input) {
        HashMap<String, Integer> paths = new HashMap<String, Integer>();
        System.out.println(traverseStairs(1,input,paths,"",0));
        return -1;
    }

    public static HashMap<String, Integer> traverseStairs(int step, int[] steps, HashMap<String, Integer> paths, String path, int skip) {
        int finalStep = step + steps[step - 1];
        for (int cstep = step + 1; cstep <= finalStep; cstep = cstep + skip) {
            path += "" + cstep;
            if (cstep >= finalStep) {
                paths.put(path, path.length());
                skip++;
                return traverseStairs(1, steps, paths, "", skip);
            }
        }
        return traverseStairs(step+1,steps,paths,path,0);
    }

}
