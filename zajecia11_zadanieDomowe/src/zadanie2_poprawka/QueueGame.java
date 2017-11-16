package zadanie2_poprawka;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class QueueGame {

    private static final int NUMBERS_COUNT = 10;

    public static void main(String[] args) {
        Queue<Integer> numbers = downloadNumbersFromUser();
        showTheSum(numbers);
    }

    private static Queue<Integer> downloadNumbersFromUser() {
        Queue<Integer> numbers = new LinkedList<>();
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < NUMBERS_COUNT; i++) {
            System.out.println("Podaj liczbę całkowitą ");
            int number = scanner.nextInt();
            scanner.nextLine(); //zawsze pozbywamy się "\n" przed wpisaniem stringa w następnej linii
            numbers.offer(number);
        }
        scanner.close();
        System.out.println("Pobrano liczby: " + numbers);
        return numbers;
    }

    //wyświetl na ekranie wynik	dodawania w	postaci: a+b+c+…+j = suma
    private static void showTheSum(Queue<Integer> numbers) {
        int sum = 0;
        System.out.print("\nSUMA ELEMENTÓW W KOLEJCE: ");
        for (int i = 0; i < NUMBERS_COUNT; i++) {
            sum = sum + numbers.peek();
            if (i < (NUMBERS_COUNT - 1)) {
                System.out.print(numbers.peek() + "+");
            } else {
                System.out.println(numbers.peek() + "=" + sum);
            }
            numbers.poll();
        }
    }
}

//  peek() – pobiera pierwszy element i pozostawia	go w kolejce
//  poll() – pobiera pierwszy element i usuwa go z kolejki
