package reactiveprogramming.assignment2;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import reactiveprogramming.util.Util;
import reactor.core.publisher.Flux;

public class Main {

    public static void main(String[] args) {
        StockPricePublisher stockPricePublisher = new StockPricePublisher();
        stockPricePublisher.getPrice()
                .subscribe(
                        Util.onNext(),
                        Util.onError(),
                        Util.onComplete()
                );

        Flux.range(3, 5)
                .map(i -> i / (i - 4))
                .subscribe(
                        Util.onNext(),
                        Util.onError(),
                        Util.onComplete()
                );

        Flux.range(1, 10)
                .subscribeWith(new Subscriber<Integer>() {

                    private Subscription subscription;

                    @Override
                    public void onSubscribe(Subscription subscription) {
                        this.subscription = subscription;
                    }

                    @Override
                    public void onNext(Integer next) {
                        System.out.println(next);
                    }

                    @Override
                    public void onError(Throwable throwable) {

                    }

                    @Override
                    public void onComplete() {
                        System.out.println("done");
                    }

                });
    }
}
