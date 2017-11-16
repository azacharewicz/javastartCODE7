package zadanie1;

import java.io.*;
import java.util.*;

public class LiczbyTest {

    public static void main(String[] args) throws FileNotFoundException {

        TreeSet<Integer> liczby = new TreeSet<>();

        stworzZbiorLiczb(liczby);
        wyswietlMin(liczby);
        wyswietlMax(liczby);
        double srednia = policzSrednia(liczby);
        wyswietlSrednia(srednia);
        wyswietlWiekszeOdSredniej(liczby, srednia);
    }

    public static void stworzZbiorLiczb(TreeSet<Integer> liczby) {
        for (int i = 0; i < 50; i++) {
            //Losowanie liczby od 0 do 1000.
            Random random = new Random();
            int liczbaLosowa = random.nextInt(1001);
            liczby.add(liczbaLosowa);
            //System.out.println(liczbaLosowa);
        }
    }

    public static void wyswietlMin(TreeSet<Integer> liczby) {
        System.out.println("Najmniejsza wartość: " + liczby.first());
    }

    public static void wyswietlMax(TreeSet<Integer> liczby) {
        System.out.println("Największa wartość: " + liczby.last());
    }

    public static void wyswietlSrednia(double srednia) {
        System.out.println("Średnia ze wszystkich liczb: " + srednia);
    }

    public static double policzSrednia(TreeSet<Integer> liczby) {
        int suma = 0;
        Iterator<Integer> iterator = liczby.iterator();
        while (iterator.hasNext()) {
            Integer liczba = iterator.next();
            suma = suma + liczba;

        }
        double srednia = (double) suma / liczby.size();
        return srednia;
    }

    public static void wyswietlWiekszeOdSredniej(TreeSet<Integer> liczby, double srednia) {
        System.out.println("Wszystkie liczby większe od średniej: ");
        Iterator<Integer> iterator = liczby.iterator();
        while (iterator.hasNext()) {
            Integer liczba = iterator.next();
            if (liczba > srednia) {
                System.out.println(liczba);
                //System.out.println(liczba); //lub krócej //System.out.println(iterator.next());
            }
        }
    }
}







