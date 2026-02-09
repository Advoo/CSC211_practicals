import java.util.*;

public class SlowShuffle {

    public static void main(String[] args) {
        int N = 10;
        boolean[] used = new boolean[N + 1];
        Random rand = new Random();

        int count = 0;
        while (count < N) {
            int x = rand.nextInt(N) + 1;
            if (!used[x]) {
                used[x] = true;
                System.out.print(x + " ");
                count++;
            }
        }
    }
}
