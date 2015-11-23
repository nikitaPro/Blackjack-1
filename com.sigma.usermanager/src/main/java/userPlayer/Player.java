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
/**
 * @author NikitaNB
 *
 */
public class Player {
private String mEmail;
private String mNick;
private DataBase mDataBase;
private Pattern pattern;
private Matcher matcher;

private static final String EMAIL_PATTERN = 
	"^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
	+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
public Player (DataBase db){
	this.mDataBase=db;
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
 * @return 0 - success; -1 - SecurityException
 * @throws SecurityException
 */
public int login(String email,char[] pass){
	if(!checkEmail(email)) throw new SecurityException("Invalid pass or e-mail");
	ResultSet res;
	try {
		res= mDataBase.getResult("SELECT nick FROM player WHERE email ='"+email+"' AND pass= '"+new String(pass)+"';");
		//System.out.println(pass);
		 Arrays.fill(pass,'-');
		if(res.next()){
			mNick=res.getString(1);
			System.out.println(mNick);
			//this.pass=pass;
			pass=null;
			this.mEmail=email;
		}
		else
			throw new SecurityException("Invalid pass or e-mail");
		return 0;
			
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return -1;
	}
	
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
public int registr(String email,char[] pass,String nick){
	if(!checkEmail(email)) return -1;
	if (nick.length()==0||nick==null){
		nick=nickGenerator(email);
	}
	if(pass.length<6) return -2;// pass has less than 6 character
	try {
		ResultSet res= mDataBase.getResult("SELECT nick FROM player WHERE email ='"+email+"';");
		if(res.next())
			return -3;// email already exist
		mDataBase.executeUpdate("INSERT INTO player VALUES (DEFAULT,'"+email+"','"+new String(pass)+"','"+nick+"');");
	} catch (SQLException e) {
		// TODO Auto-generated catch block
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
public boolean checkEmail(final String hex) {
	pattern = Pattern.compile(EMAIL_PATTERN);
	matcher = pattern.matcher(hex);
	return matcher.matches();
}
/**
 *  Generate nick for player
 * */
private String nickGenerator(String email){
		int s = email.indexOf('@');
		return email.substring(0,s);
}
}
