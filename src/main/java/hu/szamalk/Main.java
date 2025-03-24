package hu.szamalk;

import hu.szamalk.modell.Szak;
import hu.szamalk.modell.Tantargy;

import java.util.ArrayList;
import java.util.List;


public class Main {
    static List<Szak> szakok;


    public static void main(String[] args) {

        List<Tantargy> tantargyak = List.of();
        tantargyak.add(tantargyak.get(1));
        tantargyak.add(tantargyak.get(2));
        Szak szak1 = new Szak("Informatika", tantargyak);

        szakok = new ArrayList<>();
        szakok.add(szak1);
    }
}