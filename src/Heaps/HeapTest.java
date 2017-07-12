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
}