package de.hrw.swep.biblio.service.gegenstaende;

import de.hrw.swep.biblio.service.benutzer.Benutzer;

/**
 * Ein Ausleihmedium
 * @author M. Friedrich
 *
 */
public abstract class Gegenstand {
	protected Ausleihstatus state;
	
	/**
	 * Liefert den Zustand des Mediums
	 * @return der Zustand
	 */
	public Ausleihstatus getState() {
		return state;
	}

	/**
	 * Setzt den Zustand des Mediums
	 * @param state der Zustand
	 */
	public void setState(Ausleihstatus state) {
		this.state = state;
	}

	/**
	 * Das Medium wird zurueckgegeben
	 */
	public void zurueckgeben() {
		state.zurueckgeben();
	}

	/**
	 * Das Medium wird als verloren gemeldet
	 */
	public void verloren() {
		state.verloren();
	}

	/**
	 * Das Medium wird ausgeliehen
	 * @param user der Benutzer, der das Medium ausleiht
	 */
	public void ausleihen(Benutzer user) {
		state.ausleihen(user);
	}
	
	
	/**
	 * Liefert eine textuelle Beschreibung des Zustands zurueck.
	 * @return die Beschreibung
	 */
	public abstract String toString();
}
