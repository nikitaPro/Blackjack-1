package postgresql;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface DataBase {
	public int init();
	public ResultSet getResult (String query) throws SQLException;
	public void executeUpdate(String query) throws SQLException;
	public void createDataBase(String name) throws SQLException;
	public String getUrl();
}
