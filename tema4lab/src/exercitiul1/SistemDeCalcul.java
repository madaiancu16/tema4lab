package exercitiul1;

public class SistemDeCalcul extends Echipament {
    private String tip_mon;
    private double vit_proc;
    private int c_hdd;
    private Sistem sistem;

    public SistemDeCalcul(String denumire, int nr_inv, double pret, String zona_mag, Stare stare, String tip_mon, double vit_proc, int c_hdd, Sistem sistem) {
        super(denumire, nr_inv, pret, zona_mag, stare);
        this.tip_mon = tip_mon;
        this.vit_proc = vit_proc;
        this.c_hdd = c_hdd;
        this.sistem = sistem;
    }

    @Override
    public String toString() {
        return super.toString() + ", Tip: Sistem de Calcul, Monitor: " + tip_mon + ", Viteza Procesor: " + vit_proc + " GHz, HDD: " + c_hdd + " GB, Sistem: " + sistem;
    }

    public void setSistem(Sistem sistem) {
        this.sistem = sistem;
    }
}
