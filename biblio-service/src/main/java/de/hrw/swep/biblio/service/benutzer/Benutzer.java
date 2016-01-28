package de.hrw.swep.biblio.service.benutzer;

import java.util.ArrayList;
import java.util.List;

import de.hrw.swep.biblio.service.Gebuehr;

/**
 * Klasse zur Repraesentation eines Bibliotheks-Nutzers
 * @author M. Friedrich
 *
 */
public class Benutzer {
	
	private Benutzerstatus status;
	private long id;
	private String name;
	private List<Gebuehr> gebuehren;

	/**
	 * Konstruktor: erzeugt ein Benutzer-Objekt
	 * @param id Benutzer-ID
	 * @param name Name des Benutzers
	 */
	public Benutzer(long id, String name) {
		super();
		this.id = id;
		this.name = name;
		this.gebuehren= new ArrayList<Gebuehr>();
		this.status = new Normal(this);
	}
	
	
	/**
	 * Mahnt einen Benutzer und vergibt eine Mahngebuehr
	 * @param geb die Mahngebuehr
	 */
	public void mahnen(Gebuehr geb) {
		status.mahnen(geb);
	}
	/**
	 * Schaltet einen gesperrten Benutzer wieder frei.
	 */
	public void freischalten() {
		status.freischalten();
	}
	
	/**
	 * Liefert die Benutzer-ID zurueck.
	 * @return die Benutzer-ID
	 */
	public long getId() {
		return id;
	}
	/**
	 * Setzt die Benutzer-ID
	 * @param id die Benutzer-ID
	 */
	public void setId(long id) {
		this.id = id;
	}
	/**
	 * Liefert den Namen des Benutzers zurueck.
	 * @return der Name des Benutzers
	 */
	public String getName() {
		return name;
	}
	/**
	 * Setzt den Namen des Benutzers
	 * @param name der Name des Benutzers
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * Liefert alle ausstehenden Mahngebuehren zurueck.
	 * @return Liste mit Mahngebuehren
	 */
	public List<Gebuehr> getGebuehren() {
		return gebuehren;
	}
	/**
	 * Setzt alle ausstehenden Mahngebuehren des Benutzers.
	 * @param gebuehren Liste mit Mahngebuehren
	 */
	public void setGebuehren(List<Gebuehr> gebuehren) {
		this.gebuehren = gebuehren;
	}
	/**
	 * Liefert den Status des Benutzers zurueck.
	 * @return der Status
	 */
	public Benutzerstatus getStatus() {
		return status;
	}
	/**
	 * Setzt den Status des Benutzers.
	 * @param status der Status
	 */
	public void setStatus(Benutzerstatus status) {
		this.status = status;
	}

	/**
	 * Gibt an, ob der Benutzer im Status "Normal" ist
	 * @return true, wenn der Benutzer im Status "Normal" ist, ansonsten false
	 */
	public boolean isNormal() {
		return status instanceof Normal;
	}
	/**
	 * Gibt an, ob der Benutzer im Status "Gesperrt" ist
	 * @return true, wenn der Benutzer im Status "Gesperrt" ist, ansonsten false
	 */
	public boolean isGesperrt() {
		return status instanceof Gesperrt;
	}


	/**
	 * Liefert eine Beschreibung des Benutzers
	 * @return Beschreibung des Benutzers
	 */
	@Override
	public String toString() {
		return "Benutzer [status=" + status + ", id=" + id + ", name=" + name
				+ ", gebuehren=" + gebuehren + "]";
	}
	
	
}
