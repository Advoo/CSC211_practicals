import java.util.*;




import java.util.Random;

public class SlowShuffle {

    public static int[] slowShuffle(int N) {
        int[] shuffled = new int[N];
        boolean[] isNotPresent = new boolean[N + 1];

        for (int i = 1; i <= N; i++) {
            isNotPresent[i] = true;
        }

        Random rand = new Random();
        int i = -1;

        while (i < N - 1) {
            int r = rand.nextInt(N) + 1; // [1..N]
            if (isNotPresent[r]) {
                i++;
                shuffled[i] = r;
                isNotPresent[r] = false;
            }
        }
        return shuffled;
    }

    public static void main(String[] args) {
        int[] result = slowShuffle(10);
        for (int x : result) {
            System.out.print(x + " ");
        }
    }
}
