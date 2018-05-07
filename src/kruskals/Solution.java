package kruskals;



import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class Solution {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String[] gNodesEdges = scanner.nextLine().split(" ");
        int gNodes = Integer.parseInt(gNodesEdges[0].trim());
        int gEdges = Integer.parseInt(gNodesEdges[1].trim());

       List<Edge> edges = new ArrayList<>();


        DisjointSet disjointSet = new DisjointSet();

        Long finalSum = 0L;


        for (int gItr = 0; gItr < gEdges; gItr++) {
            String[] gFromToWeight = scanner.nextLine().split(" ");


            Integer edge1 = Integer.parseInt(gFromToWeight[0].trim());

            Integer edge2 = Integer.parseInt(gFromToWeight[1].trim());
            Edge edge = new Edge(edge1, edge2,Integer.parseInt(gFromToWeight[2].trim()));

            edges.add(edge);

            disjointSet.makeSet(edge1);
            disjointSet.makeSet(edge2);
        }


        edges.sort((e1 , e2) -> e1.weight.compareTo(e2.weight));


        for (Edge edge: edges) {

            if (disjointSet.union(edge.edge1, edge.edge2)) {
                finalSum += edge.weight;
            }

        }

        System.out.println(finalSum);
    }
}



class Edge {


    public Edge(int edge1, int edge2, long weight) {
        this.edge1 = edge1;
        this.edge2 = edge2;
        this.weight = weight;
    }

    public  Integer edge1;
    public  Integer edge2;
    public  Long weight;

}



class DisjointSet {

    private Map<Long, Node> map = new HashMap<>();

    class Node {
        long data;
        Node parent;
        int rank;
    }

    public void makeSet(long data) {
        Node node = new Node();
        node.data = data;
        node.parent = node;
        node.rank = 0;
        map.put(data, node);
    }

    public boolean union(long data1, long data2) {
        Node node1 = map.get(data1);
        Node node2 = map.get(data2);

        Node parent1 = findSet(node1);
        Node parent2 = findSet(node2);

        //if they are part of same set do nothing
        if (parent1.data == parent2.data) {
            return false;
        }

        //else whoever's rank is higher becomes parent of other
        if (parent1.rank >= parent2.rank) {
            //increment rank only if both sets have same rank
            parent1.rank = (parent1.rank == parent2.rank) ? parent1.rank + 1 : parent1.rank;
            parent2.parent = parent1;
        } else {
            parent1.parent = parent2;
        }
        return true;
    }

    /**
     * Finds the representative of this set
     */
    public long findSet(long data) {
        return findSet(map.get(data)).data;
    }

    /**
     * Find the representative recursively and does path
     * compression as well.
     */
    private Node findSet(Node node) {
        Node parent = node.parent;
        if (parent == node) {
            return parent;
        }
        node.parent = findSet(node.parent);
        return node.parent;
    }


}