// CHECKSTYLE:OFF

package de.hrw.swep.biblio.persistence.dto;

public class GebuehrDTO {

  private String text;
  private int betrag;

  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }

  public int getBetrag() {
    return betrag;
  }

  public void setBetrag(int betrag) {
    this.betrag = betrag;
  }

  public GebuehrDTO(String text, int betrag) {
    super();
    this.text = text;
    this.betrag = betrag;
  }

}
