// CHECKSTYLE:OFF

package de.hrw.swep.biblio.persistence.dto;

public class BuchDTO {
  long id;
  String autor;
  String titel;
  String status;

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getAutor() {
    return autor;
  }

  public void setAutor(String autor) {
    this.autor = autor;
  }

  public String getTitel() {
    return titel;
  }

  public void setTitel(String titel) {
    this.titel = titel;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public BuchDTO(long id, String autor, String titel, String status) {
    super();
    this.id = id;
    this.autor = autor;
    this.titel = titel;
    this.status = status;
  }

}
