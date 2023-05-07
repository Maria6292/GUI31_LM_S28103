public abstract class Herbata {
    private String nazwa;
    private String smak;
    private double ilosc;
    private double cenaPromocyjna;
    private int minimalnaIlosc;
    private boolean promocjaAktywna;

    public Herbata(String nazwa, String smak, double ilosc) {
        this.nazwa = nazwa;
        this.smak = smak;
        this.ilosc = ilosc;
//        this.cenaPromocyjna = cena;
//        this.minimalnaIlosc = 0;
//        this.promocjaAktywna = false;
    }
//    public Herbata(String nazwa, String smak, double cena, double cenaPromocyjna, int minimalnaIlosc) {
//        this.nazwa = nazwa;
//        this.smak = smak;
//        this.cena = cena;
//        this.cenaPromocyjna = cenaPromocyjna;
//        this.minimalnaIlosc = minimalnaIlosc;
//        this.promocjaAktywna = false;
//    }


    public String getNazwa() {
        return nazwa;
    }

    public String getSmak() {
        return smak;
    }

    public double getIlosc() {
        return ilosc;
    }

    public void aktywujPromocje(int ilosc) {
        if (ilosc >= minimalnaIlosc) {
            promocjaAktywna = true;
        } else {
            promocjaAktywna = false;
        }
    }

    @Override
    public String toString() {
        return String.format("%s %s %.2f zł/kg", nazwa, smak, ilosc);
    }
}






