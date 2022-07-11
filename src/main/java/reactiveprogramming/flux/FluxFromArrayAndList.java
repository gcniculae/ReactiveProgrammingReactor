package reactiveprogramming.flux;

import reactiveprogramming.util.Util;
import reactor.core.publisher.Flux;

import java.util.Arrays;
import java.util.List;

public class FluxFromArrayAndList {

    public static void main(String[] args) {
        List<Integer> integers = Arrays.asList(1, 2, 3, 4);
        Flux<Integer> integerFlux = Flux.fromIterable(integers);
        integerFlux.subscribe(Util.onNext());
        System.out.println();

        Integer[] integerArray = new Integer[]{1, 2, 3, 4, 5};
        Flux<Integer> fromArray = Flux.fromArray(integerArray);
        fromArray.subscribe(Util.onNext());
    }
}
