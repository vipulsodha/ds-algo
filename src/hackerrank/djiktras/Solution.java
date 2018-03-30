package hackerrank.djiktras;

import java.util.*;
import java.io.*;
import java.nio.charset.StandardCharsets;

public class Solution {

    static Node[] dj(int n, int m, int[][] edges, int s) {

        PriorityQueue<Node> minHeap = new PriorityQueue<>(n+1, (Node s1, Node s2) -> s1.getDistance().compareTo(s2.getDistance()) );

        int[][] adjacencyMatrix = new int[n+1][n+1];

        List<Integer>[] adjacencyList = new List[n+1];


        for (int i = 0; i < m; i ++ ) {

            if(Objects.isNull(adjacencyList[edges[i][0]])) {

                adjacencyList[edges[i][0]] = new ArrayList<>();
            }

            if (Objects.isNull(adjacencyList[edges[i][1]])) {
                adjacencyList[edges[i][1]] = new ArrayList<>();
            }

            if(adjacencyMatrix[edges[i][0]][edges[i][1]] == 0) {

                adjacencyList[edges[i][0]].add(edges[i][1]);
                adjacencyList[edges[i][1]].add(edges[i][0]);
            }

            if(adjacencyMatrix[edges[i][0]][edges[i][1]] == 0 || adjacencyMatrix[edges[i][0]][edges[i][1]] > edges[i][2]) {

                adjacencyMatrix[edges[i][0]][edges[i][1]] = edges[i][2];
                adjacencyMatrix[edges[i][1]][edges[i][0]] = edges[i][2];
            }
        }

        Node[] distance = new Node[n+1];
        for (int i = 0; i <=n; i ++) {

            Node node = null;

            if(i == s) {
                node = new Node(i, 0);
            } else {
                node = new Node(i, Integer.MAX_VALUE);
            }

            distance[i] = node;
            minHeap.add(node);

        }

        boolean[] processedVertex = new boolean[n+1];

        while (minHeap.size() != 0) {

            Node node = minHeap.remove();

            int currentNodeIndex = node.getIndex();

            processedVertex[currentNodeIndex] = true;

            if(Objects.isNull(adjacencyList[currentNodeIndex])) {

                continue;
            }

            for(int i :  adjacencyList[currentNodeIndex]) {

                if(!processedVertex[i]){

                    int newDistance = node.getDistance() + adjacencyMatrix[currentNodeIndex][i];

                    if(node.getDistance() != Integer.MAX_VALUE && distance[i].getDistance() > newDistance) {

                        minHeap.remove(distance[i]);

                        distance[i].setDistance(newDistance);

                        minHeap.add(distance[i]);
                    }
                }
            }
        }

        return distance;


    }

    public static void main(String[] args) {
        FastScanner in = new FastScanner();
        int q = in.nextInt();
        for(int a0 = 0; a0 < q; a0++){
            int n = in.nextInt();
            int m = in.nextInt();
            int[][] edges = new int[m][3];
            for(int i = 0; i < m; i++){
                for(int j = 0; j < 3; j++){
                    edges[i][j] = in.nextInt();
                }
            }

            int s = in.nextInt();
            Node[] result = dj(n, m, edges, s);

            for (int i = 1; i < result.length; i++) {
                if(i == s) {
                    continue;
                }

                System.out.print(result[i].getDistance() == Integer.MAX_VALUE ? "-1 " : result[i].getDistance() + " ");
            }
            System.out.println("");

//            System.out.println(result.length);
        }
        in.close();
    }
}
class Node {

    private Integer index;
    private  Integer distance;

    public Node(int index, int distance) {

        this.index = index;
        this.distance = distance;
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    public Integer getDistance() {
        return distance;
    }

    public void setDistance(Integer distance) {
        this.distance = distance;
    }
}




 class FastScanner {
    private InputStream stdin;
    private byte[] buffer = new byte[4096];
    private int bufferSize = 0;
    private int bufferPointer = 0;
    private byte[] input = new byte[32];
    private int inputPointer = 0;
    private int inputLength = 0;

    public FastScanner() {
        stdin = new FileInputStream(FileDescriptor.in);
    }

    private void nextBytesInternal() {
        try {
            while(true){
                if(bufferPointer >= bufferSize) {
                    bufferSize = stdin.read(buffer, 0, 4096);
                    bufferPointer = 0;
                }
                if(inputPointer >= input.length) {
                    byte[] newInput = new byte[inputPointer * 2 + 1];
                    if(input.length < 24) {
                        for(int i = 0; i < input.length; ++i) {
                            newInput[i] = input[i];
                        }
                    }
                    else {
                        System.arraycopy(input, 0, newInput, 0, input.length);
                    }
                    input = newInput;
                }
                byte c = buffer[bufferPointer++];
                if(c == (byte)'\n' || c == (byte)' ') {
                    inputLength = inputPointer;
                    inputPointer = 0;
                    return;
                }
                input[inputPointer++] = c;
            }
        }
        catch(IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String next() {
        nextBytesInternal();
        return new String(input, 0, inputLength, StandardCharsets.US_ASCII);
    }

    public byte[] nextBytes() {
        nextBytesInternal();
        byte[] newArray = new byte[inputLength];
        if(inputLength < 24) {
            for(int i = 0; i < inputLength; ++i) {
                newArray[i] = input[i];
            }
        }
        else {
            System.arraycopy(input, 0, newArray, 0, inputLength);
        }
        return newArray;
    }

    public int nextInt() {
        nextBytesInternal();
        int val = 0;
        int mul = 1;
        for(int i = 0; i < inputLength; ++i) {
            int c = input[i] & 0xFF;
            if(c == '-') {
                mul = -1;
            }
            if('0' <= c && c <= '9') {
                val = val * 10 + c - '0';
            }
        }
        return val * mul;
    }

    public long nextLong() {
        nextBytesInternal();
        long val = 0;
        int mul = 1;
        for(int i = 0; i < inputLength; ++i) {
            int c = input[i] & 0xFF;
            if(c == '-') {
                mul = -1;
            }
            if('0' <= c && c <= '9') {
                val = val * 10 + c - '0';
            }
        }
        return val * mul;
    }

    public void close() {
        try {
            stdin.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}