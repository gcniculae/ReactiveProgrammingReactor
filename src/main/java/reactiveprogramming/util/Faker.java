package reactiveprogramming.util;

import reactiveprogramming.util.Util;

public class Faker {

    public static void main(String[] args) {
        for (int index = 0; index < 10; index++) {
            System.out.println(Util.faker().name().fullName());
        }
    }
}
