package de.codemonkey.review.datastructure.sort.exchange;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class BubbleSortTest {

    @Test
    public void testBubbleSort() {
        Number[] array = {6, 5, 3, 1, 8, 7, 2, 4};
        Number[] expected = {1, 2, 3, 4, 5, 6, 7, 8};
        assertArrayEquals(expected, new BubbleSort().sort(array));
    }

}
