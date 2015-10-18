package postgresqlImpl;

import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.postgresql.Driver;
import javax.swing.JOptionPane;

import postgresql.DataBase;

public class DataBaseImpl implements DataBase{
	public String url=null; 
	private String user=null; 
	private String pass=null;
	private Connection conn = null; // куда подсоединяемся
    private Statement st = null;
    /**
     * This is constructor.
     * url - the path, which has next format IP:port/database
     * For example "192.168.137.1:5432/name_of_my_database
     * */
    public DataBaseImpl (String url, String user, String pass)
    {
    	this.url=url;
    	this.user=user;
    	this.pass=pass;
    	
    }
    /**
     * @return Integer if success return 0 else -1
     * */
	public int init()
	{
		System.out.println("--PostgreSQL JDBC Connection Testing --");
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("Include PostgreSQL JDBC Driver in your library path!");
			e.printStackTrace();
			return -2;
		}
		System.out.println("PostgreSQL JDBC Driver Registered!");

		try {
			/*int ind = url.indexOf("/");
			url.substring(0, ind);*/
			conn = DriverManager.getConnection("jdbc:postgresql://"+url, user, pass);
			st = conn.createStatement();
		} catch (SQLException e) {
			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
			return -1;
		}
		return 0;
	}
	/**
	 * @return result set of query 
	 * @exception SQLException
	 * */
	public ResultSet getResult (String query) throws SQLException
	{
		newCreateStatment();
		ResultSet rs;
		rs = st.executeQuery(query);
		return rs;
	}
	/**
	 * execute query which return nothing 
	 * @exception SQLException
	 * */
	public void executeUpdate(String query) throws SQLException
	{
		newCreateStatment();
		st.executeUpdate(query);
	}
	/**
	 * Create new database.
	 * */
	public void createDataBase(String name) throws SQLException{
		executeUpdate("CREATE DATABASE "+name);
	}
	private void newCreateStatment()
	{
		try {
			st = conn.createStatement();
		} catch (SQLException e) {
			System.out.println("Statment doesn't create");
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
