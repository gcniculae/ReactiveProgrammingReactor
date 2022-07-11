package reactiveprogramming.util;

import com.github.javafaker.Faker;
import org.reactivestreams.Subscriber;

import java.util.function.Consumer;

public class Util {

    private static final com.github.javafaker.Faker FAKER = com.github.javafaker.Faker.instance();

    public static Consumer<Object> onNext() {
//        return object -> System.out.println("Received: " + object);

        return new Consumer<>() {
            @Override
            public void accept(Object o) {
                System.out.println("Received: " + o);
            }

            @Override
            public Consumer<Object> andThen(Consumer<? super Object> after) {
                return Consumer.super.andThen(after);
            }
        };
    }

    public static Consumer<Throwable> onError() {
//        return throwable -> System.out.println("Error: " + throwable.getMessage());

        Consumer<Throwable> throwableConsumer = new Consumer<Throwable>() {
            @Override
            public void accept(Throwable throwable) {
                System.out.println("Error: " + throwable.getMessage());
            }
        };

        return throwableConsumer;
    }

    public static Runnable onComplete() {
        return () -> System.out.println("Completed.");
    }

    public static Faker faker() {
        return FAKER;
    }

    public static void threadSleep(int seconds) {
        try {
            Thread.sleep(seconds * 1000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static Subscriber<Object> getSubscriber() {
        return new DefaultSubscriber();
    }

    public static Subscriber<Object> getSubscriberWithName(String name) {
        return new DefaultSubscriber(name);
    }
}
