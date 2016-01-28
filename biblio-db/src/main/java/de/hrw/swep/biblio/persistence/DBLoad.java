// CHECKSTYLE:OFF

package de.hrw.swep.biblio.persistence;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;

import org.dbunit.IDatabaseTester;
import org.dbunit.JdbcDatabaseTester;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;

/**
 * Erzeugt und initialisiert die Bibliotheks-Datenbank
 * @author M. Friedrich
 */
public class DBLoad {

  public static void main(String[] args) throws Exception {

    Connection c = DriverManager.getConnection("jdbc:hsqldb:file:../biblio-db/database/bibdb",
        "sa", "");
    c.setAutoCommit(false);
    
    System.out.println("Creating database tables...");
    c.createStatement().executeQuery("DROP TABLE GEBUEHR   IF EXISTS");
    c.createStatement().executeQuery("DROP TABLE USER   IF EXISTS");
    c.createStatement().executeQuery("DROP TABLE BUCH   IF EXISTS");

    c.createStatement().executeQuery(
        "CREATE TABLE USER (id INTEGER PRIMARY KEY, name varchar(255), state VARCHAR(64)) ");
    c.createStatement()
        .executeQuery(
            "CREATE TABLE GEBUEHR (USERID INTEGER REFERENCES USER(ID), text varchar(255), amount INTEGER) ");
    c.createStatement()
        .executeQuery(
            "CREATE TABLE BUCH (id INTEGER primary key, AUTOR VARCHAR(255), TITEL VARCHAR(255), STATUS VARCHAR(255))");
    c.commit();
    c.close();
    
    System.out.println("Loading data from xml file...");
    IDatabaseTester databaseTester = new JdbcDatabaseTester("org.hsqldb.jdbcDriver",
        "jdbc:hsqldb:file:../biblio-db/database/bibdb", "sa", "");
    databaseTester.setSetUpOperation(new HsqlDatabaseOperation());
    databaseTester.setDataSet(new FlatXmlDataSetBuilder().build(new File("full.xml")));
    databaseTester.onSetup();
    
    System.out.println("Done.");
  }

}
