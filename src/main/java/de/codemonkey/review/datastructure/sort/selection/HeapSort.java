package de.codemonkey.review.datastructure.sort.selection;

import de.codemonkey.review.datastructure.sort.Sort;

import static de.codemonkey.review.datastructure.sort.ArithmeticUtils.isSmallerThan;

public class HeapSort<N extends Number> implements Sort<N> {

    @Override
    public N[] sort(N[] array) {
        for (int i = 0; i < array.length; i++) {
            buildHeap(array, array.length - i);
            N top = array[0];
            for (int j = 1; j < array.length - i; j++) {
                array[j - 1] = array[j];
            }
            array[array.length - i - 1] = top;
        }
        return array;
    }

    /**
     * Build heap for the unordered area
     *
     * @param array the array to be sorted
     * @param bound the bound of the unordered area
     */
    private void buildHeap(N[] array, int bound) {
        for (int i = bound / 2 - 1; i >= 0; i--) {
            maxHeapify(array, bound, i);
        }
    }

    /**
     * Max-heapify the sub-heap
     *
     * @param array     the array to be sorted
     * @param bound     the bound of the unordered area
     * @param rootIndex the root index of the sub-heap to be max-heapified
     */
    private void maxHeapify(N[] array, int bound, int rootIndex) {
        int leftChildIndex = rootIndex * 2 + 1;
        int rightChildIndex = rootIndex * 2 + 2;
        if (leftChildIndex < bound && isSmallerThan(array[rootIndex], array[leftChildIndex])) {
            N temp = array[rootIndex];
            array[rootIndex] = array[leftChildIndex];
            array[leftChildIndex] = temp;
        }
        if (rightChildIndex < bound && isSmallerThan(array[rootIndex], array[rightChildIndex])) {
            N temp = array[rootIndex];
            array[rootIndex] = array[rightChildIndex];
            array[rightChildIndex] = temp;
        }
    }

}
