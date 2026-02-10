import java.util.Random;

public class UnbiasedShuffle {

    public static int[] unbiasedShuffle(int N) {
        int[] B = new int[N];
        for (int i = 0; i < N; i++) {
            B[i] = i + 1;
        }

        Random rand = new Random();
        int b = 0;

        while (b < N) {
            int r = b + rand.nextInt(N - b); // correct range
            int temp = B[b];
            B[b] = B[r];
            B[r] = temp;
            b++;
        }
        return B;
    }

    public static void main(String[] args) {
        int[] result = unbiasedShuffle(10);
        for (int x : result) {
            System.out.print(x + " ");
        }
    }
}

