package zadanie1_poprawka;

import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.Random;
import java.util.TreeSet;

public class LiczbyTestJednaPetlaZamiastDwoch {

    public static void main(String[] args) throws FileNotFoundException {

        TreeSet<Integer> liczby = new TreeSet<>();

        stworzZbiorLiczb(liczby);
        wyswietlMin(liczby);
        wyswietlMax(liczby);
        double srednia = policzSrednia(liczby);
        wyswietlSrednia(srednia);
        wyswietlWiekszeOdSredniej(liczby, srednia);
    }

    //Stwórz	zbiór	i	umieść	w	nim	50	losowych	liczb	z	przedziału	0-1000
    public static void stworzZbiorLiczb(TreeSet<Integer> liczby) {
        Random random = new Random();
        int liczbaLosowa = 0;
        int liczbaUnikalnychLiczb = 0;
        int liczbaWszystkichLosowanychLiczb = 0;
            do {
                liczbaLosowa = random.nextInt(1001); //Losowanie liczby od 0 do 1000.
                if(!liczby.contains(liczbaLosowa)){liczbaUnikalnychLiczb++;}
                liczbaWszystkichLosowanychLiczb++;
                liczby.add(liczbaLosowa);
                //System.out.println(liczbaLosowa);
            } while (liczby.size() < 50);
        System.out.println("\nUtworzono zbiór " + liczbaUnikalnychLiczb + " unikalnych liczb z " + liczbaWszystkichLosowanychLiczb + " losowanych liczb.");
    }

    public static void wyswietlMin(TreeSet<Integer> liczby) {
        System.out.println("\nNajmniejsza wartość: " + liczby.first());
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
        System.out.println("\nWszystkie liczby większe od średniej: ");
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







