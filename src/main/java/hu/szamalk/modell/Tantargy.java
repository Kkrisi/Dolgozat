package hu.szamalk.modell;

import java.util.ArrayList;

public class Tantargy {
    private String nev;
    private int kredit;
    private ArrayList<String> tanarok;
    private int felev;
    private boolean vizsga;

    public Tantargy(String nev, int kredit, String tanar, int felev, boolean vizsga) {
        this(nev, kredit, new ArrayList<>(), felev, vizsga);
        tanarok.add(tanar);
    }

    public Tantargy(String nev, int kredit, ArrayList<String> tanarok, int felev, boolean vizsga) {
        this.nev = nev;
        this.kredit = kredit;
        this.tanarok = tanarok;
        this.felev = felev;
        this.vizsga = vizsga;
    }

    public Tantargy() {
        this.nev = "";
    }

    public String getNev() {
        return nev;
    }

    public void setNev(String nev) {
        this.nev = nev;
    }

    public int getKredit() {
        return kredit;
    }

    public void setKredit(int kredit) {
        this.kredit = kredit;
    }

    public ArrayList<String> getTanarok() {
        return tanarok;
    }

    public void setTanarok(ArrayList<String> tanarok) {
        this.tanarok = tanarok;
    }

    public int getFelev() {
        return felev;
    }

    public void setFelev(int felev) {
        this.felev = felev;
    }

    public boolean isVizsga() {
        return vizsga;
    }

    public void setVizsga(boolean vizsga) {
        this.vizsga = vizsga;
    }


    @Override
    public String toString() {
        return "Tantargy{" +
                "nev='" + nev + '\'' +
                ", kredit=" + kredit +
                ", tanarok=" + tanarok +
                ", felev=" + felev +
                ", vizsga=" + vizsga +
                '}';
    }
}
