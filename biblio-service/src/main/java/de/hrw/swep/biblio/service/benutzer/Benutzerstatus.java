package de.hrw.swep.biblio.service.benutzer;

import de.hrw.swep.biblio.service.Gebuehr;

/**
 * Repraesentiert den Zustand eines Bibliotheks-Benutzers
 * @author M. Friedrich
 *
 */
public interface Benutzerstatus {
	/**
	 * Mahnt einen Benutzer und vergibt eine Mahngebuehr
	 * @param geb die Mahngebuehr
	 */
	void mahnen(Gebuehr geb);
	/**
	 * Schaltet einen gesperrten Benutzer wieder frei.
	 */
	void freischalten();
}
