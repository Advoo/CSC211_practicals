package practical12;

public class Main {
    public static void main(String[] agrs){

        // main example

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

    public static int (){


    }

}
