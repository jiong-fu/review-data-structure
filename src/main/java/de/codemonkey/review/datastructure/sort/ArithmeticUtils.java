package de.codemonkey.review.datastructure.sort;

public final class ArithmeticUtils {

    private ArithmeticUtils() {
    }

    public static <N extends Number> boolean isGreaterThan(N element1, N element2) {
        return element1.doubleValue() > element2.doubleValue();
    }

    public static <N extends Number> boolean isGreaterThanOrEqual(N element1, N element2) {
        return element1.doubleValue() >= element2.doubleValue();
    }

    public static <N extends Number> boolean isSmallerThan(N element1, N element2) {
        return element1.doubleValue() < element2.doubleValue();
    }

    public static <N extends Number> boolean isSmallerThanOrEqual(N element1, N element2) {
        return element1.doubleValue() <= element2.doubleValue();
    }

}
