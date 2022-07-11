package reactiveprogramming.flux;

import reactor.core.publisher.Flux;

public class FluxMultipleSubscribers {

    public static void main(String[] args) {
        Flux<Integer> integerFlux = Flux.just(1, 2, 3, 4);
        integerFlux.subscribe(System.out::println);
        System.out.println();
        integerFlux.subscribe(System.out::println);
        System.out.println();

        Flux<Integer> evenIntegerFlux = integerFlux.filter(integer -> integer % 2 == 0);
        evenIntegerFlux.subscribe(System.out::println);
    }
}
