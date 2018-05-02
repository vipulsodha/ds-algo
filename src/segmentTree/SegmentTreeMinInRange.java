package segmentTree;

/**
 * Created by vipulsodha on 01/04/18.
 */
public class SegmentTreeMinInRange {


    static int recurseSTContruct(int start, int end, int[] arr, int[] segmentTree, int indexOfSt) {

        if (start == end) {
            segmentTree[indexOfSt] = arr[start];
            return arr[start];
        }

        int mid = (int) Math.ceil((end + start)/2);
        segmentTree[indexOfSt] = Math.min(recurseSTContruct(start, mid, arr, segmentTree, 2 * indexOfSt + 1), recurseSTContruct(mid+1, end, arr, segmentTree, 2 * indexOfSt + 2));

        return segmentTree[indexOfSt];
    }

    static int[] constructST(int[] arr, int n) {


        int h = (int)(Math.log(n)/Math.log(2) + 1);

        int sTSize = (int) (2 * Math.pow(2 , h) - 1);

        int[] segmentTree = new int[sTSize];

        recurseSTContruct(0, n-1, arr, segmentTree, 0);

        return segmentTree;
    }


    static int findMinInRangeRecurse(int[] arr, int[] segmentTree, int queryStart, int queryEnd, int start, int end, int index) {


        if (start >= queryStart  &&  end <= queryEnd ) {
            return segmentTree[index];
        }

        if (end < queryStart || start > queryEnd) {
            return Integer.MAX_VALUE;
        }

        int mid = (int) Math.ceil((start+ end)/2);


        return Math.min(findMinInRangeRecurse(arr, segmentTree, queryStart, queryEnd, start, mid, 2 * index +1),findMinInRangeRecurse(arr, segmentTree, queryStart, queryEnd, mid+1, end, 2 * index +2));

    }
    public static void main(String[] args) {

        int[] arr = {-1, 3, 4,0,2,1};
        int [] segMentTree = constructST(arr, arr.length);


        int mid = (int) Math.ceil((0+5)/2);
        System.out.println(findMinInRangeRecurse(arr, segMentTree, 1,4, 0, 5, 0));

    }
}
