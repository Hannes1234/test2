// CHECKSTYLE:OFF

package de.hrw.swep.biblio.service.gegenstaende;

import de.hrw.swep.biblio.service.IllegalStateTransition;
import de.hrw.swep.biblio.service.benutzer.Benutzer;

public class Frei implements Ausleihstatus {

	private Gegenstand gegenstand;

	public Frei(Gegenstand g) {
		this.gegenstand = g;
	}
	
	public void ausleihen(Benutzer user) {
		if (user.isNormal()) {
			this.gegenstand.setState(new Ausgeliehen(gegenstand));
		}
	}

	public void zurueckgeben() {
		throw new IllegalStateTransition();
	}

	public void verloren() {
		// TODO Statusübergang
	}
}
