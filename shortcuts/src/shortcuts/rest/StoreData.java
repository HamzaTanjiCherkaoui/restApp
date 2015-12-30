package shortcuts.rest;

import java.util.ArrayList;
import java.util.Iterator;

import org.hibernate.HibernateException;
import org.hibernate.Session;  
import org.hibernate.SessionFactory;  
import org.hibernate.Transaction;  
import org.hibernate.cfg.Configuration;  

import shortcuts.model.Shortcut;
  
public class StoreData {  
public static void main(String[] args) {  
      
    //creating configuration object  
    Configuration cfg=new Configuration();  
    cfg.configure("hibernate.cfg.xml");//populates the data of the configuration file  
      
    //creating seession factory object  
    SessionFactory factory=cfg.buildSessionFactory();  
      
    //creating session object  
    Session session=factory.openSession();  
      
    //creating transaction object
    Transaction  t = null ;
    try{
      t= session.beginTransaction();
        ArrayList<Shortcut> shortcuts = (ArrayList<Shortcut>) session.createQuery("FROM Shortcut").list(); 
        for (Iterator iterator = 
        		shortcuts.iterator(); iterator.hasNext();){
           Shortcut s =  (Shortcut) iterator.next(); 
           System.out.println("description: " + s.getDescription()); 
            
        }
        t.commit();
     }catch (HibernateException e) {
        if (t!=null) t.rollback();
        e.printStackTrace(); 
     }finally {
        session.close(); 
     }  
          
      
      
      
      


      
    System.out.println("successfully saved");  
      
}  
}  
