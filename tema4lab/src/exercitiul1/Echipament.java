package exercitiul1;

import java.io.Serializable;

public abstract class Echipament implements Serializable {
    private String denumire;
    private int nr_inv;
    private double pret;
    private String zona_mag;
    private Stare stare;

    public Echipament(String denumire, int nr_inv, double pret, String zona_mag, Stare stare) {
        this.denumire = denumire;
        this.nr_inv = nr_inv;
        this.pret = pret;
        this.zona_mag = zona_mag;
        this.stare = stare;
    }

    public String getDenumire() {
        return denumire;
    }

    public Stare getStare() {
        return stare;
    }

    public void setStare(Stare stare) {
        this.stare = stare;
    }

    @Override
    public String toString() {
        return "Denumire: " + denumire + ", Nr Inv: " + nr_inv + ", Pret: " + pret + ", Zona Mag: " + zona_mag + ", Stare: " + stare;
    }
}
