package org.example;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class MontyHallSimulation {
    public static void main(String[] args) {
        int totalTests = 1000;
        Map<Integer, String> results = new HashMap<>();

        int wins = 0;
        int losses = 0;

        Random random = new Random();

        for (int i = 1; i <= totalTests; i++) {
            int prizeDoor = random.nextInt(3) + 1;
            int chosenDoor = random.nextInt(3) + 1;

            int revealedDoor;
            do {
                revealedDoor = random.nextInt(3) + 1;
            } while (revealedDoor == prizeDoor || revealedDoor == chosenDoor);

            int finalChoice = chosenDoor;

            // Раскомментируйте следующую строку, чтобы изменить окончательный выбор
            // if (random.nextBoolean()) {
            //     finalChoice = revealedDoor;
            // }

            if (finalChoice == prizeDoor) {
                wins++;
                results.put(i, "Победа");
            } else {
                losses++;
                results.put(i, "Поражение");
            }
        }

        System.out.println("Победы: " + wins);
        System.out.println("Поражения: " + losses);

        System.out.println("Результаты:");
        for (Map.Entry<Integer, String> entry : results.entrySet()) {
            System.out.println("Тест " + entry.getKey() + ": " + entry.getValue());
        }
    }
}