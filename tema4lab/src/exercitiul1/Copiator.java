package exercitiul1;

public class Copiator extends Echipament {
    private int ppm;
    private Format format;

    public Copiator(String denumire, int nr_inv, double pret, String zona_mag, Stare stare, int ppm, Format format) {
        super(denumire, nr_inv, pret, zona_mag, stare);
        this.ppm = ppm;
        this.format = format;
    }

    @Override
    public String toString() {
        return super.toString() + ", Tip: Copiator, PPM: " + ppm + ", Format: " + format;
    }

    public void setFormat(Format format) {
        this.format = format;
    }
}
