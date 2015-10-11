package algoritmiek.binarySearchTree;

public class BST {

    private BSTNode root;

    public void prettyPrint() {
        if (root != null) {
            root.prettyPrint("→", " ");
        }
    }

    /**
     * Inserts the value into the binary search tree
     */
    public void insert(int number) {
        if (root == null) {
            root = new BSTNode(number);
        } else {
            root.insert(number);
        }
    }
    
    public void insertAVL(int number){
        if (root == null) {
            root = new BSTNode(number);
        } else {
            root = root.insertAVL(number);
        }
    }

    /**
     * Returns true if the number is present as a node in the tree
     */
    public boolean exists(int number) {
        if (root == null) {
            return false;
        }
        return root.exists(number);
    }

    /**
     * Returns the smallest value in the tree (or -1 if tree is empty)
     */
    public int min() {
        if (root == null) {
            return -1;
        }
        return root.min();
    }

    /**
     * Returns the largest value in the tree (or -1 if tree is empty)
     */
    public int max() {
        if (root == null) {
            return -1;
        }
        return root.max();
    }

    /**
     * Returns how many levels deep the deepest level in the tree is (the empty
     * tree is 0 levels deep, the tree with only one root node is 1 deep)
     *
     * @return
     */
    public int depth() {
        if (root == null) {
            return 0;
        }
        return root.depth();
    }

    /**
     * Returns the amount of values in the tree
     *
     * @return
     */
    public int count() {
        if (root == null) {
            return 0;
        }
        return root.count();
    }

    /**
     * Print all the values in the tree in order
     */
    public void print() {
        if (root != null) {
            root.print();
        }
    }

    /**
     * Print all values that lie between min and max in order (inclusive)
     */
    public void printInRange(int min, int max) {
        if (root != null) {
            root.printInRange(min, max);
        }
    }

    /**
     * Delete a number from the tree (if it exists)
     */
    public void delete(int number) {
        if (root == null){
            return;
        }
        if (depth() == 1 && root.getNumber() == number) {
            root = null;
        } else {
            root.delete(number, null);
        }
    }

    public boolean isAVLGebalanceerd() {
        if (root != null){
            return root.isAVLGebalanceerd();
        }
        else {
            return false;
        }
    }

    public static void main(String args[]) {
        BST tree = new BST();
        tree.insert(50);
        tree.insert(2);
        tree.insert(7);
        tree.insert(94);
        tree.insert(24);
        tree.insert(71);
        tree.insert(30);
        tree.insert(49);
        System.out.println("Count: " + tree.count()); // Should be 8
        System.out.println("Min: " + tree.min()); // Should be 2
        System.out.println("Max: " + tree.max()); // Should be 94
        System.out.println("Depth: " + tree.depth()); // Should be 6
        tree.prettyPrint(); // Prints the values in order

        tree.delete(3); // test for value not in tree
        tree.delete(51); // test for value not in tree
        tree.delete(50);
        tree.delete(2);
        tree.delete(7);
        tree.delete(94);
        tree.delete(24);
        tree.delete(71);
        tree.delete(30);
        tree.delete(49);
        System.out.println("Count: " + tree.count()); // Should be 0
        System.out.println("Min: " + tree.min()); // Should be -1
        System.out.println("Max: " + tree.max()); // Should be -1
        System.out.println("Depth: " + tree.depth()); // Should be 0
        tree.prettyPrint(); // Prints the values in order
        System.out.println();
        
        tree.insertAVL(50);
        tree.insertAVL(2);
        tree.insertAVL(7);
        tree.insertAVL(94);
        tree.insertAVL(24);
        tree.insertAVL(71);
        tree.insertAVL(30);
        tree.insertAVL(49);
        System.out.println("Count: " + tree.count()); // Should be 8
        System.out.println("Min: " + tree.min()); // Should be 2
        System.out.println("Max: " + tree.max()); // Should be 94
        System.out.println("Balanced: " + tree.isAVLGebalanceerd()); // Should be true
        tree.prettyPrint(); // Prints the values in order
    }
}
