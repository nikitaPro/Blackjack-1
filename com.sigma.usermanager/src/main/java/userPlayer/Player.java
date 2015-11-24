/**
 * 
 */
package userPlayer;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;

import main.Main;
import mySender.Sender;
import mySender.SenderImp;
import postgresql.DataBase;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import form.CasinoFrame;
/**
 * @author NikitaNB
 *
 */
public class Player {
private String mEmail;
private String mNick;
private static Pattern pattern;

private static final String EMAIL_PATTERN = 
	"^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
	+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
private Player (String email,String nick){
	mEmail=email;
	mNick=nick;
}
/** 
 * @return email for this player
 */
public String getEmail(){
	return mEmail;
}
/**
 * 
 * @return nick name
 */
public String getNick(){
	return mNick;
}
/**
 * 
 * @param email - e-mail
 * @param pass - password
 * @return Player instance, and null when SQLException 
 * @throws SecurityException
 */
public static Player login(String email,char[] pass){
	if(!checkEmail(email)) throw new SecurityException("Invalid pass or e-mail");
	ResultSet res;
	String Nick;
	String EmailAdr;
	try {
		res= Main.db.getResult("SELECT nick FROM player WHERE email ='"+email+"' AND pass= '"+new String(pass)+"';");
		//System.out.println(pass);
		 Arrays.fill(pass,'-');
		if(res.next()){
			Nick=res.getString(1);
			System.out.println(Nick);
			//this.pass=pass;
			pass=null;
			EmailAdr=email;
		}
		else
			throw new SecurityException("Invalid pass or e-mail");
		return new Player(EmailAdr,Nick);
			
	} catch (SQLException e) {
		System.out.println("There was a database error during login");
		e.printStackTrace();
		return null;
	}
	
}
public void openTables(){
	CasinoFrame cf = new CasinoFrame();
	cf.setVisible(true);
}
/**
 * Logs the user in the system and makes an entry in the database.
 * @param email - e-mail
 * @param pass - password
 * @param nick - nick name
 * @return	-1 - wrong format for e-mail; <br>
 * 			-2 - pass has less than 6 character; <br>
 * 			-3 - email already exist;<br>
 * 			-4 - data base error
 * 			 0 - success 
 */
public static int registr(String email,char[] pass,String nick){
	if(!checkEmail(email)) return -1;
	if (nick.length()==0||nick==null){
		nick=nickGenerator(email);
	}
	if(pass.length<6) return -2;// pass has less than 6 character
	try {
		ResultSet res= Main.db.getResult("SELECT nick FROM player WHERE email ='"+email+"';");
		if(res.next())
			return -3;// email already exist
		Main.db.executeUpdate("INSERT INTO player VALUES (DEFAULT,'"+email+"','"+new String(pass)+"','"+nick+"');");
	} catch (SQLException e) {
		System.out.println("A database error occurred during registration");
		e.printStackTrace();
		return -4;
	}
	Sender s = Main.snd;
	s.setMailDest(email);
	s.setMessage("Wellcome to the BlackJack world :D, "+nick+", your pass "+ new String(pass)+"\n Don't respond.\n Sincerely your team of students Polytechnic University.");
	s.send();
	return 0;
}
/**
 * Check e-mail word@word
 * @param email - e-mail
 * @return -1 - wrong; 0 - success
 */
private static boolean checkEmail(final String hex) {
	pattern = Pattern.compile(EMAIL_PATTERN);
	Matcher matcher = pattern.matcher(hex);
	return matcher.matches();
}
/**
 *  Generate nick for player
 * */
private static String nickGenerator(String email){
		int s = email.indexOf('@');
		return email.substring(0,s);
}
}
