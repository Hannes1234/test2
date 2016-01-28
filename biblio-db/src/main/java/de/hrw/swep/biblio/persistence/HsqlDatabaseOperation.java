// CHECKSTYLE:OFF

package de.hrw.swep.biblio.persistence;

import java.sql.SQLException;

import org.dbunit.DatabaseUnitException;
import org.dbunit.database.DatabaseConfig;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.IDataSet;
import org.dbunit.ext.hsqldb.HsqldbDataTypeFactory;
import org.dbunit.operation.DatabaseOperation;

/**
 * Konfiguriert die HSQL-Datentypen für DBUnit
 * @author S.Rebholz
 *
 */
public class HsqlDatabaseOperation extends DatabaseOperation {
  /**
   * Executes this operation on the specified database using the specified
   * dataset contents.
   *
   * @param connection the database connection.
   * @param dataSet the dataset to be used by this operation.
   */
  public void execute(IDatabaseConnection connection,
      IDataSet dataSet) throws DatabaseUnitException, SQLException {
        DatabaseConfig dbConfig = connection.getConfig();
        dbConfig.setProperty(DatabaseConfig.PROPERTY_DATATYPE_FACTORY, new HsqldbDataTypeFactory());        
      }
  
}