import java.util.Random;

public class BiasedShuffle {

    public static int[] biasedShuffle(int N) {
        int[] shuffled = new int[N];
        for (int i = 0; i < N; i++) {
            shuffled[i] = i + 1;
        }

        Random rand = new Random();

        for (int i = 0; i < N; i++) {
            int r = rand.nextInt(N); // WRONG range → biased
            int temp = shuffled[i];
            shuffled[i] = shuffled[r];
            shuffled[r] = temp;
        }
        return shuffled;
    }

    public static void main(String[] args) {
        int[] result = biasedShuffle(10);
        for (int x : result) {
            System.out.print(x + " ");
        }
    }
}

