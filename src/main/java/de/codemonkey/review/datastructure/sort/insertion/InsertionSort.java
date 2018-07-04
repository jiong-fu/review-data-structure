package de.codemonkey.review.datastructure.sort.insertion;

import de.codemonkey.review.datastructure.sort.Sort;

import static de.codemonkey.review.datastructure.sort.ArithmeticUtils.isSmallerThan;

public class InsertionSort<N extends Number> implements Sort<N> {

    @Override
    public N[] sort(N[] array) {
        for (int i = 0; i < array.length; i++) {
            insertElement(array[i], array, i);
        }
        return array;
    }

    /**
     * Insert element into the ordered area of the array
     *
     * @param element the element to be inserted
     * @param array   the array to be sorted
     * @param bound   the bound of the ordered area
     */
    private void insertElement(N element, N[] array, int bound) {
        for (int i = 0; i < bound; i++) {
            if (isSmallerThan(element, array[i])) {
                for (int j = bound; j > i; j--) {
                    array[j] = array[j - 1];
                }
                array[i] = element;
                break;
            }
        }
    }

}
