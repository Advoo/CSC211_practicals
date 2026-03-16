package practical16;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        String[] words = {
                "heap","tree","algorithms", "data",
                "Structure", "queue","stack","sort",
                "binary","node"," something","edge", "graph"
        };
        System.out.println("Original words: ");
        System.out.println(Arrays.toString(words));

        long start = System.nanoTime();

        HeapSort.heapSort(words);

        long end = System.nanoTime();

        System.out.println("Sorted words: ");
        System.out.println(Arrays.toString(words));

        System.out.println("Time taken : " + (end - start) + " ns.");
    }
}
