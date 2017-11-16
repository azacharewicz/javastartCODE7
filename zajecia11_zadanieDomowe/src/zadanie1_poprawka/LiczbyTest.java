package zadanie1_poprawka;

import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.Random;
import java.util.TreeSet;

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

    //Stwórz	zbiór	i	umieść	w	nim	50	losowych	liczb	z	przedziału	0-1000
    public static void stworzZbiorLiczb(TreeSet<Integer> liczby) {
        Random random = new Random();
        int liczbaLosowa = 0;
        int i = 0;
        int j = 0;
        int k = 0;
        for (i = 0; i < 500; i++) {
            do {
                liczbaLosowa = random.nextInt(1001); //Losowanie liczby od 0 do 1000.
                j = j+1;
                //System.out.println(liczbaLosowa + " j=" + j + " liczba wylosowana w pętli");
            } while (liczby.contains(liczbaLosowa));
            liczby.add(liczbaLosowa);
            k = k + 1;
            //System.out.println(liczbaLosowa + " k=" + k + " liczba unikalna");
        }
        System.out.println("\nUtworzono zbiór " + i + " unikalnych liczb spośród " + j + " losowanych liczb.");
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







