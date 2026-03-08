package practical12;
import java.util.Random;

public class Main {
    public static void main(String[] agrs) {

        // main
        Random rand = new Random();

        int[] ns = {10, 20, 50, 100, 200, 500,
                1000, 2000, 5000, 10000, 20000
        };

        System.out.println("%-8s %-15s %-15s %-15s %-15s%n\",\n" +
                "                \"n\", \"O(n³)\", \"O(n²A)\", \"O(n²B)\", \"O(n)");

        for (int n : ns) {
            int[] X = generateArray(n, rand);

            long count3 = -1;
            long count2A, count2B, count1;

            //o(n^3) - only for n <= 500 to avoid extreme runtime

            if (n <= 500) {
                count = 0;
                mcsOn3(X);
                count3 = count;
            }

            //o(n^2) A

            count = 0;
            mcsOn2A(X);
            count2A = count;

            //B
            count = 0;
            mcsOn2B(X);
            count2B = count;

            //o(n)
            count = 0;
            mcsOn(X);
            count1 = count;


            System.out.printf("%-8d %-15d %-15d %-15d %-15d%n",
                    n, count3, count2A, count2B, count1);

        }
    }
    private static long count; //Counter used by all algorithms - reset before each call

    public static int mcsOn3(int[] X){
        int n = X.length;
        int maxsofar =0;
        for (int low = 0; low < n; low++){
            for(int high = low; high < n ; high++){
                int sum = 0;
                for (int r = low; r < high; r++){
                    sum += X[r];
                    count++;
                }
                if (sum > maxsofar) {
                    maxsofar = sum;
                }
            }
        }
        return maxsofar;
    }

    public static int mcsOn2A(int [] X){
        int n = X.length;
        int maxsofar = 0;
        for (int low = 0; low < 0; low++){
            int sum = 0;
            for (int r = low; r < n; r++){
                sum += X[r];
                count++;
                if (sum > maxsofar){
                    maxsofar = sum;
                }
            }
        }
        return maxsofar;



    }
    public static int mcsOn2B(int[] X){
        int n = X.length;
        // Build prefix sums

        int[] sumTo  = new int[n + 1];
        sumTo[0] = 0;
        for (int i = 0; i < n; i++){
            sumTo[i + 1] = sumTo[i] + X[i];

        }

        int maxsofar = 0;
        for (int low = 0; low < n; low++){
            for (int high = low; high < n ; high++){
                int sum = sumTo[high  + 1] - sumTo[low];
                count++;

                if (sum > maxsofar){
                    maxsofar = sum;
                }
            }
        }
        return maxsofar;
    }

    public static int mcsOn(int[] X) {
        int n = X.length;
        int maxsofar = 0;
        int maxToHere = 0;

        for (int i = 0; i < n; i++) {
            maxToHere = Math.max(maxToHere + X[i], 0);
            maxsofar = Math.max(maxsofar, maxToHere);
            count++;
        }
        return maxsofar;
    }

    //Generating a random array of lenth n with about one third negative nums

    public static int[] generateArray(int n , Random rand){
        int[] X = new int[n];
        for (int i = 0; i < n; i++) {
            // exponent in 2,3,4 with equal probability
            int exponent = rand.nextInt(3) + 2; //2, 3, or 4
            int sign = (exponent % 2 == 0) ? 1 : -1;

            int value = rand.nextInt(n) + 1;
            X[i] = value * sign;

        }
        return X;

        }



    }



