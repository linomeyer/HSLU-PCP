package ch.hslu.pcp.week_8.e06;

import java.util.Random;

public class Infinity {
    void main() {
        a();
        b();
        bCleanVersion();
    }

    private void bCleanVersion() {
        long position = new Random().ints()
                .takeWhile(i -> i > 12000 || i < 10000)
                .count() + 1;
        System.out.println("Found suitable number at stream position " + position);
    }

    private void b() {
        int[] position = {0};

        new Random().ints()
                .anyMatch(n -> {
                    position[0]++;
                    return n >= 10_000 && n <= 12_000;
                });

        System.out.println("Found suitable number at stream position " + position[0]);
    }

    private void a() {
        System.out.println(new Random().ints().anyMatch(i -> i >= 10000 && i <= 12000));
    }

}
