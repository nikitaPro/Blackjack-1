/**
 * 
 */
package user_player;

import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTracker;

import postgresql.DataBase;

/**
 * @author NikitaNB
 *
 */
public class HelloServiceTracker extends ServiceTracker {
    public HelloServiceTracker(BundleContext context) {
        super(context, DataBase.class.getName(),null);
    }
    public Object addingService(ServiceReference reference) {
        System.out.println("Inside HelloServiceTracker.addingService " + reference.getBundle());
        return super.addingService(reference);
    }
    public void removedService(ServiceReference reference, Object service) {
        System.out.println("Inside HelloServiceTracker.removedService " + reference.getBundle());
        super.removedService(reference, service);
    }
}