package ge.tbc.tbcitacademy.POM.Util;

import java.util.Random;

public class Util {
    public static int generateMinimum() {
        Random random = new Random();
        return random.nextInt(151) + 50;
    }

    public static int generateMaximum() {
        Random random = new Random();
        return random.nextInt(201) + 300;
    }
}
