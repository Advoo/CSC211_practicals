package practical17;

public class time {

    public static double[] measure(int n, int repetitions){

        long sum = 0;
        long sumSq= 0;

        for (int i = 0; i < repetitions; i++){

            BTS tree = new BTS();

            long start = System.nanoTime();

            tNode root = tree.buildBalanced( 1, n);

            long end = System.nanoTime();

            long time = end - start;
        }

        double avg =sum / (double) repetitions;
        double std = Math.sqrt((sumSq - repetitions * avg * avg) / (repetitions - 1));

        return new double[]{avg, std};
    }

}
