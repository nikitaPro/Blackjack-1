/**
 * 
 */
package userPlayer;

import mySender.Sender;

import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTracker;

import postgresql.DataBase;

/**
 * @author NikitaNB
 *
 */
public class SenderServiceTracker extends ServiceTracker {
    @SuppressWarnings("unchecked")
	public SenderServiceTracker(BundleContext context) {
        super(context, Sender.class.getName(),null);
      
    }
    @SuppressWarnings("unchecked")
	public Object addingService(ServiceReference reference) {
        System.out.println("Inside HelloServiceTracker.addingService " + reference.getBundle());
        return super.addingService(reference);
    }
    public void removedService(ServiceReference reference, Object service) {
        System.out.println("Inside HelloServiceTracker.removedService " + reference.getBundle());
        super.removedService(reference, service);
    }
    
}
