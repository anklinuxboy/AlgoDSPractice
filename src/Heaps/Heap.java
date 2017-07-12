package Heaps;

import java.util.List;

/**
 * Created by ankitsharma on 7/12/17.
 */
public class Heap {

    public void buildMaxHeap(List<Integer> array) {
        int heapSize = array.size()-1;
        for (int i = heapSize / 2; i >= 0; i--) {
            maxHeapify(array, i);
        }
    }

    public void buildMinHeap() {

    }

    public void maxHeapify(List<Integer> array, int index) {
        int largest;
        int leftChildIndex = getLeftChildIndex(index);
        int rightChildIndex = getRightChildIndex(index);

        if (leftChildIndex <= array.size()-1 && array.get(leftChildIndex) > array.get(index)) {
            largest = leftChildIndex;
        } else {
            largest = index;
        }

        if (rightChildIndex <= array.size()-1 && array.get(rightChildIndex) > array.get(largest)) {
            largest = rightChildIndex;
        }

        if (largest != index) {
            swap(array, largest, index);
            maxHeapify(array, largest);
        }
    }

    private void swap(List<Integer> array, int index1, int index2) {
        int temp = array.get(index1);
        array.set(index1, array.get(index2));
        array.set(index2, temp);
    }

    public void minHeapify() {

    }

    public int getParentIndex(int index) {
        return index / 2;
    }

    // Extra 1 because of 0 index
    public int getLeftChildIndex(int index) {
        return index * 2 + 1;
    }

    public int getRightChildIndex(int index) {
        return index * 2 + 2;
    }
}
