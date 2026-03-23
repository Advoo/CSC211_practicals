package practical17;

import java.util.ArrayList;
import java.util.List;

public class tryBST {

    public static void main(String[] args){

        int n = 20;
        int max = (int)Math.pow(2, n)-1;

        int repetitions = 100;

        // STORETIMES
        List<Long> buildTimes = new ArrayList<>();
        List<Long> deleteTimes = new ArrayList<>();




        for (int i = 0; i < repetitions; i++) {

            BST tree = new BST();

            //Timing
            long startBuild = System.currentTimeMillis();

            tNode root = tree.buildBalanced(1, max);

            long endBuild = System.currentTimeMillis();

            buildTimes.add(endBuild - startBuild);

            // Delete Timing
            long startDelete = System.currentTimeMillis();

            root = tree.removeEvens(root);

            long endDelete = System.currentTimeMillis();

            long deleteTime = endDelete - startDelete;
            deleteTimes.add(deleteTime);
        }


        double avgBuild = average(buildTimes);
        double stdBuild = stdDev(buildTimes, avgBuild);

        double avgDelete = average(deleteTimes);
        double stdDelete = stdDev(deleteTimes, avgDelete);

        System.out.println("\n----------------------------------------------");
        System.out.printf("%-25s %-15s %-20s %-20s\n",
                "Method", "n", "Avg Time (ms)", "Std Dev");

        System.out.printf("%-25s %-15d %-20.2f %-20.2f\n",
                "Populate tree", max, avgBuild, stdBuild);

        System.out.printf("%-25s %-15d %-20.2f %-20.2f\n",
                "Remove evens", max, avgDelete, stdDelete);

        System.out.println("----------------------------------------------");




    }
    public static double average(List<Long> times){
        long sum = 0;
        for (long t : times) sum += t;
        return sum / (double) times.size();

    }

    public static double stdDev(List<Long> times, double avg) {
        double sum = 0;

        for (long t : times) {
            sum += Math.pow(t - avg, 2);
        }

        return Math.sqrt(sum / times.size());
    }



}