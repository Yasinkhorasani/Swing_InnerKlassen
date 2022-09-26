package jetzt.sieht.man.was;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalTime;

import javax.swing.JLabel;

/**
 * Klickhandler "kümmert sich" um um den KlickMich Button:
 * Reagiert, wenn der KlickMich Button geklickt wird:
 * implementiert das ActionListener Interface
 * wird bei klickMich-Button regristiert
 * 
 * Referenztypen für KlickHandler: Object, KlickHandler, ActionListener
 * 
 * @author Alfa
 *
 */
public class KlickHandler implements ActionListener{
	
	private JLabel anzeige;
	
	public KlickHandler(JLabel anzeige) {
		this.anzeige = anzeige;
	}

	/**
	 * Das was hier beschrieben ist, wird vom Button in Auftrag gegeben, wenn er geklickt wird
	 */
	@Override
	public void actionPerformed(ActionEvent event) {
		LocalTime jetzt = LocalTime.now();
		String aktuell ="Jetzt ist es gerade " + jetzt.getHour() + ":" + jetzt.getMinute() +":" + jetzt.getSecond();
		System.out.println(aktuell);
		//Wunsch:
		anzeige.setText(aktuell); 
	}

}
