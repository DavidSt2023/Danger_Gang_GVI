package WeatherStation;

import java.util.Random;
import java.util.UUID;
public class Main_WetterstationTestlaufPUSH {
	static Random zM = new Random();

	public static void main(String[] args) {
		UUID uuid = UUID.randomUUID();
		System.out.println("--------------WETTERSTATION PUSH--------------");
		WetterDaten wetterDatenGUI = new WetterDaten(26, 50, 1000);

		AktuelleBedingungen aktuell = new AktuelleBedingungen();
		WetterVorhersage vorhersage = new WetterVorhersage();

		wetterDatenGUI.addObserver(aktuell);
		wetterDatenGUI.addObserver(vorhersage);
		
		//TESTLAUF
		try {
			//Simulation von 50 Änderungen der Wetterdaten
			
			for (int i = 0; i < 50; i++) {
				int welcher = zM.nextInt(3);
				double wert = 0;
				switch (welcher) {
				case 0:
					wetterDatenGUI.setTemperatur(wetterDatenGUI.getTemperatur() + zM.nextInt(8) - 4);
					break;
				case 1:
					wert = wetterDatenGUI.getFeuchtigkeit() + zM.nextInt(40) - 20;
					if (wert >= 0)
						wetterDatenGUI.setFeuchtigkeit(wert);
					break;
				case 2:
					wert = wetterDatenGUI.getLuftdruck() + zM.nextInt(30) - 15;
					if (wert >= 650)
						wetterDatenGUI.setLuftdruck(wert);
					break;
				}
				Thread.sleep(1000);
			}
					
			//Observer wird entfernt
			wetterDatenGUI.removeObserver(aktuell);
			Thread.sleep(500);
			wetterDatenGUI.setLuftdruck(900);
			wetterDatenGUI.setTemperatur(36);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
