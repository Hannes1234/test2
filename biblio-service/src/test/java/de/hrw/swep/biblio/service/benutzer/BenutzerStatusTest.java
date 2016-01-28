package de.hrw.swep.biblio.service.benutzer;

import static org.junit.Assert.*;

import org.junit.Test;

import de.hrw.swep.biblio.service.Gebuehr;
import de.hrw.swep.biblio.service.IllegalStateTransition;

/**
 * Testklasse fuer Statusuebergaenge des Bibliothek-Benutzers
 * @author M. Friedrich
 *
 */
public class BenutzerStatusTest {

	/**
	 * Ein Benutzer wird gemahnt: 
	 * Statusuebergang "Normal" => "Gesperrt" wird getestet
	 */
	@Test
	public void testMahnen() {
		Benutzer b = new Benutzer(1, "TestUser");
		b.setStatus(new Normal(b));
		
		b.mahnen(new Gebuehr("Testgebühr", 100));
		assertEquals("de.hrw.swep.biblio.service.benutzer.Gesperrt", b.getStatus().getClass().getName());
	}

	/** 
	 * Ein gesperrter Nutzer wird freigeschalten:
	 * Statusuebergang "Gesperrt" => "Normal" wird getestet
	 */
	@Test
	public void testFreischalten() {
		Benutzer b = new Benutzer(1, "TestUser");
		b.setStatus(new Gesperrt(b));
		
		b.freischalten();
		assertEquals("de.hrw.swep.biblio.service.benutzer.Normal", b.getStatus().getClass().getName());
	}
	
	/** 
	 * Ein Nutzer im normalen Zustand kann nicht freigeschaltet werden.
	 */
	@Test(expected = IllegalStateTransition.class)
	public void testIllegalTransitionNormal() {
		Benutzer b = new Benutzer(1, "TestUser");
		b.setStatus(new Normal(b));
		
		b.freischalten();
	}

}
