package zadanie3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.TreeSet;
import java.util.*;

public class ZliczIloscWystapien {
    public static void main(String[] args) throws FileNotFoundException {
        TreeSet<Integer> set = new TreeSet<>();
        int licznik = 0;
        HashMap<Integer, Integer> iloscWystapien = new HashMap<>();

        System.out.println("\nODCZYTANO Z PLIKU: ");
        File file = new File("zadanie3.txt");
        Scanner scanner = null;
        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        while (scanner.hasNextInt()) {
            licznik = licznik + 1;
            Integer value = scanner.nextInt();
            set.add(value);
            System.out.println(value);
            int num = 0;
            if (iloscWystapien.containsKey(value))
                num = iloscWystapien.get(value);
            iloscWystapien.put(value, num + 1);
        }
        System.out.println();
        Set<Integer> klucze = iloscWystapien.keySet();
        Iterator<Integer> iterator = klucze.iterator();
        while (iterator.hasNext()) {
            Integer liczba = iterator.next();
            Integer ileRazy = iloscWystapien.get(liczba);
            System.out.println(liczba + " - liczba wystapien: " + ileRazy);
        }
    }
}
