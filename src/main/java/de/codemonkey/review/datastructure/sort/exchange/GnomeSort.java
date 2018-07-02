package de.codemonkey.review.datastructure.sort.exchange;

import de.codemonkey.review.datastructure.sort.Sort;

import static de.codemonkey.review.datastructure.sort.ArithmeticUtils.isSmallerThan;

public class GnomeSort<N extends Number> implements Sort<N> {

    @Override
    public N[] sort(N[] array) {
        for (int i = 0; i < array.length; ) {
            if (i == 0 || isSmallerThan(array[i - 1], array[i])) {
                i++;
            } else {
                N temp = array[i];
                array[i] = array[i - 1];
                array[i - 1] = temp;
                i--;
            }
        }
        return array;
    }

}
