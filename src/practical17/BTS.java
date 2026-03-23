package practical17;

public class BTS {

    public tNode insert(tNode root, int key){
        if (root == null) return new tNode(key); //if null position, insert new node

        if (key < root.key)
            root.left = insert(root.left, key);
        else
            root.right = insert(root.right, key);

        return root;

    }
    public tNode buildBalanced(int start, int end){

        if (start > end) return null; //base case

        int mid = (start + end ) / 2;

        tNode node = new tNode(mid);

        node.left = buildBalanced(start, mid -1);

        node.right = buildBalanced((mid + 1, end);

        return node;
    }
    public boolean inBST(tNode node, int min, int max){


    }
    public tNode delete(tNode root , int key){

    }
    private tNode findMin(tNode node){

    }
    public tNode removeEvens(tNode root){

    }

}
