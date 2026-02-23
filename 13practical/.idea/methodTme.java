import java.io.*;
import java.util.*;
import java.text.*;
import java.lang.Math;

public class timeMethods {

    public static int N = 0;
    public static int[] keys;   // array from file

    public static void main(String args[]) throws Exception {

        // ---------- READ FILE ----------
        ArrayList<Integer> temp = new ArrayList<>();
        Scanner file = new Scanner(new File("ulysses.numbered"));

        while (file.hasNext()) {
            temp.add(file.nextInt());
        }
        file.close();

        N = temp.size();
        keys = new int[N];

        for (int i = 0; i < N; i++) {
            keys[i] = temp.get(i);
        }

        // ---------- FORMATTERS ----------
        DecimalFormat twoD = new DecimalFormat("0.00");
        DecimalFormat fourD = new DecimalFormat("0.0000");
        DecimalFormat fiveD = new DecimalFormat("0.00000");

        int repetitions = 30;
        Random rand = new Random();

        // ===============================
        // LINEAR SEARCH TIMING
        // ===============================

        double runTime = 0;
        double runTime2 = 0;

        for (int r = 0; r < repetitions; r++) {

            int randomKey = rand.nextInt(32654) + 1;

            long start = System.currentTimeMillis();

            linearSearch(keys, randomKey);

            long finish = System.currentTimeMillis();

            double time = (double)(finish - start);
            runTime += time;
            runTime2 += (time * time);
        }

        double linearAvg = runTime / repetitions;
        double linearStd =
                Math.sqrt((runTime2 - repetitions * linearAvg * linearAvg) / (repetitions - 1));

        // ===============================
        // SORT ARRAY FOR BINARY SEARCH
        // ===============================

        Arrays.sort(keys);

        // ===============================
        // BINARY SEARCH TIMING
        // ===============================

        double runTimeB = 0;
        double runTimeB2 = 0;

        for (int r = 0; r < repetitions; r++) {

            int randomKey = rand.nextInt(32654) + 1;

            long start = System.currentTimeMillis();

            binarySearch(keys, randomKey);

            long finish = System.currentTimeMillis();

            double time = (double)(finish - start);
            runTimeB += time;
            runTimeB2 += (time * time);
        }

        double binaryAvg = runTimeB / repetitions;
        double binaryStd =
                Math.sqrt((runTimeB2 - repetitions * binaryAvg * binaryAvg) / (repetitions - 1));

        // ===============================
        // OUTPUT RESULTS
        // ===============================

        System.out.println("\n\nStatistics\n");
        System.out.println("----------------------------------------");

        System.out.println("Linear Search Average: " + fourD.format(linearAvg) + " ms");
        System.out.println("Linear Search Std Dev: " + fourD.format(linearStd));

        System.out.println();

        System.out.println("Binary Search Average: " + fourD.format(binaryAvg) + " ms");
        System.out.println("Binary Search Std Dev: " + fourD.format(binaryStd));

        System.out.println("----------------------------------------");
        System.out.println("Repetitions: " + repetitions);
    }

    // ==================================
    // LINEAR SEARCH (O(n))
    // ==================================
    public static int linearSearch(int[] arr, int key) {

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == key)
                return i;
        }
        return -1;
    }

    // ==================================
    // BINARY SEARCH (O(log n))
    // ==================================
    public static int binarySearch(int[] arr, int key) {

        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {

            int mid = (low + high) / 2;

            if (arr[mid] == key)
                return mid;

            if (arr[mid] < key)
                low = mid + 1;
            else
                high = mid - 1;
        }
        return -1;
    }
}