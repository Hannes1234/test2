package de.hrw.swep.biblio.service;

import java.lang.reflect.InvocationTargetException;
import java.util.HashSet;
import java.util.Set;

import de.hrw.swep.biblio.persistence.DBInterface;
import de.hrw.swep.biblio.persistence.dto.BenutzerDTO;
import de.hrw.swep.biblio.persistence.dto.BuchDTO;
import de.hrw.swep.biblio.persistence.dto.GebuehrDTO;
import de.hrw.swep.biblio.service.benutzer.Benutzer;
import de.hrw.swep.biblio.service.benutzer.Gesperrt;
import de.hrw.swep.biblio.service.benutzer.Normal;
import de.hrw.swep.biblio.service.gegenstaende.Ausleihstatus;
import de.hrw.swep.biblio.service.gegenstaende.Buch;
import de.hrw.swep.biblio.service.gegenstaende.Gegenstand;

/**
 * Service-Klasse zur Bibliotheksverwaltung
 * @author M. Friedrich
 *
 */
public class Bibliothek {

	private DBInterface db;

	/**
	 * Setzt die zu verwendende Datenbank-Implementierung
	 * @param db die Datenbank-Implementierung
	 */
	public void setDb(DBInterface db) {
		this.db = db;
	}

	/**
	 * Liefert alle Buecher mit dem gegebenen Titel
	 * @param titel der Buchtitel
	 * @return die Buchobjekte
	 */
	public Set<Buch> sucheBuchNachTitel(String titel) {
		HashSet<Buch> result = new HashSet<Buch>();
		for (BuchDTO buch : db.getBuchByTitle(titel)) {
			Buch b = new Buch(buch.getTitel(), buch.getAutor());
			try {
				try {
					b.setState((Ausleihstatus) Class
							.forName(
									"de.hrw.swep.biblio.service.gegenstaende."
											+ buch.getStatus())
							.getDeclaredConstructor(Gegenstand.class)
							.newInstance(b));
				} catch (IllegalArgumentException e) {

					e.printStackTrace();
				} catch (InvocationTargetException e) {

					e.printStackTrace();
				} catch (NoSuchMethodException e) {

					e.printStackTrace();
				} catch (SecurityException e) {

					e.printStackTrace();
				}
			} catch (InstantiationException e) {

				e.printStackTrace();
			} catch (IllegalAccessException e) {

				e.printStackTrace();
			} catch (ClassNotFoundException e) {

				e.printStackTrace();
			}
			result.add(b);
		}
		return result;

	}

	/**
	 * Liefert alle Buecher des gegebenen Autors 
	 * @param autor der Autor
	 * @return die Buchobjekte
	 */
	public Set<Buch> sucheBuchNachAutor(String autor) {
		return null;

	}

	/**
	 * Liefert alle Benutzer mit dem gegebenen Namen
	 * @param name der Name
	 * @return die Benutzerobjekte
	 */
	public Set<Benutzer> sucheBenutzerNachName(String name) {
		HashSet<Benutzer> result = new HashSet<Benutzer>();
		for (BenutzerDTO benutzer : db.getBenutzerByName(name)) {
			result.add(sucheBenutzerNachId(benutzer.getId()));
		}
		return result;
	}

	/**
	 * Liefert den Benutzer mit der gegebenen ID
	 * @param id die Benutzer-ID
	 * @return der Benutzer
	 */
	public Benutzer sucheBenutzerNachId(long id) {
		BenutzerDTO benutzerDTO = this.db.getBenutzerById(id);
		Benutzer b = new Benutzer(id, benutzerDTO.getName());
		b.setStatus(benutzerDTO.getStatus().equals("Normal") ? new Normal(b)
				: new Gesperrt(b));
		for (GebuehrDTO gDTO : db.getGebuehrenByUserId(id)) {
			b.getGebuehren().add(new Gebuehr(gDTO.getText(), gDTO.getBetrag()));
		}
		return b;
	}

}
