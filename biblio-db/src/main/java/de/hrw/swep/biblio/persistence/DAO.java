package de.hrw.swep.biblio.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

import de.hrw.swep.biblio.persistence.dto.BenutzerDTO;
import de.hrw.swep.biblio.persistence.dto.BuchDTO;
import de.hrw.swep.biblio.persistence.dto.GebuehrDTO;

/**
 * Zugriffsklasse für die Bibliotheks-Datenbank
 * @author M. Friedrich
 *
 */
public class DAO implements DBInterface {

  /**
   * Fuehrt eine SQL-Anfrage aus
   * @param sql die SQL-Anfrage als String
   * @return das Ergebnis der SQL-Anfrage
   */
  private ResultSet executeQuery(String sql) {
    Connection c = null;
    try {
      c = DriverManager.getConnection("jdbc:hsqldb:file:../biblio-db/database/bibdb", "sa", "");
      ResultSet rs = c.createStatement().executeQuery(sql);
      c.commit();
      return rs;
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      try {
        if (c != null)
          c.close();
      } catch (SQLException e) {
        e.printStackTrace();
      }
    }
    return null;
  }

  /**
   * Liefert den Benutzer mit der gegebenen ID zurueck
   * @param id die Benutzer-ID
   * @return das Benutzerobjekt
   */
  public BenutzerDTO getBenutzerById(long id) {
    ResultSet rs = executeQuery("SELECT * FROM USER WHERE id=" + id);
    try {
      
      if (rs.next()) {
        return new BenutzerDTO(rs.getInt(1), rs.getString(2), rs.getString(3));
      }
    } catch (SQLException e) {

      e.printStackTrace();
    }
    return null;
  }

  /**
   * Liefert die Benutzer mit dem gegebenen Namen zurueck
   * @param name der Benutzername
   * @return die Benutzerobjekte
   */
  public Set<BenutzerDTO> getBenutzerByName(String name) {
    Set<BenutzerDTO> result = new HashSet<BenutzerDTO>();
    ResultSet result_set = executeQuery("SELECT * FROM USER WHERE name=\'" + name + "\'");
    try {
      while (result_set.next()) {
        result.add(new BenutzerDTO(result_set.getInt(1), result_set.getString(2), result_set.getString(3)));
      }
      return result;
    } catch (SQLException e) {

      e.printStackTrace();
    }
    return null;
  }

  /**
   * Liefert alle Buecher eines Autors zurueck
   * @param autor der Name des Autors
   * @return die Buchobjekte
   */
  public Set<BuchDTO> getBuchByAutor(String autor) {
    Set<BuchDTO> result = new HashSet<BuchDTO>();
    ResultSet rs = executeQuery("SELECT id,autor,titel,status FROM BUCH WHERE autor LIKE \'%"
        + autor + "%\'");
    try {
      while (rs.next()) {
        result.add(new BuchDTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4)));
      }
      return result;
    } catch (SQLException e) {

      e.printStackTrace();
    }
    return null;
  }

  /**
   * Liefert die Buecher mit dem gegebenen Titel zurueck
   * @param title der Buchtitel
   * @return die Buchobjekte
   */
  public Set<BuchDTO> getBuchByTitle(String title) {
    Set<BuchDTO> result = new HashSet<BuchDTO>();
    ResultSet rs = executeQuery("SELECT id,autor,titel,status FROM BUCH WHERE titel LIKE \'%"
        + title + "%\'");
    try {
      while ( rs.next() ) {
        result.add(new BuchDTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4)));
      }
      return result;
    } catch (SQLException e) {
    }
    return null;
  }

  /**
   * Liefert die Gebuehren des gegebenen Nutzers zurueck
   * @param id die Nutzer-ID
   * @return die Gebuehrobjekte
   */
  public Set<GebuehrDTO> getGebuehrenByUserId(long id) {
    Set<GebuehrDTO> result = new HashSet<GebuehrDTO>();
    ResultSet rs = executeQuery("SELECT text,amount FROM GEBUEHR WHERE userid=" + id);
    try {
      while (rs.next()) {
        result.add(new GebuehrDTO(rs.getString(1), rs.getInt(2)));
      }
      return result;
    } catch (SQLException e) {

      e.printStackTrace();
    }
    return null;
  }

}
