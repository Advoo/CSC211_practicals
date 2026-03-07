package practical11;

import java.util.HashMap;
import java.util.Map;

import static practical11.Main.shuffle;

public class Test {

    public static void testShuffle(){

        int N = 3;
        int runs = 60000;

        Map<String, Integer> count = new HashMap<>();

        for (int i = 0; i < runs; i++){

            int[] arr = shuffle(N); // can change to biased to test biased

            String key = "" + arr[0] + arr[1] + arr[2];

            if (!count.containsKey(key)){
                count.put(key, 1);

            }else {
                count.put(key, count.get(key)+ 1);
            }

        }

        for(String key : count.keySet()){
            System.out.println(key + " : " + count.get(key));
        }
    }
}
