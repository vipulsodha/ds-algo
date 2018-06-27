package snakeAndLadder;



import java.util.*;

public class Solution {

    static int quickestWayUp( int[][] ladders, int[][] snakes ) {

        int[] board = new int[100+1];
        int[] distance = new int[100+1];
        boolean[] isVisited = new boolean[100+1];
        Arrays.fill(distance, -1);

        for (int i = 0; i < ladders.length; i ++ ) {

            board[ladders[i][0]] =ladders[i][1];
        }

        for (int i = 0; i < snakes.length; i ++ ) {
            board[snakes[i][0]] = snakes[i][1];
        }

        Queue<Integer> queue = new LinkedList<>();

        distance[1] = 0;
        isVisited[1] = true;
        queue.add(1);

        while (!queue.isEmpty()) {
            int currentIndex = queue.poll();

            if (board[currentIndex] !=0 ) {
                if(isVisited[board[currentIndex]] == false) {
                    int adjacentIndex = board[currentIndex];
                    isVisited[adjacentIndex] = true;
                    distance[adjacentIndex] = distance[currentIndex];
                    queue.add(adjacentIndex);
                }
            } else {

                for (int i =1; i <= 6 && currentIndex + i <= 100; i ++) {
                    int adjacentIndex = currentIndex + i;
                    if (!isVisited[adjacentIndex]) {
                        isVisited[adjacentIndex] = true;
                        distance[adjacentIndex] = distance[currentIndex] + 1;
                        queue.add(adjacentIndex);
                    }
                }
            }
        }

        return distance[100];
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int n = in.nextInt();
            int[][] ladders = new int[n][2];
            for(int ladders_i = 0; ladders_i < n; ladders_i++){
                for(int ladders_j = 0; ladders_j < 2; ladders_j++){
                    ladders[ladders_i][ladders_j] = in.nextInt();
                }
            }
            int m = in.nextInt();
            int[][] snakes = new int[m][2];
            for(int snakes_i = 0; snakes_i < m; snakes_i++){
                for(int snakes_j = 0; snakes_j < 2; snakes_j++){
                    snakes[snakes_i][snakes_j] = in.nextInt();
                }
            }
            int result = quickestWayUp(ladders, snakes);
            System.out.println(result);
        }
        in.close();
    }
}


