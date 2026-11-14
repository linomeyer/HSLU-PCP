package ch.hslu.pcp.week_9.e03;

import java.util.concurrent.CompletableFuture;

/**
 * Zwei CompletableFutures parallel ausführen, mit thenCombineAsync kombinieren
 * und das Resultat mittels thenAccept konsumieren.
 * <p>
 * Hinweis: Da diese Klasse selbst CompletableFuture heisst, wird die JDK-Klasse
 * voll qualifiziert verwendet.
 */
public class CompFuture {

    void main() throws InterruptedException {
        System.out.println("-> Now waiting for things to happen!");

        // 1. Erstes Future: blockiert 3000ms
        CompletableFuture<Long> longLastingTaskFuture =
                CompletableFuture.supplyAsync(() -> {
                    sleep(3000);
                    System.out.print(3000);
                    return 3000L;
                });

        // 2. Zweites Future: blockiert 6000ms
        CompletableFuture<Long> evenLongerLastingTaskFuture =
                CompletableFuture.supplyAsync(() -> {
                    sleep(6000);
                    System.out.print(6000);
                    return 6000L;
                });

        // 3. Kombination der beiden Futures, wird nach deren Terminierung ausgeführt
        CompletableFuture<String> lastTaskFuture =
                longLastingTaskFuture.thenCombineAsync(evenLongerLastingTaskFuture, (s, t) -> {
                    sleep(2000);
                    return "was waiting for " + (s + t + 2000) + "ms";
                });

        // 4. Resultat konsumieren mittels Methoden-Referenz
        lastTaskFuture.thenAccept(System.out::print);

        // 5. Main-Thread: jede halbe Sekunde einen Punkt ausgeben
        for (int i = 0; i < 30; i++) {
            System.out.print(".");
            Thread.sleep(500);
        }

        System.out.println();
        System.out.println("-> Done.");
    }

    private static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new IllegalStateException(e);
        }
    }
}
