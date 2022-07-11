package reactiveprogramming.mono;

import reactiveprogramming.util.Util;
import reactor.core.publisher.Mono;

import java.util.concurrent.Callable;
import java.util.function.Supplier;

public class MonoFromSupplier {

    public static void main(String[] args) {
        Supplier<String> stringSupplier = () -> getName();
        Mono<String> mono = Mono.fromSupplier(stringSupplier);
        mono.subscribe(Util.onNext());

        Callable<String> stringCallable = () -> getName();
        Mono<String> stringMono = Mono.fromCallable(stringCallable);
        stringMono.subscribe(Util.onNext());
    }

    private static String getName() {
        return Util.faker()
                .name()
                .firstName();
    }
}
