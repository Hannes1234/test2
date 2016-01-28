// CHECKSTYLE:OFF

package de.hrw.swep.biblio.persistence.dto;

public class BenutzerDTO {
  private long id;
  private String name;
  private String status;

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public BenutzerDTO(long id, String name, String status) {
    super();
    this.id = id;
    this.name = name;
    this.status = status;
  }

}
