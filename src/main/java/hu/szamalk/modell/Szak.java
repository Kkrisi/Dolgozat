package hu.szamalk.modell;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.Collator;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.UUID;

public class Szak implements Serializable{
    public Tantargy[] targyak;
    private String nev;
    private UUID id;
    private static final String FAJL_NEV1 = "targyak.dat";
    private static final String FAJL_NEV2 = "erdemjegyek.dat";
    public List<Tantargy> tantargyak;
    private int kredit;

    public Szak(String nev) {
        this.nev = nev;
    }

    public Szak(String nev, List<Tantargy> tantargyak) {
        this.nev = nev;
        this.tantargyak = tantargyak;
        ujIdGeneralas();
        try {
            szakBeolvasasa();
        } catch ( Exception e){
            System.out.println("Hiba beolvasáskor.");
        }
    }

    public void ujIdGeneralas(){
        id = UUID.randomUUID();
    }

    public List<Tantargy> getTargyak() {
        return tantargyak;
    }

    public void setTargyak(ArrayList<Tantargy> tantargyak) {
        this.tantargyak = tantargyak;
    }

    public String getNev() {
        return nev;
    }

    public void setNev(String nev) {
        this.nev = nev;
    }



    public void szakKiirasa(){
        tantargyak = new ArrayList<>();
        tantargyak.add(targyak[1]);
        tantargyak.add(targyak[2]);
        tantargyak.add(targyak[3]);
        Szak sz1 = new Szak("informatika", tantargyak);
        Szak sz2 = new Szak("matematika", tantargyak);
        try(ObjectOutputStream objKi = new ObjectOutputStream(new FileOutputStream(FAJL_NEV2))){
            objKi.writeObject(sz1);
            objKi.writeObject(sz2);
            System.out.println("2 szak kiírva:");
            System.out.println(sz1);
            System.out.println(sz2);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void szakBeolvasasa(){
        try(ObjectInputStream objBe = new ObjectInputStream(new FileInputStream(FAJL_NEV2))){
            Szak sz;
            sz = (Szak) objBe.readObject();
            sz.ujIdGeneralas();
            System.out.println("Az 1. beolvasott szak:");
            System.out.println(sz);
            sz = (Szak) objBe.readObject();
            sz.ujIdGeneralas();
            System.out.println("A 2. beolvasott szak:");
            System.out.println(sz);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }


    public List<Tantargy> getTargyakNevSzerint(Szak masik){
        ArrayList<Tantargy> tantargyLista = null;
        Collator coll = Collator.getInstance();
        int compare = coll.compare(this.nev, masik.nev);
        tantargyLista.add(compare);
        return tantargyLista;
    }




    public List<Tantargy> getTargyakKreditekSzerint(Szak egyik, Szak masik) {
        return (List<Tantargy>) new KreditComparator();
    }

    private static class KreditComparator implements Comparator<Szak> {
        @Override
        public int compare(Szak egyik, Szak masik) {
            return egyik.kredit - masik.kredit;
        }
    }



    public void statisztika(){
        String fn = "statisztika.txt";
        String tartalom = "bla bla";
        try {
            Files.write(Path.of(fn), tartalom.getBytes());
        } catch (IOException e) {
            System.err.println("Hiba a fájl ÍRÁSA közben!" + e.getMessage());
        }
    }

    @Override
    public String toString() {
        return "Szak{" +
                "nev='" + nev + '\'' +
                ", id=" + id +
                ", tantargyak=" + tantargyak +
                '}';
    }
}
