/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.messagetype;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hebaskhail
 */
public class MessageFactory {
    public static Message createMessage(String messageType) {
        if (messageType == null || messageType.isEmpty()) {
            throw new IllegalArgumentException("Notification type cannot be null or empty");
        }

       String className = "com.mycompany.messagetype." + messageType + "Message" ;
       
     
        try {
            return (Message) Class.forName(className).newInstance();
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MessageFactory.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(MessageFactory.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(MessageFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
       
         
      
        return null;
        }
}

