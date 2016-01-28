// CHECKSTYLE:OFF

package de.hrw.swep.biblio.service.benutzer;

import de.hrw.swep.biblio.service.Gebuehr;

public class Gesperrt implements Benutzerstatus{

	private Benutzer benutzer;

	public Gesperrt(Benutzer b) {
		this.benutzer = b;
	}
	
	public void mahnen(Gebuehr geb) {
		benutzer.getGebuehren().add(geb);
	}

	public void freischalten() {
		// TODO Statusübergang
	}

}
