import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();


        Map<String, Integer> map = new HashMap<>();

        for(int i = 0; i < N; i++) {

            String s = scanner.next();
            if(map.containsKey(s)) {
                map.put(s, map.get(s) + 1);
            } else {
                map.put(s, 1);
            }

        }

        int Q = scanner.nextInt();

        for(int j = 0; j < Q; j ++) {

            String s = scanner.next();

            if(map.containsKey(s)) {
                System.out.println(map.get(s));
            } else {
                System.out.println(0);
            }

        }

    }
}
