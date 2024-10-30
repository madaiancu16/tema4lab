package exercitiul1;

public class Imprimanta extends Echipament {
    private int ppm;
    private String rezolutie;
    private int p_car;
    private Mod mod;

    public Imprimanta(String denumire, int nr_inv, double pret, String zona_mag, Stare stare, int ppm, String rezolutie, int p_car, Mod mod) {
        super(denumire, nr_inv, pret, zona_mag, stare);
        this.ppm = ppm;
        this.rezolutie = rezolutie;
        this.p_car = p_car;
        this.mod = mod;
    }

    @Override
    public String toString() {
        return super.toString() + ", Tip: Imprimanta, PPM: " + ppm + ", Rezolutie: " + rezolutie + ", Pagini/Cartus: " + p_car + ", Mod: " + mod;
    }

    public void setMod(Mod mod) {
        this.mod = mod;
    }
}

