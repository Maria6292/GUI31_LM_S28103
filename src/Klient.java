import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Klient {
    private String identyfikator;
    private double portfel;
    private List<Herbata> listaZakupow;

    public Klient(String identyfikator, double portfel) {
        this.identyfikator = identyfikator;
        this.portfel = portfel;
        this.listaZakupow = new ArrayList<>();
    }

    public void dodaj(Herbata herbata) {
        listaZakupow.add(herbata);
    }

    public List<Herbata> pobierzListeZakupow() {
        return listaZakupow;
    }

    public double pobierzPortfel() {
        return portfel;
    }

    public void przepakuj(Koszyk koszyk) {
        Iterator<Herbata> iterator = listaZakupow.iterator();
        while (iterator.hasNext()) {
            Herbata herbata = iterator.next();
            if (!koszyk.czyHerbataMaCene(herbata)) {
                iterator.remove();
            }
        }
        koszyk.dodajHerbaty(listaZakupow);
        listaZakupow.clear();
    }

    public void zaplac(String metodaPlatnosci) {
        double wartoscKoszyka = 0.0;
        for (Herbata herbata : listaZakupow) {
            wartoscKoszyka += herbata.getCena();
        }

        if (metodaPlatnosci.equals("karta")) {
            wartoscKoszyka *= 1.01; // prowizja 1%
        }

        if (wartoscKoszyka <= portfel) {
            portfel -= wartoscKoszyka;
            listaZakupow.clear();
        } else {
            Iterator<Herbata> iterator = listaZakupow.iterator();
            while (iterator.hasNext()) {
                Herbata herbata = iterator.next();
                double cenaHerbaty = herbata.getCena();
                if (cenaHerbaty * 0.5 <= portfel) {
                    double iloscDoZaplaty = Math.floor(portfel / (cenaHerbaty * 0.5)) * 0.5;
                    herbata.setIlosc(herbata.getIlosc() - iloscDoZaplaty);
                    portfel -= iloscDoZaplaty * cenaHerbaty * 0.5;
                } else {
                    iterator.remove();
                }
            }
        }
    }

    public Koszyk pobierzKoszyk() {
        return new Koszyk(listaZakupow);
    }
}