package v1;

import java.util.Observable;

public class WetterDaten extends Observable {

	private double temperatur;
	private double feuchtigkeit;
	private double luftdruck;
	
	public WetterDaten(double t, double f, double l) {
		this.setTemperatur(t);
		this.setFeuchtigkeit(f);
		this.setLuftdruck(l);
	}

	public void setTemperatur(double temperatur) {
		if( temperatur >=-90 && temperatur <=60) {
			this.temperatur = temperatur;
			setChanged();
			notifyObservers();
		}
	}
	// in Prozentpunkten 0-100
	public void setFeuchtigkeit(double feuchtigkeit) { 
		if(feuchtigkeit>=0 && feuchtigkeit<=100) {
			this.feuchtigkeit = feuchtigkeit;
			setChanged();
			notifyObservers();
		}
	}

	public void setLuftdruck(double luftdruck) {
		if( luftdruck >= 100 && luftdruck <=1050) {
			this.luftdruck = luftdruck;
			setChanged();
			notifyObservers();
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
}
