/*
* csc 211 practical 16
* Heap Construction and heap sort
*
* This problem builds heaps using two methods:
* 1. bottom-up heap
* top- down heap using insert
*
* the program then sort words alphabeticallyusing heap sortr
*
* Timing code reused from previous  practicals
*
* assistance from chatGPD USED
* FOR UNDERSTANDING HEAP structure and algorithm design


 */


package practical16;

public class heap {
    private String[] heap;
    private int size;

    public Heap(Sring[] array) {
        heap = array;
        size = array.length;
    }

    //bottom-up heap
    public void buildHeapBottomUp(){
        for (int i = size / 2 - 1; i >= 0; i--) {
            heapify(i);
        }
    }

    private void heapify(int i) {
        int smallest = 1;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < size && heap[left].compareTo(heap[smallest]) < 0)
            smallest = left;

        if (right < size && heap[right].compareTo(heap[smallest]) < 0)
            smallest = right;

        if (smallest != i) {
            String temp = heap[i];
            heap[i] = heap[smallest];
            heap[smallest] = temp;

        }
    }

    }




}
