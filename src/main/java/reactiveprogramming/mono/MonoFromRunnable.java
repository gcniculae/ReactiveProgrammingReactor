package reactiveprogramming.mono;

import reactiveprogramming.util.Util;
import reactor.core.publisher.Mono;

public class MonoFromRunnable {

    public static void main(String[] args) {
        Mono.fromRunnable(timeConsumingProcess())
                .subscribe(
                        Util.onNext(),
                        Util.onError(),
                        Util.onComplete()
                );
    }

    private static Runnable timeConsumingProcess() {
        return () -> {
            Util.threadSleep(3);
            System.out.println("Operation complete.");
        };
    }
}
