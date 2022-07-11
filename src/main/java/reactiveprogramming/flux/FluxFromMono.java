package reactiveprogramming.flux;

import reactiveprogramming.util.Util;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class FluxFromMono {

    public static void main(String[] args) {
        Mono<Integer> mono = Mono.just(1);

        Flux<Integer> flux = Flux.from(mono);
        flux.subscribe(Util.onNext());
    }
}
