package avlTree;


import java.util.Map;
import java.util.Objects;

/**
 * @author sodha
 */
public class Solution {

    static Node root = null;

    static Node createNodeFromKey(int key) {
        return new Node(key);
    }

    static Node createNodeFromKey(int key, Node node) {
        return new Node(key, node);
    }


    static void buildAvl(Node node) {

    }

    static void inOrder(Node node) {

        if (!Objects.isNull(node)) {

            inOrder(node.left);
            System.out.printf(node.key + " ");
            inOrder(node.right);

        }

    }




    static void add(int key) {

        if (Objects.isNull(root)) {
            root = createNodeFromKey(key);
        } else {

            insert(root, key);

        }

    }


    static int height(Node node) {

        if (node == null) {
            return 0;
        }

        return Math.max(height(node.right), height(node.left));

    }


    static Node leftRotate(Node node) {

        Node right = node.right;

        Node left = node.left;


        node.right = right.left;

        right.left = node;

        node.height = Math.max(height(node.left), height(node.right)) + 1;

        right.height = Math.max(height(right.left), height(right.right)) + 1;

        return  right;


    }


    static Node rightRotate(Node node) {


        Node right = node.right;

        Node left = node.left;


        node.left = left.right;

        left.right = node;


        node.height = Math.max(height(node.left), height(node.right)) + 1;

        left.height  = Math.max(height(left.left), height(left.right)) + 1;

        return left;

    }


    static Node insert(Node node, int key) {

        if (node == null) {
            return createNodeFromKey(key);
        }

        if (node.key >= key) {
            node.left = insert(node.left, key);
        } else {
            node.right = insert(node.right, key);
        }


        node.height = Math.max(height(node.left), height(node.right)) + 1;


        int balance = (node.right==null? 0: node.right.height) - (node.left == null? 0: node.left.height);


        // right right
        if (balance > 1 && node.right != null && key > node.right.key) {


//            leftrotate
            return  leftRotate(node);


        }

        // right left
        if (balance > 1 && node.left != null && key <  node.left.key) {


            node.right = rightRotate(node.right);
            return leftRotate(node);

            // rightRotate(node->right)
            // left rotate(node)

        }

        // left left
        if (balance < -1 && node.left != null && key <  node.left.key) {


            // right rotate

            return rightRotate(node);

        }


        // left right
        if (balance < -1 && node.right != null && key <  node.right.key) {


            // leftRotate(node->left)
            // rightRotate(node)

            node.left = leftRotate(node.left);

            return rightRotate(node);

        }


        return node;

    }

    public static void main(String[] args) {

        add(10);
        add(5);
        add(15);
        add(20);
        add(25);
        System.out.printf("");


    }

}

class Node {

    public Node(int key) {
        this.key = key;
    }

    public Node(int key, Node parent) {
        this.key = key;
        this.parent = parent;
    }

    Node parent;

    Node right;

    Node left;

    int height = 0;

    int key;


}