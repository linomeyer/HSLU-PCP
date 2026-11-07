package ch.hslu.pcp.week_8.e02;

import java.util.Arrays;

public class NumbersSquared {
    void main() {
        printNumbersSquared(new Integer[]{1, 2, 3, 5, 8});
    }

    public void printNumbersSquared(Integer[] nums) {
        Arrays.stream(nums).forEach(num -> System.out.println(num + ": " + (num * num)));
    }
}
