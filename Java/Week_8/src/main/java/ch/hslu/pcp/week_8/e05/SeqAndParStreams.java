package ch.hslu.pcp.week_8.e05;

import java.util.stream.IntStream;

public class SeqAndParStreams {
    void main() {
        // a
        //a();
        // b
        b();
    }

    private void a() {
        IntStream.iterate(0, n -> n + 1)
                .limit(100)
                .forEach(i -> System.out.print(i + ", "));
    }

    // task wird in chunks zerelgt die jeweils von einem anderen Thread parallel bearbeitet werden
    // forEachOrdered wenn encounter order eingehalten werden soll
    private void b() {
        IntStream.iterate(0, n -> n + 1)
                .parallel()
                .limit(100)
                .forEach(i -> System.out.print(i + ", "));
    }
}
