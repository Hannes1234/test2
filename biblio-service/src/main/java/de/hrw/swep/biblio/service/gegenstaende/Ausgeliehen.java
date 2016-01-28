// CHECKSTYLE:OFF

package de.hrw.swep.biblio.service.gegenstaende;

import de.hrw.swep.biblio.service.IllegalStateTransition;
import de.hrw.swep.biblio.service.benutzer.Benutzer;

public class Ausgeliehen implements Ausleihstatus {

	private Gegenstand gegenstand;

	public Ausgeliehen(Gegenstand g) {
		this.gegenstand = g;
	}

	public void ausleihen(Benutzer user) {
		throw new IllegalStateTransition();
	}

	public void zurueckgeben() {
		this.gegenstand.setState(new Frei(gegenstand));
	}

	public void verloren() {
		// TODO Statusübergang
	}


}
