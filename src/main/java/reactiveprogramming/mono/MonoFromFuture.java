package reactiveprogramming.mono;

import reactiveprogramming.util.Util;
import reactor.core.publisher.Mono;

import java.util.concurrent.CompletableFuture;

public class MonoFromFuture {

    public static void main(String[] args) {
        Mono.fromFuture(getName())
                .subscribe(Util.onNext());

        Util.threadSleep(1);
    }

    private static CompletableFuture<String> getName() {
        return CompletableFuture.supplyAsync(() -> Util.faker()
                .name()
                .firstName());
    }
}
