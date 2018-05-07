package disjointSet;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by vipulsodha on 30/04/18.
 */
public class Solution {


    public static void main(String[] args) {


        Disjoint set = new Disjoint();


        set.makeSet(1);
        set.makeSet(2);
        set.makeSet(3);
        set.makeSet(4);
        set.makeSet(5);
        set.makeSet(6);
        set.makeSet(7);

        set.union(1,4);
        set.union(1,5);

        set.union(1,2);


        set.union(6,7);

        set.union(3,6);

        set.union(1,6);

        set.findSet(7);


        set.print();




    }


}



class Disjoint {

    class Node {
        int rank;
        long data;
        Node parent;


        public int getRank() {
            return rank;
        }

        public void setRank(int rank) {
            this.rank = rank;
        }

        public long getData() {
            return data;
        }

        public void setData(long data) {
            this.data = data;
        }

        public Node getParent() {
            return parent;
        }

        public void setParent(Node parent) {
            this.parent = parent;
        }
    }



    Map<Long, Node> map = new HashMap<>();


    public void makeSet(long data) {

        Node node = new Node();

        node.setData(data);

        node.setRank(0);

        node.setParent(node);

        map.put(data, node);
    }



    public boolean union (long data1, long data2) {


        Node node1 = map.get(data1);
        Node node2 = map.get(data2);

        Node node1Parent = findSet(node1);

        Node node2Parent = findSet(node2);

        if (node1Parent == node2Parent) {
            return  false;
        }

        if (node1Parent.getRank() > node2Parent.getRank()) {

            node2Parent.setParent(node1Parent);

        } else if (node1Parent.getRank() < node2Parent.getRank()){

            node1Parent.setParent(node2Parent);

        } else {

            node1Parent.setRank(node1Parent.getRank() + 1);
            node2Parent.setParent(node1Parent);
        }

        return true;
    }


    public long findSet(long data) {

        return findSet(map.get(data)).getData();
     }



    private Node findSet(Node node) {

        if(node.parent == node) {
            return node;
        }
        node.parent =  findSet(node.parent);

        return node.parent;

    }


    public void print() {
        System.out.println(map);
    }

}


