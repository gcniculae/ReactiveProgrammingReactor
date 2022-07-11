package reactiveprogramming.flux;

import reactiveprogramming.util.Util;
import reactor.core.publisher.Flux;

public class FluxTake {

    public static void main(String[] args) {
        Flux.range(1, 10)
                .log()
                .take(3)
                .log()
                .subscribe(Util.getSubscriber());

        Flux.create(fluxSink -> {
                    String country = "";
                    while (!country.equals("Canada") && !fluxSink.isCancelled()) {
                        country = Util.faker().country().name();
                        System.out.println("Emitting: " + country);
                        fluxSink.next(country);
                    }
                    fluxSink.complete();
                })
                .take(3)
                .subscribe(Util.getSubscriber());
    }
}
