package de.hrw.swep.biblio.service.gegenstaende;

import de.hrw.swep.biblio.service.benutzer.Benutzer;
/**
 * Status eines Ausleihmediums
 * @author M. Friedrich
 *
 */
public interface Ausleihstatus {

	/**
	 * Medium wird ausgeliehen
	 * @param user Nutzer, der ausleihen moechte
	 */
	void ausleihen(Benutzer user);
	/**
	 * Medium wird zurueckgegeben
	 */
	void zurueckgeben();
	/**
	 * Medium wird als verloren gemeldet
	 */
	void verloren();
	
}
