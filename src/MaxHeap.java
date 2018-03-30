import java.util.List;

/**
 * Created by vipulsodha on 04/03/18.
 */
public interface MaxHeap {

    void insertNode(Integer node);
    void insertNodes(List<Integer> nodes);

    Integer getMax();

    Integer extractMax();

    void printSorted();
}
