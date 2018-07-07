package de.codemonkey.review.datastructure.sort.partition;

import de.codemonkey.review.datastructure.sort.Sort;

import static de.codemonkey.review.datastructure.sort.ArithmeticUtils.isSmallerThan;

public class QuickSort<N extends Number> implements Sort<N> {

    @Override
    public N[] sort(N[] array) {
        recursiveSort(array, 0, array.length - 1);
        return array;
    }

    private void recursiveSort(N[] array, int lowIndex, int highIndex) {
        int i = lowIndex, j = highIndex;
        N pivot = array[lowIndex + (highIndex - lowIndex) / 2];

        while (i <= j) {
            while (isSmallerThan(array[i], pivot)) {
                i++;
            }
            while (isSmallerThan(pivot, array[j])) {
                j--;
            }

            // if the elements to be exchanged are found
            if (i <= j) {
                N temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                i++;
                j--;
            }

            // if there are still elements on the right of the pivot to be sorted, sort recursively
            if (lowIndex < j) {
                recursiveSort(array, lowIndex, j);
            }

            // if there are still elements on the left of the pivot to be sorted, sort recursively
            if (i < highIndex) {
                recursiveSort(array, i, highIndex);
            }
        }
    }

}
