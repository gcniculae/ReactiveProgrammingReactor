package reactiveprogramming.flux;

import reactiveprogramming.util.NameProducer;
import reactiveprogramming.util.Util;
import reactor.core.publisher.Flux;

public class FluxCreate {

    public static void main(String[] args) {
        Flux.create(fluxSink -> {
                    fluxSink.next(1);
                    fluxSink.next(2);
                    fluxSink.complete();
                })
                .subscribe(Util.getSubscriber());

        Flux.create(fluxSink -> {
                    String country = "";
                    while (!country.equals("Canada")) {
                        country = Util.faker().country().name();
                        System.out.println("Emitting: " + country);
                        fluxSink.next(country);
                    }
                    fluxSink.complete();
                })
                .subscribe(Util.getSubscriber());

        NameProducer nameProducer = new NameProducer();
        Runnable runnable = nameProducer::produce;

        Flux.create(nameProducer)
                .subscribe(Util.getSubscriber());

        for (int index = 0; index < 10; index++) {
            new Thread(runnable).start();
        }
    }
}
