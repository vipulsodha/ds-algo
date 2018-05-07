package avlTree;


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


    static void add(int key) {

        if (Objects.isNull(root)) {
            root = createNodeFromKey(key);
        } else {

            Node currentNode = insert(root, key);
        }

    }


    static Node insert(Node node, int key) {

        if (node.key > key) {


            if (Objects.isNull(node.right)) {
                node.rightCount ++;
                node.right = createNodeFromKey(key, node);

                return  node.right;
            } else {

                node.rightCount ++;
                return insert(node.right, key);
            }
        } else {


            if (Objects.isNull(node.left)) {
                node.leftCount++;
                node.left = createNodeFromKey(key, node);

                return node.left;
            } else {
                node.leftCount++;
                return insert(node.left, key);
            }
        }

    }


    public static void main(String[] args) {

        add(10);
        add(10);
        add(10);
        add(10);
        add(10);
        add(10);
        System.out.println("hi");

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

    int rightCount = 0;

    int leftCount = 0;

    int key;


}