/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.messagetype;

/**
 *
 * @author hebaskhail
 */
public class InfoMessage implements Message {
    @Override
    public String getMessageText() {
    return "Info : This is an information message";
    }

    public InfoMessage() {
    }
    
}

