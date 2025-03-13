package v2;

public class WetterDaten extends Subject<WetterDaten.WetterDatenPayload> {
    private double temperatur;
    private double feuchtigkeit;
    private double luftdruck;

    public WetterDaten(double t, double f, double l) {
        this.setTemperatur(t);
        this.setFeuchtigkeit(f);
        this.setLuftdruck(l);
    }

    public void setTemperatur(double temperatur) {
        if (temperatur >= -90 && temperatur <= 60) {
            this.temperatur = temperatur;
            notifyObservers(new WetterDatenPayload(temperatur, feuchtigkeit, luftdruck));
        }
    }

    public void setFeuchtigkeit(double feuchtigkeit) {
        if (feuchtigkeit >= 0 && feuchtigkeit <= 100) {
            this.feuchtigkeit = feuchtigkeit;
            notifyObservers(new WetterDatenPayload(temperatur, feuchtigkeit, luftdruck));
        }
    }

    public void setLuftdruck(double luftdruck) {
        if (luftdruck >= 100 && luftdruck <= 1050) {
            this.luftdruck = luftdruck;
            notifyObservers(new WetterDatenPayload(temperatur, feuchtigkeit, luftdruck));
        }
    }

    public double getFeuchtigkeit() {
        return feuchtigkeit;
    }

    public double getTemperatur() {
        return temperatur;
    }

    public double getLuftdruck() {
        return luftdruck;
    }

    public static class WetterDatenPayload {
        private final double temperatur;
        private final double feuchtigkeit;
        private final double luftdruck;

        public WetterDatenPayload(double temperatur, double feuchtigkeit, double luftdruck) {
            this.temperatur = temperatur;
            this.feuchtigkeit = feuchtigkeit;
            this.luftdruck = luftdruck;
        }

        public double getTemperatur() {
            return temperatur;
        }

        public double getFeuchtigkeit() {
            return feuchtigkeit;
        }

        public double getLuftdruck() {
            return luftdruck;
        }
    }
}