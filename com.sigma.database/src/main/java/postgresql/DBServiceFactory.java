/**
 * 
 */
package postgresql;

import org.osgi.framework.Bundle;
import org.osgi.framework.ServiceFactory;
import org.osgi.framework.ServiceRegistration;

import postgresqlImpl.DataBaseImpl;


/**
 * @author NikitaNB
 *
 */
	public class DBServiceFactory implements ServiceFactory{
	    private int usageCounter = 0;
	    public Object getService(Bundle bundle, ServiceRegistration registration) {
	        System.out.println("Create object of DataBase for " + bundle.getSymbolicName());
	        usageCounter++;
	        System.out.println("Number of bundles using service " + usageCounter);
	        
	        DataBase dataBase = new DataBaseImpl("127.0.0.1:5432/sigma", "postgres", "123");
	        return dataBase;
	    }
	    public void ungetService(Bundle bundle, ServiceRegistration registration, Object service) {
	        System.out.println("Release object of DataBase for " + bundle.getSymbolicName());
	        usageCounter--;
	        System.out.println("Number of bundles using service " + usageCounter);
	    }
	}

