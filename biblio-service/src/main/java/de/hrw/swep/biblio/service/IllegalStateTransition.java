package de.hrw.swep.biblio.service;

/**
 * Unzulaessiger Statusuebergang
 * @author M. Friedrich
 *
 */
public class IllegalStateTransition extends RuntimeException {

	private static final long serialVersionUID = 9162959731450605570L;

	/**
	 * Konstruktor
	 */
	public IllegalStateTransition() {
		super();
		
	}
	
    /**
     * Liefert eine textuelle Beschreibung der Exception
     * @return die Beschreibung
     */
	public String toString() {
        String s = getClass().getName();
        String message = "Übergang " + getStackTrace()[0].getMethodName() + " in Zustand " + getStackTrace()[0].getClassName() + " nicht möglich";
        return s + ": " + message;
    }

}
