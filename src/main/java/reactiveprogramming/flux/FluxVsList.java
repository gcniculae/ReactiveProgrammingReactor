package reactiveprogramming.flux;

import reactiveprogramming.util.Util;
import reactor.core.publisher.Flux;

import java.util.ArrayList;
import java.util.List;

public class FluxVsList {

    public static void main(String[] args) {
        System.out.println(getNamesList(5));
        getNamesFlux(5).subscribe(Util.onNext());
    }

    private static Flux<String> getNamesFlux(int count) {
        return Flux.range(0, count)
                .map(integer -> getName());
    }

    private static List<String> getNamesList(int count) {
        List<String> names = new ArrayList<>();

        for (int index = 0; index < count; index++) {
            names.add(getName());
        }

        return names;
    }

    private static String getName() {
        Util.threadSleep(1);
        return Util.faker().name().firstName();
    }
}
