package de.hrw.swep.biblio.persistence;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.io.File;

import org.dbunit.IDatabaseTester;
import org.dbunit.JdbcDatabaseTester;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.junit.Before;
import org.junit.Test;

import de.hrw.swep.biblio.persistence.dto.BenutzerDTO;

/**
 * Testklasse fuer den Datenbankzugriff
 * @author M. Friedrich
 *
 */
public class DAOTest {

  IDatabaseTester databaseTester;
  
  /**
   * Bringt die Datenbank in einen definierten Ausgangszustand
   * @throws Exception 
   */
  @Before
  public void setup() throws Exception {
    databaseTester = new JdbcDatabaseTester("org.hsqldb.jdbcDriver",
        "jdbc:hsqldb:file:../biblio-db/database/bibdb", "sa", "");
    databaseTester.setSetUpOperation(new HsqlDatabaseOperation());
    databaseTester.setDataSet(new FlatXmlDataSetBuilder().build(new File("full.xml")));
    databaseTester.onSetup();
  }

  /**
   * Testet das Abrufen eines bestimmten Nutzers nach der Nutzer-ID
   */
  @Test
  public void testGetUserById() {
    DAO dao = new DAO();
    BenutzerDTO b = dao.getBenutzerById(1);
    assertEquals("Adalbert Alt", b.getName());
    assertEquals("Normal", b.getStatus());
  }

  /**
   * Testet das Abrufen eines Benutzers mit einem gegebenen Namen.
   */
  @Test
  public void testGetBenutzerByName() {
    fail();
  }

  /** 
   * Testet das Abrufen aller Buecher eines Autors
   */
  @Test
  public void testGetBuchByAutor() {
    fail();
  }

  /**
   * Testet das Abrufen eines Buches nach dem Titel.
   */
  @Test
  public void testGetBuchByTitle() {
    fail();
  }
}
