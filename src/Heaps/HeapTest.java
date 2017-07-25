package Heaps;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by ankitsharma on 7/12/17.
 */
class HeapTest {

    private static List<Integer> array;
    private static Heap heap;

    @BeforeAll
    public static void initTestClass() {
        array = new ArrayList<>(Arrays.asList(4,1,3,2,16,9,10,14,8,7));
        heap = new Heap();
    }

    @Test
    void testBuildMaxHeap() {
        heap.buildMaxHeap(array);
        System.out.println(array);
        assertEquals(16, (int) array.get(0));
    }

    @Test
    void testBuildMinHeap() {
        heap.buildMinHeap(array);
        System.out.println(array);
        assertEquals(1, (int) array.get(0));
    }

    @Test
    void testHeapSort() {
        heap.heapSort(array);
        System.out.println(array);
        assertEquals(1, (int) array.get(0));
        assertEquals(2, (int) array.get(1));
        assertEquals(9,(int) array.get(6));
    }

    @Test
    void testMaxPriorityQueue() {
        heap.buildMaxHeap(array);
        assertEquals(16, heap.heapMaximum(array));
    }

    @Test
    void testHeapExtractMax() {
        heap.buildMaxHeap(array);
        assertEquals(16, heap.heapExtractMax(array));
        assertEquals(14, heap.heapMaximum(array));
    }

    @Test
    void testHeapIncreaseKey() {
        heap.buildMaxHeap(array);
        heap.heapIncreaseKey(array, 9, 17);
        assertEquals(17, heap.heapMaximum(array));
    }

    @Test
    void testMaxHeapInsert() {
        heap.buildMaxHeap(array);
        heap.maxHeapInsert(array, 15);
        assertEquals(15, (int) array.get(1));
    }
}