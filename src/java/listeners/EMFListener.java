/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listeners;

import database.DBUtil;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Web application lifecycle listener.
 *
 * @author awarsyle
 */
public class EMFListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        
        System.out.println("application is starting");
        
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        DBUtil.close();
        System.out.println("application is ending");
        
    }
}
