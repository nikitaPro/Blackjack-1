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
//private String pass;
private String nick;
private DataBase db;
public Player (DataBase db){
	this.db=db;
}
/** 
 * @return email for this player
 */
public String getEmail(){
	return email;
}
/**
 * 
 * @return nick name
 */
public String getNick(){
	return nick;
}
/**
 * 
 * @param email - e-mail
 * @param pass - password
 * @return 0 - seccess; -1 - SecurityException
 * @throws SecurityException
 */
public int login(String email,String pass)throws SecurityException{
	try {
		ResultSet res= db.getResult("SELECT nick FROM player WHERE email ="+email+"AND pass="+pass+";");
		if(res.next()){
			nick=res.getString(0);
			//this.pass=pass;
			pass=null;
			this.email=email;
		}
		else
			throw new SecurityException("Invalid pass or e-mail");
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return -1;
	}
	return 0;
}
/**
 * Logs the user in the system and makes an entry in the database.
 * @param email - e-mail
 * @param pass - password
 * @param nick - nick name
 * @return -1 - wrong format for e-mail; -2 - pass has less than 6 character; 0 - seccess 
 */
public int registr(String email,String pass,String nick){
	if(checkEmail(email)<0)
		return -1;
	if(pass.length()<6)
		return -2;
	try {
		db.executeUpdate("INSERT INTO player VALUES (DEFAULT,'"+email+"','"+pass+"','"+nick+"');");
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return 0;
}
/**
 * Check e-mail word@word
 * @param email - e-mail
 * @return -1 - wrong; 0 - seccess
 */
private int checkEmail(String email){
	int i =email.indexOf("@");
	if (i==-1)
		return -1;
	else 
		return 0;
}
}
