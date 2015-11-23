/**
 * 
 */
package mySender;

import org.osgi.framework.Bundle;
import org.osgi.framework.ServiceFactory;
import org.osgi.framework.ServiceRegistration;


/**
 * @author NikitaNB
 *
 */
	public class SenderServiceFactory implements ServiceFactory{
	    private int usageCounter = 0;
	    public Object getService(Bundle bundle, ServiceRegistration registration) {
	        System.out.println("Create object of Sender for " + bundle.getSymbolicName());
	        usageCounter++;
	        System.out.println("Number of bundles using service " + usageCounter);
	        
	        Sender sender = new SenderImp("blackjackmailproject@gmail.com","bj123456");
	        return sender;
	    }
	    public void ungetService(Bundle bundle, ServiceRegistration registration, Object service) {
	        System.out.println("Release object of DataBase for " + bundle.getSymbolicName());
	        usageCounter--;
	        System.out.println("Number of bundles using service " + usageCounter);
	    }
	}

