package de.hrw.swep.biblio.service;

/**
 * Eine Gebühr, die zu zahlen ist
 *
 */
public class Gebuehr {
	/**
	 * Textuelle Beschreibung
	 */
	private String text;
	
	/**
	 * Betrag
	 */
	private int betrag;

	/**
	 * Konstruktor: erzeugt die Gebuehr
	 * @param t	die textuelle Beschreibung
	 * @param b der Betrag
	 */
	public Gebuehr(String t, int b) {
		this.text = t;
		this.betrag = b;
	}

	/**
	 * Liefert die textuelle Beschreibung
	 * @return die textuelle Beschreibung
	 */
	public String getText() {
		return text;
	}

	/**
	 * Setzt die textuelle Beschreibung
	 * @param text die textuelle Beschreibung
	 */
	public void setText(String text) {
		this.text = text;
	}

	/**
	 * Liefert den Mahnbetrag
	 * @return der Mahnbetrag
	 */
	public int getBetrag() {
		return betrag;
	}

	/**
	 * Setzt den Mahnbetrag
	 * @param betrag der Mahnbetrag
	 */
	public void setBetrag(int betrag) {
		this.betrag = betrag;
	}

	@Override
	public String toString() {
		return "Gebuehr [text=" + text + ", betrag=" + betrag + "]";
	}
	
	
}
