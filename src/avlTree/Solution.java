package avlTree;


import java.util.*;

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


    static void inOrder(Node node) {

        if (!Objects.isNull(node)) {

            inOrder(node.left);
            System.out.printf(node.key + " ");
            inOrder(node.right);

        }

    }

    static void add(int key) {

//            root = insert(root, key);

        root = nonBalanceInsert(root, key);
    }


    static int ht(Node node) {

        if (node == null) {
            return 0;
        }

        return node.ht;

    }


    static Node leftRotate(Node node) {

        Node right = node.right;

        Node left = node.left;

        node.right = right.left;

        right.left = node;

        node.ht = Math.max(ht(node.left), ht(node.right)) + 1;

        right.ht = Math.max(ht(right.left), ht(right.right)) + 1;

        return  right;

    }


    static Node rightRotate(Node node) {

        Node right = node.right;

        Node left = node.left;

        node.left = left.right;

        left.right = node;

        node.ht = Math.max(ht(node.left), ht(node.right)) + 1;

        left.ht  = Math.max(ht(left.left), ht(left.right)) + 1;

        return left;

    }

    static Node nonBalanceInsert(Node node, int key) {
        if (node == null) {
            return  createNodeFromKey(key);
        }

        if (node.key >= key) {
            node.left = nonBalanceInsert(node.left, key);
        } else {
            node.right = nonBalanceInsert(node.right, key);
        }

        return node;
    }


    static Node insert(Node node, int key) {

        if (node == null) {
            return  createNodeFromKey(key);
        }

        if (node.key >= key) {
            node.left = insert(node.left, key);
        } else {
            node.right = insert(node.right, key);
        }

        node.ht = Math.max(ht(node.left), ht(node.right)) + 1;

        int balance = ht(node.right) - ht(node.left);

        // right right
        if (balance > 1 && node.right != null && key > node.right.key) {

            return  leftRotate(node);

        }


        // right left
        if (balance > 1 && node.left != null && key <  node.left.key) {


            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        // left left
        if (balance < -1 && node.left != null && key <  node.left.key) {

            return rightRotate(node);

        }


        // left right
        if (balance < -1 && node.right != null && key <  node.right.key) {

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
//        System.out.printf("");

//        levelOrderTraversal(root);

//        verticalTraversal(root);

//        topView(root);

        customtopView(root);
    }




    static void customtopView(Node root) {
        TreeMap<Integer, List<Node>> map = new TreeMap<Integer, List<Node>>();

        Map<Node, Integer> hdMap = new HashMap<Node, Integer>();

        hdMap.put(root, 0);

        Queue<Node> queue = new LinkedList<Node>();
        map.put(0, new ArrayList<Node>());
        map.get(0).add(root);

        queue.add(root);


        while (!queue.isEmpty()) {

            Node node = queue.poll();

            Node left = node.left;

            Node right = node.right;

            if (left != null) {

                int hd = hdMap.get(node) - 1;
                hdMap.put(left, hd);

                if (!map.containsKey(hd)) {
                    map.put(hd, new ArrayList<Node>());
                }

                map.get(hd).add(left);
                queue.add(left);
            }

            if (right != null) {

                int hd = hdMap.get(node) + 1;
                hdMap.put(right, hd);

                if (!map.containsKey(hd)) {
                    map.put(hd, new ArrayList<Node>());
                }

                map.get(hd).add(right);
                queue.add(right);
            }

        }

        for (Map.Entry<Integer, List<Node>> e: map.entrySet()) {

            System.out.print(e.getValue().get(0).key + " ");
        }

    }



    static void levelOrderTraversal(Node root) {


        Queue<Node> queue = new LinkedList<>();

        root.hd = 0;


        queue.add(root);


        while (!queue.isEmpty()) {


            Node node = queue.poll();

            if (node.left != null) {
                queue.add(node.left);
            }

            if (node.right != null) {
                queue.add(node.right);
            }

            System.out.print(node.key + " ");

        }


    }

    static void topView(Node root) {
        TreeMap<Integer, List<Node>> map = new TreeMap<>();


        root.hd = 0;

        Queue<Node> queue = new LinkedList<>();
        map.put(root.hd, new ArrayList<>());
        map.get(root.hd).add(root);

        queue.add(root);

        while (!queue.isEmpty()) {

            Node node = queue.poll();

            Node left = node.left;

            Node right = node.right;

            if (left != null) {
                left.hd = node.hd -1;

                if (!map.containsKey(left.hd)) {
                    map.put(left.hd, new ArrayList<>());
                }

                map.get(left.hd).add(left);
                queue.add(left);
            }

            if (right != null) {
                right.hd = node.hd + 1;

                if (!map.containsKey(right.hd)) {
                    map.put(right.hd, new ArrayList<>());
                }

                map.get(right.hd).add(right);
                queue.add(right);
            }

        }

        for (Map.Entry<Integer, List<Node>> e: map.entrySet()) {


            System.out.println(e.getValue().get(0).key);

            System.out.println("");
        }
    }


    static void verticalTraversal(Node root) {

        TreeMap<Integer, List<Node>> map = new TreeMap<>();


        root.hd = 0;

        Queue<Node> queue = new LinkedList<>();
        map.put(root.hd, new ArrayList<>());
        map.get(root.hd).add(root);


        queue.add(root);

        while (!queue.isEmpty()) {

            Node node = queue.poll();

            Node left = node.left;

            Node right = node.right;

            if (left != null) {
                left.hd = node.hd -1;

                if (!map.containsKey(left.hd)) {
                    map.put(left.hd, new ArrayList<>());
                }

                map.get(left.hd).add(left);
                queue.add(left);
            }

            if (right != null) {
                right.hd = node.hd + 1;

                if (!map.containsKey(right.hd)) {
                    map.put(right.hd, new ArrayList<>());
                }

                map.get(right.hd).add(right);
                queue.add(right);
            }

        }

        for (Map.Entry<Integer, List<Node>> e: map.entrySet()) {


            for (Node i : e.getValue()) {
                System.out.print(i.key + " ");
            }

            System.out.println("");
        }
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

    int ht = 1;

    int key;

    int hd;


}