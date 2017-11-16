package zadanie2;

import java.util.*;
import java.util.LinkedList;

public class Kolejka {
    public static void main(String[] args) {
        Random random = new Random();
        int suma = 0;
        System.out.println();
        Queue<Integer> liczby = new LinkedList<>();
        for (int i = 0; i < 3; i++) {
            int liczbaLosowa = random.nextInt(10);
            liczby.offer(liczbaLosowa);
            //suma = suma + liczbaLosowa;      //tak było źle
            suma = suma + liczby.poll();       //a tak będzie dobrze? teraz dodałam ta linijkę
            if (i < (10 - 1)) {
                System.out.print(liczbaLosowa + "+");
            } else {
                System.out.println(liczbaLosowa + "=" + suma);
            }
        }

//
//        while (pacjenci.peek() != null){
//            Person peek = pacjenci.peek();
//            System.out.println(peek.toString() + " proszony do gabinetu");
//            Person pool = pacjenci.poll();
//            System.out.println(pool.toString() + " obsłużony");
//
//        }
    }
}
