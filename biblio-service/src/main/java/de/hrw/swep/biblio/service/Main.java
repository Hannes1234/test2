// CHECKSTYLE:OFF

package de.hrw.swep.biblio.service;

import de.hrw.swep.biblio.persistence.DAO;
import de.hrw.swep.biblio.service.benutzer.Benutzer;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Bibliothek bib = new Bibliothek();
		bib.setDb(new DAO());

		System.out.println( bib.sucheBenutzerNachId(1));
		System.out.println( bib.sucheBenutzerNachId(2));
		System.out.println( bib.sucheBenutzerNachId(3));
		System.out.println( bib.sucheBenutzerNachId(4));
	}

}
