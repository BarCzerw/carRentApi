package com.sda.carrentapi.utility.datagenerator;

import java.util.Random;

public class CarProductionYearGenerator {

    public static int generate() {
        return new Random().nextInt(51) + 1970;
    }

}
