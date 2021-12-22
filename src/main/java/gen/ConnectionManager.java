/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package gen;

/**
 *
 * @author ditiman
 */
import java.sql.Connection;
import java.sql.SQLException;


public abstract class ConnectionManager {
    public static ConnectionManager instance;
    public abstract Connection getConnection(boolean pooledConnection) throws SQLException;
    
}
	