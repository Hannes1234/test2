package de.hrw.swep.biblio.service.gegenstaende;

/**
 * Repraesentiert ein Buch.
 * @author M. Friedrich
 *
 */
public class Buch extends Gegenstand {

	private String titel;
	private String autor;
	
	/**
	 * Konstruktor: erzeugt ein Buch
	 * @param titel der Buchtitel
	 * @param autor der Autor
	 */
	public Buch(String titel, String autor) {
		super();
		this.titel = titel;
		this.autor = autor;
	}
	
	/**
	 * Liefert den Buchtitel zurueck.
	 * @return der Buchtitel
	 */
	public String getTitel() {
		return titel;
	}
	
	/**
	 * Setzt den Buchtitel.
	 * @param titel der Buchtitel
	 */
	public void setTitel(String titel) {
		this.titel = titel;
	}
	/**
	 * Liefert den Autor zurueck.
	 * @return der Autor
	 */
	public String getAutor() {
		return autor;
	}
	/**
	 * Setzt den Autor des Buches.
	 * @param autor der Autor
	 */
	public void setAutor(String autor) {
		this.autor = autor;
	}
	/**
	 * Liefert eine Beschreibung des Buches.
	 * @return die Buchbeschreibung
	 */
	@Override
	public String toString() {
		return "Buch [titel=" + titel + ", autor=" + autor + ", state=" + state
				+ "]";
	}
	
	
}
