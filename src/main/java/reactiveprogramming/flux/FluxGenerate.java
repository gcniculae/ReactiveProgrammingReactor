package reactiveprogramming.flux;

import reactiveprogramming.util.Util;
import reactor.core.publisher.Flux;

public class FluxGenerate {

    public static void main(String[] args) {
        Flux.generate(synchronousSink -> {
                    // synchronousSink acts like an infinite loop
                    synchronousSink.next(Util.faker().country().name());
                    // it can be emitted only one item
                    synchronousSink.next(Util.faker().country().name());
                })
                .subscribe(Util.getSubscriber());
        System.out.println();

        Flux.generate(synchronousSink -> {
                    synchronousSink.next(Util.faker().country().name());
                    synchronousSink.complete();
                })
                .subscribe(Util.getSubscriber());
        System.out.println();

        Flux.generate(synchronousSink -> {
                    synchronousSink.next(Util.faker().country().name());
                })
                .take(2)
                .subscribe(Util.getSubscriber());
        System.out.println();

        Flux.generate(synchronousSink -> {
                    String country = Util.faker().country().name();
                    synchronousSink.next(country);

                    if (country.equals("Canada")) {
                        synchronousSink.complete();
                    }
                })
                .subscribe(Util.getSubscriber());
    }
}
