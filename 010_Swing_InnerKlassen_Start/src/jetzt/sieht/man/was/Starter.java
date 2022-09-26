package jetzt.sieht.man.was;

/**
 * Startet die Anwendung: Das Fenster wird erzeugt (new)
 * Das Fenster wird sichtbar gemacht: setVisible(true)
 * setVisible(true) startet eine GUI-Thread
 * 
 * @author Alfa
 *
 */
public class Starter {

	public static void main(String[] args) {
		ErstesFenster meinGui = new ErstesFenster();
		meinGui.setVisible(true);
//		while(true) {
//			System.out.println("---normalerweise wäre jetzt Schluss...");
//		}
	}
	
}
