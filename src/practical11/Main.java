package practical11;

import java.utiil.Arrays;
import java.util.Random;

public class Main{
    public static void main(String[] agrs){
        System.out.println("Hello advocate");
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
                i++
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
        int[] shuffled new int[N];
        for (int i = 0; i < N; i++) {
            int ri = rand.nextInt(N);
            int temp = shuffled[i];
            shuffled[i] = shuffles[ri];
            shuffled[ri] = temp;
        }
    }
}