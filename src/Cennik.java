import java.util.HashMap;

public class Cennik {

    private static Cennik instancja = new Cennik();
    private HashMap<String, HashMap<String, double[]>> ceny;

    private Cennik() {
        ceny = new HashMap<String, HashMap<String, double[]>>();
    }

    public static Cennik pobierzCennik() {
        return instancja;
    }

    public void dodaj(String rodzaj, String smak, double cena) {
        if (!ceny.containsKey(rodzaj)) {
            ceny.put(rodzaj, new HashMap<String, double[]>());
        }
        ceny.get(rodzaj).put(smak, new double[] { cena, -1 });
    }

    public void dodaj(String rodzaj, String smak, double cenaNormalna, double cenaPromocyjna, int iloscPromocji) {
        if (!ceny.containsKey(rodzaj)) {
            ceny.put(rodzaj, new HashMap<String, double[]>());
        }
        ceny.get(rodzaj).put(smak, new double[] { cenaNormalna, cenaPromocyjna, iloscPromocji });
    }

    public double cena(String rodzaj, String smak, double ilosc) throws Exception {
        if (!ceny.containsKey(rodzaj) || !ceny.get(rodzaj).containsKey(smak)) {
            throw new Exception("Brak ceny dla herbaty " + rodzaj + " o smaku " + smak);
        }
        double[] c = ceny.get(rodzaj).get(smak);
        if (c.length == 2) {
            return ilosc * c[0];
        } else {
            double cenaNormalna = c[0];
            double cenaPromocyjna = c[1];
            int iloscPromocji = (int) c[2];
            if (ilosc < iloscPromocji) {
                return ilosc * cenaNormalna;
            } else {
                double iloscNormalna = ilosc - iloscPromocji;
                return iloscNormalna * cenaNormalna + iloscPromocji * cenaPromocyjna;
            }
        }
    }

}