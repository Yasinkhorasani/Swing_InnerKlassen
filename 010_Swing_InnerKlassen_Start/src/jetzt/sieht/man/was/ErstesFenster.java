package jetzt.sieht.man.was;


import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalTime;

import javax.swing.*;

/**
 * Ein Fenster wird erstellt: Erstes Fenster IST EIN JFrame
 * 
 * JFrame: Klasse, deren Objekte die Standard-Fenster in Java darstellt
 * 
 * JFrame: Top-Level-Container: Kann ohne andere graphische Komponenten angezeigt werden
 * 
 * Meist: JFrame Attribut der eigenen Klasse, hier: extends JFrame
 * 
 * import javax.swing.*; : Import fuer alle Klasse aus dem Package javax.swing
 * 
 * Objekte, die TCP/IP Verbindung versendet werden sollen, müssen "serializable" sein
 * Sezializable ist ein Interface, JFrame implementiert dieses Interface
 * -> ErstesFenster ist auch serializable (über extends)
 * Hier: Warning....Lösung @SuppressWarnings("serial")
 * 
 * @author Yasin
 *
 */
@SuppressWarnings("serial")
public class ErstesFenster extends JFrame{
	
	/**
	 * Innere Klassen haben Zugriff auf (private) Member(Attribute und Methoden) der äußeren Klasse
	 * Hier ein ActionListener, der direkt auf die Uhrzeit-Anzeige zugreifen kann
	 * @author Yasin
	 *
	 */
	public class InnerKlickHandler implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			LocalTime jetzt = LocalTime.now();
			uhrzeitAnzeige.setText(jetzt.toString());
		}
		
	}

// ***************************************
// *** Attribute
//****************************************
	
	/**
	 * Dieser Button demonstiert EVENT-HANDLING
	 * Hier: Event: der Benutzer klickt auf den Button
	 * Der Button erstellt eine Ereignis-Objekt: Objekt vom Typ ActionEvent
	 * Der Button hat intern ein Array von Objekten(-referenzen) die informiert werden müssen, wenn
	 * 		das ActionEvent erstellt wurde:
	 * Alle Element in dem Array haben eine Methode: actionPerformed(ActionEvent event)
	 * Button ruft, wenn er geklickt wird, die actionPerformed-Methode auf und übergibt das ActionEvent-Objekt
	 * Elemente sind Handler für dieses Event.
	 * Elemente warten auf das Event und heissen deshalb: LISTENER, Weil sie auf das ActionEvent warten
	 * sind es ActionListener. 
	 * ActionListener ist ein Interface
	 * 
	 * Elemente werden über die Methode: addActionListener in das Array aufgenommen
	 * "Element registriert sich beim Button"
	 */
	private JButton klickMich = new JButton("Klick mich");
	
	/**
	 * Ziel: Zeigt die Uhrzeit an, zu der der Button klickMich geklickt worden ist
	 */
	private JLabel uhrzeitAnzeige = new JLabel("Platzhalter");
	
	/**
	 * Beendet die Anwendung: System.exit(0);
	 * ÜBUNG
	 */
	private JButton beenden = new JButton("Schluss");
	
	/** zum Ausprobieren...*/
	private JLabel chemiker = new JLabel("Platz für Experimente");

	/**
	 * Damit keine lokale Variable zum Zählen der Klicks gebraucht wird
	 */
	private int klickZaehler = 0;
// ***************************************
// *** Konstruktoren
// ***************************************
	public ErstesFenster() {
		super("Erstes Fenster");
		//Setzt den Titel des Fenster im Konstruktor der Elternklasse
		setSize(350,300);
	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//Beendet die Anwendung: System.exit(0); Beendet die JVM
		
		setLocationRelativeTo(null);
		//Fenster wird anfangs in der Mitte des Monitors angezeigt
		
		//Verwendung einen anonymen Objekts: Objekte ohne Referenz
		setLayout(new FlowLayout());
		//Ogranisiert die Position, Größe und Anordnung von enthaltenen Buttons, Labels, Textfeldern....
		
		add(klickMich);
		add(uhrzeitAnzeige);
		add(beenden);
		add(chemiker);
		
//		verwendenKlickHandler();
//		verwendenInnerKlickHandler();
		verwendenLocalKlickHandler();
	}

	private void verwendenLocalKlickHandler() {
		/**
		 * Lokale innere Klassen haben Zugriff auf Attribute/Methoden der äußeren Klasse
		 * Und Zugriff auf lokale Variablen, wenn diese final oder effektiv final sind
		 * effektiv final: sie werden nach der ersten Zuweisung nicht geändert
		 * @author Alfa
		 *
		 */
	
		class LocalKlickHandler implements ActionListener{

			@Override
			public void actionPerformed(ActionEvent e) {
				setTitle("Geklickt  " + klickZaehler);
				klickZaehler++;
			}			
		}
//		 Version 1
//		LocalKlickHandler meinHandler = new LocalKlickHandler();
//		klickMich.addActionListener(meinHandler);
		
//		Version 2
//		ActionListener meinHandler = new LocalKlickHandler();
//		klickMich.addActionListener(meinHandler);
	
		//Version 3: Anonymes Objekt
		klickMich.addActionListener(new LocalKlickHandler());
	}

	private void verwendenInnerKlickHandler() {
//		Version 1
//		InnerKlickHandler meinHandler = new InnerKlickHandler();
//		klickMich.addActionListener(meinHandler); 
		
//		Version 2
//		ActionListener meinHandler = new InnerKlickHandler();
//		klickMich.addActionListener(meinHandler);
		
		klickMich.addActionListener(new InnerKlickHandler());
	}

	/**
	 * Methode zu Modularisierung des Konstruktors
	 */
	private void verwendenKlickHandler() {
//		Version 1
//		KlickHandler meinHandler = new KlickHandler(uhrzeitAnzeige);
//		klickMich.addActionListener(meinHandler); 
		
//		Version 2
//		ActionListener meinHandler = new KlickHandler(uhrzeitAnzeige);
//		klickMich.addActionListener(meinHandler);
		
		//Version 3: Anonymes Objekt: Hier keine Referenz auf das Objekt
		klickMich.addActionListener(new KlickHandler(uhrzeitAnzeige));
	}
	
}
 

 


 





