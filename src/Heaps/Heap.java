package Heaps;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by ankitsharma on 7/12/17.
 */
public class Heap implements PriorityQueue {

    private boolean isMaxHeap = false;

    public void buildMaxHeap(List<Integer> array) {
        int heapSize = array.size() / 2 - 1;
        for (int i = heapSize; i >= 0; i--) {
            maxHeapify(array, array.size()-1, i);
        }
        isMaxHeap = true;
    }

    public void buildMinHeap(List<Integer> array) {
        int heapSize = array.size() / 2 - 1;
        for (int i = heapSize; i >= 0; i--) {
            minHeapify(array, array.size()-1, i);
        }
    }

    public void maxHeapify(List<Integer> array, int max, int index) {
        int largest;
        int leftChildIndex = getLeftChildIndex(index);
        int rightChildIndex = getRightChildIndex(index);

        if (leftChildIndex < max && array.get(leftChildIndex) > array.get(index)) {
            largest = leftChildIndex;
        } else {
            largest = index;
        }

        if (rightChildIndex < max && array.get(rightChildIndex) > array.get(largest)) {
            largest = rightChildIndex;
        }

        if (largest != index) {
            swap(array, largest, index);
            maxHeapify(array, max, largest);
        }
    }

    private void swap(List<Integer> array, int index1, int index2) {
        int temp = array.get(index1);
        array.set(index1, array.get(index2));
        array.set(index2, temp);
    }

    public void minHeapify(List<Integer> array, int min, int index) {
        int smallest;
        int leftChildIndex = getLeftChildIndex(index);
        int rightChildIndex = getRightChildIndex(index);

        if (leftChildIndex <= min && array.get(leftChildIndex) < array.get(index)) {
            smallest = leftChildIndex;
        } else {
            smallest = index;
        }

        if (rightChildIndex <= min && array.get(rightChildIndex) < array.get(smallest)) {
            smallest = rightChildIndex;
        }

        if (smallest != index) {
            swap(array, smallest, index);
            minHeapify(array, min, smallest);
        }
    }

    public void heapSort(List<Integer> array) {
        buildMaxHeap(array);
        for (int i = array.size() -1; i >= 0; i--) {
            swap(array, 0, i);
            maxHeapify(array, i,0);
        }
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

    public boolean isMaxHeap() {
        return isMaxHeap;
    }

    public int heapMaximum(List<Integer> array) {
        return array.get(0);
    }

    @Override
    public int heapExtractMax(List<Integer> array) {
        if (array.size() == 0) {
            throw new IllegalArgumentException("Array size zero");
        }

        int max = array.get(0);
        array.set(0, array.get(array.size()-1));
        array.remove(array.size()-1);

        maxHeapify(array, array.size()-1, 0);
        return max;
    }

    @Override
    public void heapIncreaseKey(List<Integer> array, int index, int key) {
        if (key < array.get(index)) {
            throw new IllegalArgumentException("Key is less than the current value");
        }

        array.set(index, key);
        int parentIndex = getParentIndex(index);
        while (array.get(parentIndex) < array.get(index)) {
            swap(array, index, parentIndex);
            index = parentIndex;
            parentIndex = getParentIndex(index);
        }
    }

    @Override
    public void maxHeapInsert(List<Integer> array, int key) {
        array.add(Integer.MIN_VALUE);
        heapIncreaseKey(array, array.size()-1, key);
    }
}
