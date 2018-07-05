package de.codemonkey.review.datastructure.sort.exchange;

import de.codemonkey.review.datastructure.sort.Sort;

import static de.codemonkey.review.datastructure.sort.ArithmeticUtils.isSmallerThan;

public class CombSort<N extends Number> implements Sort<N> {

    private static final double SHRINK = 1.3;
    private final BubbleSort<N> bubbleSort = new BubbleSort<>();

    @Override
    public N[] sort(N[] array) {
        int gap = array.length - 1;
        do {
            for (int i = 0; i + gap < array.length; i++) {
                if (isSmallerThan(array[i + gap], array[i])) {
                    N temp = array[i];
                    array[i] = array[i + gap];
                    array[i + gap] = temp;
                }
            }
            gap /= SHRINK;
        } while (gap > 1);
        return bubbleSort.sort(array);
    }

}
