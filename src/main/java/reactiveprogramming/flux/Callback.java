package reactiveprogramming.flux;

import reactiveprogramming.util.Util;
import reactor.core.publisher.Flux;

public class Callback {

    public static void main(String[] args) {
        Flux.create(fluxSink -> {
                    System.out.println("Inside create.");
                    for (int index = 0; index < 5; index++) {
                        fluxSink.next(index);
                    }
                    fluxSink.complete();
                    System.out.println("Completed.");
                })
                .doOnComplete(() -> System.out.println("doOnComplete"))
                .doFirst(() -> System.out.println("doFirst"))
                .doOnNext(o -> System.out.println("doOnNext " + o))
                .doOnSubscribe(s -> System.out.println("doOnSubscribe"))
                .doOnRequest(l -> System.out.println("doOnRequest" + l))
                .doOnError(error -> System.out.println("doOnError " + error))
                .doOnTerminate(() -> System.out.println("doNotTerminate"))
                .doOnCancel(() -> System.out.println("doOnCancel"))
                .doFinally((signalType) -> System.out.println("doFinally" + signalType))
                .doOnDiscard(Object.class, o -> System.out.println("doOnDiscard " + o))
                .subscribe(Util.getSubscriber());
    }
}
