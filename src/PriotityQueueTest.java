

import java.util.PriorityQueue;

/**
 * Created by vipulsodha on 01/05/18.
 */
public class PriotityQueueTest {


    public static void main(String[] args) {



        PriorityQueue<Node> priorityQueue = new PriorityQueue<>(10, (Node s1, Node s2) -> {
            Integer r = s1.distance.compareTo(s2.distance);

            return r==0? s1.position.compareTo(s2.position) : r;
        });





        priorityQueue.add(new Node(0,0, 1, 2));
        priorityQueue.add(new Node(0,0, 1, 3));
        priorityQueue.add(new Node(0,0, 1, 2));
        priorityQueue.add(new Node(0,0, 1, 3));
        priorityQueue.add(new Node(0,0, 1, 2));
        priorityQueue.add(new Node(0,0, 1, 3));
        priorityQueue.add(new Node(0,0, 1, 2));


        while (!priorityQueue.isEmpty()) {
            System.out.println(priorityQueue.poll().position);

        }




    }
}

class Node {

    public Node(int i, int j, int distance, int position) {
        this.i = i;
        this.j = j;
        this.position = position;
        this.distance = distance;
    }

    Node parent;

    Integer i;
    Integer j;

    Integer position;


    Integer distance;

}
