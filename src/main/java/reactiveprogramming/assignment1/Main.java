package reactiveprogramming.assignment1;

import reactiveprogramming.util.Util;

public class Main {

    public static void main(String[] args) {
        FileService fileService = new FileService();
        fileService.readFileContent()
                .subscribe(
                        Util.onNext(),
                        Util.onError(),
                        Util.onComplete()
                );

        fileService.writeFileContent()
                .subscribe(
                        Util.onNext(),
                        Util.onError(),
                        Util.onComplete()
                );

        fileService.deleteFileCreated()
                .subscribe(
                        Util.onNext(),
                        Util.onError(),
                        Util.onComplete()
                );
    }
}
