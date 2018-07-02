package de.codemonkey.review.datastructure.sort.exchange;

import de.codemonkey.review.datastructure.sort.Sort;

import static de.codemonkey.review.datastructure.sort.ArithmeticUtils.isSmallerThan;

public class CocktailShakerSort<N extends Number> implements Sort<N> {

    @Override
    public N[] sort(N[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j <= array.length - i - 2; j++) {
                if (isSmallerThan(array[j + 1], array[j])) {
                    N temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
            for (int j = array.length - i - 2; j >= 0; j--) {
                if (isSmallerThan(array[j + 1], array[j])) {
                    N temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
        return array;
    }

}
