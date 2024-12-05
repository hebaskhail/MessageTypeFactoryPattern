/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.messagetype;

/**
 *
 * @author hebaskhail
 */
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import org.reflections.Reflections;

public class MessageType {

    public MessageType() {
   // create Frame
   
   JFrame frame = new JFrame("Message Factory Example");
   
   frame.setSize(500 , 400) ;
   
   frame.setLayout(new BorderLayout());
   
   // Create Panel to include components
   
   JPanel topPanel = new JPanel();
   
   // Call Type list
   
   List<String>  messageTypesNames = getMessageTypeNames();
   
   JComboBox <String> messageDropDown = new JComboBox<>(messageTypesNames.toArray(String[]:: new)); 
   
   JButton showMessageButton = new JButton ( "Show Message") ;
   
   topPanel.add (new JLabel("Select Message Type")) ;
    topPanel.add (messageDropDown) ;
     topPanel.add (showMessageButton) ;
   
   JTextArea messageTextArea = new JTextArea(5, 30 ) ; 
   messageTextArea.setEditable(false);
   
    JScrollPane  scrollPane = new JScrollPane(messageTextArea) ;
    
    frame.add(topPanel, BorderLayout.NORTH) ;
    frame.add(scrollPane ,  BorderLayout.CENTER) ;
    
   showMessageButton.addActionListener(
   new ActionListener () { 
       @Override
       public void actionPerformed(ActionEvent e) {
           
           String selectedType = (String) messageDropDown.getSelectedItem();
           Message messageText = MessageFactory.createMessage(selectedType);
           
           messageTextArea.setText(messageText.getMessageText());
           
       }
       
       
   }
   );
   
   
   frame.setVisible(true) ;
   
        
 }

    private static List<String> getMessageTypeNames() {
        Reflections reflections = new Reflections("com.mycompany.messagetype");

        List<Class <? extends Message> > messageTypesClasses = new ArrayList<>(reflections.getSubTypesOf(Message.class));

        List<String> messageTypeNames = new ArrayList<>();
        for (Class<? extends Message> messageClass : messageTypesClasses) {

           
            String className = messageClass.getSimpleName().replace("Message", "");

            messageTypeNames.add(className);
        }
        
        System.out.println(messageTypeNames);
      
        return messageTypeNames;
    }

    public static void main(String[] args) {
        new MessageType();
    }
}
