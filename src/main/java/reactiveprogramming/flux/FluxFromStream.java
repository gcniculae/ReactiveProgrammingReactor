package reactiveprogramming.flux;

import reactiveprogramming.util.Util;
import reactor.core.publisher.Flux;

import java.util.List;
import java.util.stream.Stream;

public class FluxFromStream {

    public static void main(String[] args) {
        List<Integer> integers = List.of(1, 2, 3, 4);
        Stream<Integer> stream = integers.stream();

//        stream.forEach(System.out::println);
        // stream will be closed
//        stream.forEach(System.out::println);

        Flux<Integer> fromStream = Flux.fromStream(stream);
        fromStream.subscribe(
                Util.onNext(),
                Util.onError(),
                Util.onComplete());

        fromStream.subscribe(
                Util.onNext(),
                Util.onError(),
                Util.onComplete());

        Flux<Integer> fromStream2 = Flux.fromStream(integers::stream);
        fromStream2.subscribe(
                Util.onNext(),
                Util.onError(),
                Util.onComplete());

        fromStream2.subscribe(
                Util.onNext(),
                Util.onError(),
                Util.onComplete());
    }
}
