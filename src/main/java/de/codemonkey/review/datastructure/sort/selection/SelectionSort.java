package de.codemonkey.review.datastructure.sort.selection;

import de.codemonkey.review.datastructure.sort.Sort;

import static de.codemonkey.review.datastructure.sort.ArithmeticUtils.isSmallerThan;

public class SelectionSort<N extends Number> implements Sort<N> {

    @Override
    public N[] sort(N[] array) {
        for (int i = 0; i < array.length; i++) {
            int smallestIndex = getSmallestElementIndex(array, i);
            if (i != smallestIndex) {
                System.err.println("Switch " + array[i] + " and " + array[smallestIndex]);
                N temp = array[i];
                array[i] = array[smallestIndex];
                array[smallestIndex] = temp;
            }
        }
        return array;
    }

    /**
     * Get the index of the smallest element in the unordered area of the array
     *
     * @param array the array to be sorted
     * @param bound the bound of the unordered area
     * @return the index of the smallest element
     */
    private int getSmallestElementIndex(N[] array, int bound) {
        N smallestElement = array[bound];
        int smallestIndex = bound;
        for (int i = bound; i < array.length; i++) {
            if (isSmallerThan(array[i], smallestElement)) {
                smallestElement = array[i];
                smallestIndex = i;
            }
        }
        return smallestIndex;
    }

}
