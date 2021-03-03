/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacionmail;

import java.io.File;
import java.util.Date;
import java.util.Properties;
import java.util.Scanner;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author david
 */
public class AplicacionMail {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        JFrameLogin login = new JFrameLogin();
        login.setVisible(true);
        
        //Requisitos de conexión
       Properties props = new Properties();
       props.put("mail.smtp.auth", "true");
       props.put("mail.smtp.starttls.enable", "true");
       props.put("mail.smtp.host", "smtp.gmail.com");
       props.put("mail.smtp.port", "587");
       
       //Datos del usuario
       String miCuenta = "david.garcia.leon.12@gmail.com";
       String miContraseña = "loquendo911";
               
       //Se crea la sesión con la autenticación
       Session session = Session.getInstance(props, new Authenticator(){
           @Override
           protected PasswordAuthentication getPasswordAuthentication(){
               return new PasswordAuthentication(miCuenta, miContraseña);
           }
       });

       
        try {
            MimeMessage msg = new MimeMessage(session);
            
            msg.setFrom(new InternetAddress(miCuenta));
            msg.setRecipients(Message.RecipientType.TO, "david.garcia.leon.12@gmail.com"); //Añadir destinatario
            
            msg.setSubject("Javamail Prueba 2");
            msg.setSentDate(new Date());
            msg.setText("Hola, zorra\n");
            
            String filename = "/Users/david/Documents/NetBeansProjects/AplicacionMail/imagen.jpg";
            DataSource source = new FileDataSource(filename);
            msg.setDataHandler(new DataHandler(source));
            msg.setFileName(filename);
            
            Transport.send(msg, miCuenta, miContraseña);
            
            System.out.println("Se envió! Esooooo");
        } catch (MessagingException mex) {
            System.out.println("send failed, exception: " + mex);
        }
        
       
    }
    
}
