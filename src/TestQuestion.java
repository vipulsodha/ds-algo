import java.util.Arrays;

/**
 * Created by vipulsodha on 06/03/18.
 */
public class TestQuestion {


    public static void test(int[] array) {

        array[1] = 10;


    }


    public static void main(String[] args) {


        int[] array = new int[12];

    test(array);

        System.out.printf(Arrays.toString(array));




    }



}
