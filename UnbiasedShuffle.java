import java.util.*;

public class UnbiasedShuffle {

    public static void main(String[] args) {
        int N = 10;
        int[] arr = new int[N];
        Random rand = new Random();

        for (int i = 0; i < N; i++) {
            arr[i] = i + 1;
        }

        for (int i = 0; i < N; i++) {
            int j = i + rand.nextInt(N - i);
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }

        System.out.println(Arrays.toString(arr));
    }
}
