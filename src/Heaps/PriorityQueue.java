package Heaps;

import java.util.List;

public interface PriorityQueue {
    int heapMaximum(List<Integer> array);
    int heapExtractMax(List<Integer> array);
    void heapIncreaseKey(List<Integer> array, int index, int key);
    void maxHeapInsert(List<Integer> array, int key);
}
