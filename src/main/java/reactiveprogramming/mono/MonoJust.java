package reactiveprogramming.mono;

import reactiveprogramming.util.Util;
import reactor.core.publisher.Mono;

import java.util.function.Consumer;

public class MonoJust {

    public static void main(String[] args) {
        Mono<Integer> mono = Mono.just(1);
        System.out.println(mono);

//        Mono<Integer> mono = Mono.just("ball")
//                .map(String::length)
//                .map(l -> l / 0);

        mono.subscribe(System.out::println);

        Consumer<Integer> println = System.out::println;
        Consumer<Throwable> error = System.out::println;
        Runnable completed = () -> System.out.println("Completed");
        mono.subscribe(
                println,
                error,
                completed
        );

        mono.subscribe(
                Util.onNext(),
                Util.onError(),
                Util.onComplete()
        );
    }
}
