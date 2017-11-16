package zadanie1_poprawka_v2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Game1 {

    private static final int MIN = 0;
    private static final int MAX = 1000;
    private static final int NUMBERS_COUNT = 50;

    public static void main(String[] args) {

        List<Integer> numbers = generateNumbers();

        showTheGreatestNumber(numbers);
        showTheLowestNumber(numbers);
        showTheAverage(numbers);
        showAllNumbersGreaterThanAverage(numbers);
    }

    private static List<Integer> generateNumbers() {
        List<Integer> numbers = new ArrayList<>();

        for (int i = 0; i < NUMBERS_COUNT; i++) {
            numbers.add(generateRandomNumber());
        }

        return numbers;
    }

    private static Integer generateRandomNumber() {
        Random random = new Random();
        return random.nextInt((MAX - MIN) + 1) + MIN;
    }

    private static void showTheGreatestNumber(List<Integer> numbers) {
        System.out.println(Collections.max(numbers));
    }

    private static void showTheLowestNumber(List<Integer> numbers) {
        System.out.println(Collections.min(numbers));
    }

    private static Double countAverage(List<Integer> numbers) {
        Double sum = 0.0;
        for (Integer number : numbers) {
            sum = sum + number;
        }

        return sum / NUMBERS_COUNT;
    }

    private static void showTheAverage(List<Integer> numbers) {
        System.out.println(countAverage(numbers));
    }

    private static void showAllNumbersGreaterThanAverage(List<Integer> numbers) {
        Double average = countAverage(numbers);
        for (Integer number : numbers) {
            if (number > average) {
                System.out.println(number);
            }

        }
    }

}

