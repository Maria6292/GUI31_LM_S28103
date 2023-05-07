import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Koszyk {
    private Klient klient;
    private Map<Herbata, Integer> zawartosc;

    public Koszyk(Klient klient) {
        this.klient = klient;
        this.zawartosc = new HashMap<>();
    }

//    public void dodajHerbate(Herbata herbata) {
//        dodajHerbate(herbata, 1);
//    }

    public void dodajHerbate(Herbata herbata, int ilosc) {
        if (zawartosc.containsKey(herbata)) {
            int aktualnaIlosc = zawartosc.get(herbata);
            zawartosc.put(herbata, aktualnaIlosc + ilosc);
        } else {
            zawartosc.put(herbata, ilosc);
        }
    }

//    public void dodajHerbaty(List<Herbata> herbaty) {
//        for (Herbata herbata : herbaty) {
//            dodajHerbate(herbata);
//        }
//    }
//
//    public void usunHerbate(Herbata herbata) {
//        usunHerbate(herbata, 1);
//    }

    public void usunHerbate(Herbata herbata, int ilosc) {
        if (zawartosc.containsKey(herbata)) {
            int aktualnaIlosc = zawartosc.get(herbata);
            if (ilosc >= aktualnaIlosc) {
                zawartosc.remove(herbata);
            } else {
                zawartosc.put(herbata, aktualnaIlosc - ilosc);
            }
        }
    }

    public boolean czyHerbataMaCene(Herbata herbata) {
        return zawartosc.containsKey(herbata) && herbata.getCena() > 0;
    }

    public Map<Herbata, Integer> pobierzZawartosc() {
        return zawartosc;
    }

//    public double obliczWartosc() {
//        double suma = 0.0;
//        for (Map.Entry<Herbata, Integer> entry : zawartosc.entrySet()) {
//            Herbata herbata = entry.getKey();
//            int ilosc = entry.getValue();
//            suma += herbata.getCena() * ilosc;
//        }
//        return suma;
//    }

}