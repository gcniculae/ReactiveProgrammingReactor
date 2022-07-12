package reactiveprogramming.flux;

import reactiveprogramming.util.Util;
import reactor.core.publisher.Flux;

public class FluxHandle {

    public static void main(String[] args) {
        Flux.range(1, 20)
                .handle((integer, synchronousSink) -> {
                    if (integer % 2 == 0) {
                        synchronousSink.next(integer);
                    }
                })
                .subscribe(Util.getSubscriber());

        Flux.generate(synchronousSink -> synchronousSink.next(Util.faker().country().name()))
                .map(Object::toString)
                .handle((str, synchronousSink) -> {
                    synchronousSink.next(str);

                    if (str.equals("Canada")) {
                        synchronousSink.complete();
                    }
                })
                .subscribe(Util.getSubscriber());
    }
}
