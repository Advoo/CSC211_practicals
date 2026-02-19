import java.util.HashMap;
import java.util.Map;

public class CountPermutation {

    public static int[] unbiasedShuffle(int N) {
        int[] B = new int[N];
        for (int i = 0; i < N; i++) {
            B[i] = i + 1;
        }

        int b = 0;
        while (b < N) {
            int r = b + (int)(Math.random() * (N - b));
            int temp = B[b];
            B[b] = B[r];
            B[r] = temp;
            b++;
        }
        return B;
    }

    public static void main(String[] args) {
        Map<String, Integer> D = new HashMap<>();
        int N = 3;

        for (int i = 0; i < 60000; i++) {
            int[] B = unbiasedShuffle(N);
            String key = "" + B[0] + B[1] + B[2];

            if (!D.containsKey(key)) {
                D.put(key, 1);
            } else {
                D.put(key, D.get(key) + 1);
            }
        }

        for (String key : D.keySet()) {
            System.out.println(key + " " + D.get(key));
        }
    }
}
