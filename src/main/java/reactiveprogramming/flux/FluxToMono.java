package reactiveprogramming.flux;

import reactiveprogramming.util.Util;
import reactor.core.publisher.Flux;

public class FluxToMono {

    public static void main(String[] args) {
        Flux.range(1, 10)
                .next()
                .subscribe(
                        Util.onNext(),
                        Util.onError(),
                        Util.onComplete()
                );

        Flux.range(1, 10)
                .filter(integer -> integer > 3)
                .next()
                .subscribe(
                        Util.onNext(),
                        Util.onError(),
                        Util.onComplete()
                );
    }
}
