import java.util.Objects;

/**
 * Created by vipulsodha on 06/03/18.
 */
public class BinarySearchTree {

    public static void main(String[] args) {

        BinarySearchTree tree = new BinarySearchTree();

        tree.insertKey(50);
        tree.insertKey(40);
        tree.insertKey(45);
        tree.insertKey(35);
        tree.insertKey(37);
        tree.insertKey(36);
        tree.insertKey(39);
        tree.insertKey(30);



        System.out.println("=====Descending====");
        tree.traverseDescending();



        tree.removeKey(37);


        System.out.println("=====Descending====");
        tree.traverseDescending();

    }

    private TreeNode root = null;

    public void insertKey(int key) {

        if(Objects.isNull(root)) {
            root = createNodeFromKey(key);
        } else {

            insert(root, key);

        }

    }

    public void removeKey(int key) {

      removeNode(root, key);




    }

    private TreeNode removeNode(TreeNode node, int key) {

        if(Objects.nonNull(node.getKey()) && node.getKey() > key) {

            node.setLeft(removeNode(node.getLeft(), key));

        } else if(Objects.nonNull(node.getKey())  && node.getKey() < key){

            node.setRight(removeNode(node.getRight(), key));

        }

        if(node.getKey() == key) {

            if (Objects.isNull(node.getLeft()) && Objects.isNull(node.getRight())) {
                return null;
            } else if(Objects.isNull(node.getRight()) && Objects.nonNull(node.getLeft())) {
                return node.getLeft();
            } else if(Objects.isNull(node.getLeft()) && Objects.nonNull(node.getRight())) {
                return node.getRight();
            } else {

                TreeNode minNode = findMin(node.getRight());

                node.setKey(minNode.getKey());

                node.setRight(removeNode(node.getRight(), minNode.getKey()));

            }

        }

        return node;
    }


    private TreeNode findMin(TreeNode node) {

        if(Objects.isNull(node.getLeft()) && Objects.isNull(node.getRight())) {
            return node;
        }

        if(Objects.isNull(node.getLeft())) {
            return node.getRight();
        }


        return node.getLeft();

    }

    private TreeNode search(TreeNode node, int key) {

        if (node.getKey() == key) {
            return node;
        }

        if(key > node.getKey()) {
            return search(node.getRight(), key);
        }

        if (key <= node.getKey()) {
            return search(node.getLeft(), key);
        }


        return null;
    }


    public void traverseDescending() {

        descending(root);
    }

    public void traverseInorder() {
        inorderTraverse(root);
    }

    private TreeNode createNodeFromKey (int key) {

        return new TreeNode(key);
    }

    private void inorderTraverse(TreeNode node) {


        if(Objects.nonNull(node.getLeft())) {
            inorderTraverse(node.getLeft());
        }

        System.out.println(node.getKey());

        if (Objects.nonNull(node.getRight())) {
            inorderTraverse(node.getRight());
        }

        return;

    }

    private void descending(TreeNode node) {

        if (Objects.nonNull(node.getRight())) {
            descending(node.getRight());
        }

        System.out.println(node.getKey());

        if(Objects.nonNull(node.getLeft())) {
            descending(node.getLeft());
        }

        return;

    }

    private void insert(TreeNode node, int key) {

        if(node.getKey() >= key) {

            if(Objects.isNull(node.getLeft())) {
                node.setLeft(createNodeFromKey(key));
                return;
            }

            insert(node.getLeft(), key);

        } else if (node.getKey() < key) {

            if(Objects.isNull(node.getRight())) {
                node.setRight(createNodeFromKey(key));
                return;
            }

            insert(node.getRight(), key);
        }

        return;

    }
}

class TreeNode {

    public TreeNode(int key) {
        this.key = key;
        this.left = null;
        this.right = null;
    }

    private int key;

    private TreeNode left;

    private TreeNode right;

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }
}