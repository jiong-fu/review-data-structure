package de.codemonkey.review.datastructure.sort.exchange;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class GnomeSortTest {

    @Test
    public void testGnomeSort() {
        Number[] array = {6, 5, 3, 1, 8, 7, 2, 4};
        Number[] expected = {1, 2, 3, 4, 5, 6, 7, 8};
        assertArrayEquals(expected, new GnomeSort().sort(array));
    }

}
