package practical17;

public class tryBTS {

    public static void main(String[] args){

        int n = 7;
        int max = (int)Math.pow(2, n)-1;

        BTS tree = new BTS();

        tNode root = tree.buildBalanced(1, max);

        System.out.println(" Is BTS: "+ tree.isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE));

        Long start = System.currentTimeMillis();
        root = tree.removeEvens(root);
        long end = System.currentTimeMillis();

        System.out.println("Time spend to remove evens: "+ (end - start) + " ms.");

    }
}