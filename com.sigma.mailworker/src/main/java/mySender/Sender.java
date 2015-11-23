/**
 * 
 */
package mySender;

/**
 * @author NikitaNB
 *
 */
public interface Sender {

	public void setMailDest(String mail);
	public void setMessage(String mess);
	public void setSubject(String subj);
	public void send();
	public String getSubject();
}
