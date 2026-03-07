package practical11;

import javax.print.attribute.standard.PrinterMakeAndModel;
import java.util.Arrays;
import java.util.Arrays;
import java.util.Random;

public class Main{
    public static void main(String[] agrs){
        System.out.println("Comparison of methods");
        int N = 3; //example size
        System.out.println("Slow shuffle: ");
        int[] slow = slowshuffle(N);
        System.out.println(Arrays.toString(slow));

        System.out.println("Biased shuffle:");
        int[] biased = biasedShuffle(N);
        System.out.println(Arrays.toString(biased));

        Test.testShuffle();
    }

    // Slow shuffle using improved method
    public static int[] slowshuffle(int N){
        int[] shuffled = new int[N];
        boolean[] isNotPresent = new boolean[N + 1];
        Arrays.fill(isNotPresent, true);
        Random rand = new Random();
        int i  = 0;
        while (i < N - 1) {
            int r = rand.nextInt(N) + 1;
            if (isNotPresent[r]) {
                shuffled[i] = r;
                isNotPresent[r] = false;
                i++;
            }
        }


        //last number

        for (int j = 1; j <= N ; j++) {
            if (isNotPresent[j]) {
                shuffled[N - 1] = j;

            }

        }
        return shuffled;
    }

    // Biased Shuffle
    public static int[] biasedShuffle(int N) {
        int[] shuffled = new int[N];
        for(int i = 0; i < N; i++) shuffled[i] = i + 1;
        Random rand = new Random();
        for (int i = 0; i < N; i++) {
            int ri = rand.nextInt(N);
            int temp = shuffled[i];
            shuffled[i] = shuffled[ri];
            shuffled[ri] = temp;
        }
        return shuffled;
    }
    public static int[] shuffle(int N){

        int[] B = new int[N];

        for (int i = 0; i < N; i++){
            B[i] = i+1;
        }

        for (int b=0; b<N; b++){

            int r = b + (int)(Math.random()*(N-b));

            int temp = B[b];
            B[b] = B[r];
            B[r] = temp;

        }

        return B;
    }
}

