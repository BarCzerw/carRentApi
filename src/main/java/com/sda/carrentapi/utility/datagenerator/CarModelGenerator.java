package com.sda.carrentapi.utility.datagenerator;

import java.util.Random;

public class CarModelGenerator {

    public static String generate() {
        Random random = new Random();
        StringBuilder sb = new StringBuilder();

        int lettersCount = random.nextInt(3) + 1;
        int numbersCount = random.nextInt(2) + 1;
        int zeroesCount = Math.max(4 - numbersCount, 2);

        sb.append(getRandomLettersString(lettersCount));
        sb.append(getRandomNumbersString(numbersCount));
        sb.append(getZeroesString(zeroesCount));

        return sb.toString();
    }

    private static String getRandomLettersString(int lettersCount) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < lettersCount; i++) {
            sb.append(getRandomSingleCharacter());
        }
        return sb.toString().toUpperCase();
    }

    private static Character getRandomSingleCharacter() {
        return (char) (new Random().nextInt('z' - 'a') + 'a');
    }

    private static String getRandomNumbersString(int numbersCount) {
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numbersCount; i++) {
            sb.append(random.nextInt(9) + 1);
        }
        return sb.toString();
    }

    private static String getZeroesString(int zeroesCount) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < zeroesCount; i++) {
            sb.append("0");
        }
        return sb.toString();
    }

}
