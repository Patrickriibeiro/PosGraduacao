package com.patrickriibeiro.listener;

import java.io.FileWriter;
import java.util.Date;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

/**
 * Application Lifecycle Listener implementation class ListenerSession
 *
 */
@WebListener
public class ListenerSession implements HttpSessionAttributeListener {

    /**
     * Default constructor. 
     */
    public ListenerSession() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see HttpSessionAttributeListener#attributeAdded(HttpSessionBindingEvent)
     */
    public void attributeAdded(HttpSessionBindingEvent arg0)  { 
         try {
        	 FileWriter fw = new FileWriter("C:/Users/Patrick/log.txt", true);
        	 fw.write("Usuario armazenado na sessao : " + new Date().toString());
        	 fw.close();
         } catch (Exception e) {
			// TODO: handle exception
		}
    }

	/**
     * @see HttpSessionAttributeListener#attributeRemoved(HttpSessionBindingEvent)
     */
    public void attributeRemoved(HttpSessionBindingEvent arg0)  { 
         // TODO Auto-generated method stub
    }

	/**
     * @see HttpSessionAttributeListener#attributeReplaced(HttpSessionBindingEvent)
     */
    public void attributeReplaced(HttpSessionBindingEvent arg0)  { 
         // TODO Auto-generated method stub
    }
	
}
