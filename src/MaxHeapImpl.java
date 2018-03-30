import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by vipulsodha on 04/03/18.
 */
public class MaxHeapImpl implements  MaxHeap {

    private List<Integer> heap = new ArrayList<>();


    public static void main(String[] args) {

        MaxHeap maxHeap = new MaxHeapImpl();

        maxHeap.insertNodes(Arrays.asList(5,2,3,6,7));

        maxHeap.printSorted();

    }


    @Override
    public void insertNodes(List<Integer> nodes) {
        heap.addAll(nodes);

        buildMaxHeap();
    }

    @Override
    public void insertNode(Integer node) {

        heap.add(node);

        buildMaxHeap();
    }

    @Override
    public Integer getMax() {
        return heap.get(0);
    }

    @Override
    public Integer extractMax() {
        int max = this.getMax();

        heap.set(0, heap.size() -1);
        heap.remove(heap.size() -1);

        maxHeapify(0);

        return  max;

    }

    @Override
    public void printSorted() {


        int size = heap.size();


        for (int i = 0; i < size; i ++ ) {
            System.out.println(this.extractMax());
        }

    }


    private void buildMaxHeap() {

        for (int i = heap.size()/2; i >= 0; i--) {

            maxHeapify(i);

        }
    }


    private void maxHeapify(Integer index) {

        int left = 2 * index + 1;
        int right = 2 * index + 2;


        if(left > heap.size() - 1 && right > heap.size() - 1) {
            return;
        }

        Integer largest;

        if(left < heap.size() && heap.get(left) > heap.get(index)) {
            largest = left;
        } else {
            largest = index;
        }

        if(right < heap.size() && heap.get(right) > heap.get(largest)) {
            largest  = right;
        }

        if(largest != index) {

            int temp = heap.get(index);
            heap.set(index, heap.get(largest));
            heap.set(largest, temp);

        }

        maxHeapify(largest);

    }


}
