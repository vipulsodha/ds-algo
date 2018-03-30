import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Random;

/**
 * Created by vipulsodha on 03/11/17.
 */
public class MinHeap {

    public static void main(String[] args) {

        PriorityQueue<Integer> minHeap = new PriorityQueue<>(100, (x,y) -> {
            return y-x;
        });

        Random random = new Random();


        for(int i = 0; i < 100; i++) {

            minHeap.add(random.nextInt(1000));

        }


        Iterator<Integer> iterator = minHeap.iterator();

        while (iterator.hasNext()) {
            System.out.println(minHeap.poll());

        }

//        System.out.println(minHeap);




    }


}
