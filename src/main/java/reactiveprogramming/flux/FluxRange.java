package reactiveprogramming.flux;

import reactiveprogramming.util.Util;
import reactor.core.publisher.Flux;

public class FluxRange {

    public static void main(String[] args) {
        Flux<Integer> integerFlux = Flux.range(1, 10);
        integerFlux.subscribe(Util.onNext());
        System.out.println();

        Flux<String> names = Flux.range(1, 10)
                .map(integer -> Util.faker().name().fullName());
        names.subscribe(Util.onNext());
    }
}
