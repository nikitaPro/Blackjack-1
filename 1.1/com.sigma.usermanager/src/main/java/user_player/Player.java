/**
 * 
 */
package user_player;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.MissingResourceException;

import postgresql.DataBase;

/**
 * @author NikitaNB
 *
 */
public class Player {
private String email;
private String pass;
private String nick;
private DataBase db;
public Player (DataBase db){
	this.db=db;
}
public String getEmail(){
	return email;
}
public String getNick(){
	return nick;
}
public int login(String email,String pass)throws SecurityException{
	try {
		ResultSet res= db.getResult("SELECT nick FROM player WHERE email ="+email+"AND pass="+pass+";");
		if(res.next()){
			nick=res.getString(0);
			this.pass=pass;
			this.email=email;
		}
		else
			throw new SecurityException("Invalid pass or e-mail");
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return 1;
	}
	return 0;
}
public int registr(String email,String pass,String nick){
	try {
		db.executeUpdate("INSERT INTO player VALUES (DEFAULT,'"+email+"','"+pass+"','"+nick+"');");
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return 0;
}

}
