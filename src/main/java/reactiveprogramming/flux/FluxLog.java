package reactiveprogramming.flux;

import reactiveprogramming.util.Util;
import reactor.core.publisher.Flux;

public class FluxLog {

    public static void main(String[] args) {
        Flux<String> names = Flux.range(1, 10)
                .log()
                .map(integer -> Util.faker().name().fullName())
                .log();
        names.subscribe(Util.onNext());
    }
}
