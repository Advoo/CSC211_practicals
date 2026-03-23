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

        node.right = buildBalanced((mid + 1), end);

        return node;
    }
    public boolean isBST(tNode node, int min, int max){

        if(node == null ) return true; //empty tree is vvalid

        if (node.key < min || node.key > max)
            return false;

        //check left & right recursively

        return isBST(node.left, min , node.key -1)
                && isBST(node.right, node.key + 1, max);

    }
    public tNode delete(tNode root , int key){
        if (root == null) return null; // if tree is empty

        if (key < root.key)
            root.left = delete(root.left, key); //search left

        else if (key > root.key)
            root.right = delete(root.right, key);
        // found node to delete
        else {
            //case1 & 2 with 1 or no child
            if (root.left == null) return root.right;
            if (root.right == null) return root.left;

            //2 children
            tNode minNode = findMin(root.right);

            //delete duplicates from subtree
            root.right = delete(root.right, minNode.key);


        }
        return root;


    }
    private tNode findMin(tNode node){
        while (node.left != null)
            node = node.left;
        return node;

    }
    public tNode removeEvens(tNode root){


    }

}
