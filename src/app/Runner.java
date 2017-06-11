
package app;

import controllers.ControllersManager;


public class Runner {

    
    public static void main(String[] args) {
        
        start();
    }
    
    public static void start() {
        ControllersManager manager = new ControllersManager();
        manager.execute();
    }

}
