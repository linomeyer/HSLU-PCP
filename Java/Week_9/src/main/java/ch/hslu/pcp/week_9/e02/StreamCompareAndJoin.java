package ch.hslu.pcp.week_9.e02;

import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.StringJoiner;

public class StreamCompareAndJoin {
    void main() {
        genereateSortAndPrintRandomInts(10, 100);
    }

    public void genereateSortAndPrintRandomInts(int numberOfVals, int maxValueExc) {
        List<Integer> intList = new Random().ints(numberOfVals, 0, maxValueExc)
                .distinct()
                .boxed()
                .sorted(Comparator.reverseOrder())
                .toList();

        StringJoiner joiner = new StringJoiner(" > ");
        intList.forEach(i -> joiner.add(i.toString()));
        System.out.println(joiner);
    }
}
