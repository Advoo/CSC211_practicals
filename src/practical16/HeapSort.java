package practical16;

public class HeapSort {
    public static void heapSort(String[] array) {

        Heap heap = new Heap(array);
        heap.buildHeapBottomUp();

        for (int i = array.length - 1; i > 0; i--){
            String temp= array[0];
            array[0] = array[i];
            array[i] + temp;
        }
    }
}
