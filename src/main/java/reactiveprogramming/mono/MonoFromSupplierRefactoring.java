package reactiveprogramming.mono;

import reactiveprogramming.util.Util;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

public class MonoFromSupplierRefactoring {

    public static void main(String[] args) {
        getName();
        getName();
        getName().subscribeOn(Schedulers.boundedElastic()).subscribe(Util.onNext());
        // blocking the thread, generally used for testing
        // getName().subscribeOn(Schedulers.boundedElastic()).block();
        getName();
    }

    private static Mono<String> getName() {
        System.out.println("Inside getName() method.");
        return Mono.fromSupplier(() -> {
                    // building the pipeline
                    System.out.println("Generating name...");
                    Util.threadSleep(3);
                    return Util.faker()
                            .name()
                            .firstName();
                    //-------------------
                })
                .map(String::toUpperCase);
    }
}
