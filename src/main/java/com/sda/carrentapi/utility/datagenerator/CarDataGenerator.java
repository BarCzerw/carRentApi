package com.sda.carrentapi.utility.datagenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CarDataGenerator {

    private static final List<String> manufacturers = new ArrayList<>(List.of(
            "Abarth","Alfa Romeo","Aston Martin","Audi","Bentley","BMW","Bugatti","Cadillac","Chevrolet","Chrysler",
            "Citroën","Dacia","Daewoo","Daihatsu","Dodge","Donkervoort","DS","Ferrari","Fiat","Fisker",
            "Ford","Honda","Hummer","Hyundai","Infiniti","Iveco","Jaguar","Jeep","Kia","KTM","Lada",
            "Lamborghini","Lancia","Land Rover","Landwind","Lexus","Lotus","Maserati","Maybach","Mazda",
            "McLaren","Mercedes-Benz","MG","Mini","Mitsubishi","Morgan","Nissan","Opel","Peugeot",
            "Porsche","Renault","Rolls-Royce","Rover","Saab","Seat","Skoda","Smart","SsangYong","Subaru",
            "Suzuki","Tesla","Toyota","Volkswagen","Volvo"
    ));

    public static String getRandomManufacturer() {
        return manufacturers.get(new Random().nextInt(manufacturers.size()));
    }

    public static String getRandomModel() {
        // TODO: 12.06.2021
        Random random = new Random();
        StringBuilder sb = new StringBuilder();

        int lettersCount = random.nextInt(3) + 1;
        int numbersCount = random.nextInt(2) + 1;
        int zerosCount = Math.max(4 - numbersCount, 2);

        getRandomLetterString(lettersCount);

        return "MODEL";
    }

    private static String getRandomLetterString(int lettersCount) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < lettersCount; i++) {
            sb.append(getRandomSingleCharacter());
        }
        return sb.toString().toUpperCase();
    }

    private static Character getRandomSingleCharacter() {
        return (char) (new Random().nextInt('z' - 'a') + 'a');
    }

}
