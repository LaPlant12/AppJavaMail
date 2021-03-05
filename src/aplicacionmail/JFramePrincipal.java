/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacionmail;

import java.io.File;
import java.util.Date;
import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Authenticator;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author david
 */
public class JFramePrincipal extends javax.swing.JFrame {
    //Datos del usuario utilizados globalmente
    //Estos datos se obtienen del constructor, el cual
    //fue invocado en el frame anterior(login)
    private String usuario;
    private String contraseña;
    private String host;
    private int port;
    
    //La variable que indica la locación del archivo
    private String path = "";
    
    //Clases que se utilizan para enviar el mensaje
    private Properties props;
    private Session session;
    private MimeMessage msg;
    
    //Clases utilizadas para dividir el mensaje en body y archivos
    private BodyPart messageBodyPart;
    private Multipart multipart;
    
    private JFrameLogin login;
    
    /**
     * Creates new form JFrame
     */
    //Añade los datos pasados del login para utilizarlos en el mail
    public JFramePrincipal(String usr, String con, String hos, int por, JFrameLogin fr) {
        this.setTitle("JavaMail");
        
        login = fr;
        
        //Se guardan los datos del constructor en variables globales
        //para ser utilizados en los botones
        usuario = usr;
        contraseña = con;
        host = hos;
        port = por;
        
        //Propiedades para conectarse y autenticarse
        props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", port);


        //Se crea la sesión con la autenticación
        session = Session.getInstance(props, new Authenticator(){
            @Override
            protected PasswordAuthentication getPasswordAuthentication(){
                return new PasswordAuthentication(usuario, contraseña);
            }
        });

        //Se crea el objeto del mensaje
        msg = new MimeMessage(session);
        
        initComponents();
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jTextFieldPara = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldEncabezado = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextAreaContenido = new javax.swing.JTextArea();
        jButtonArchivo = new javax.swing.JButton();
        jButtonEnviar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jTextFieldCC = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextFieldCCO = new javax.swing.JTextField();
        jLabelPath = new javax.swing.JLabel();
        jButtonAtras = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel2.setText("Para:");

        jTextFieldPara.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        jLabel3.setText("Encabezado: ");

        jTextFieldEncabezado.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        jTextAreaContenido.setColumns(20);
        jTextAreaContenido.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jTextAreaContenido.setRows(5);
        jScrollPane1.setViewportView(jTextAreaContenido);

        jButtonArchivo.setText("Adjuntar archivo");
        jButtonArchivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonArchivoActionPerformed(evt);
            }
        });

        jButtonEnviar.setText("Enviar");
        jButtonEnviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEnviarActionPerformed(evt);
            }
        });

        jLabel4.setText("CC:");

        jTextFieldCC.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jTextFieldCC.setToolTipText("Opcional");

        jLabel5.setText("CCO:");

        jTextFieldCCO.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jTextFieldCCO.setToolTipText("Opcional");

        jButtonAtras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/aplicacionmail/atras1.png"))); // NOI18N
        jButtonAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAtrasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonArchivo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonEnviar, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(jTextFieldEncabezado))
                    .addComponent(jLabelPath, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jButtonAtras, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING))
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldCCO, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jTextFieldCC, javax.swing.GroupLayout.DEFAULT_SIZE, 392, Short.MAX_VALUE)
                                .addComponent(jTextFieldPara)))))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldPara, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jButtonAtras)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldCC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldCCO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldEncabezado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonArchivo)
                    .addComponent(jButtonEnviar))
                .addGap(17, 17, 17)
                .addComponent(jLabelPath, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonEnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEnviarActionPerformed
        
        try {
            //El usuario que envía el mensake
            msg.setFrom(new InternetAddress(usuario));
            
            //Se añade la cuenta de la persona a la que se le va a 
            //enviar el mensaje
            msg.setRecipients(Message.RecipientType.TO, jTextFieldPara.getText()); //Añadir destinatario
            
            //En caso de existir, se añaden los CC y CCO, solo se puede uno
            if(jTextFieldCC.getText() != "")
                msg.setRecipients(Message.RecipientType.CC, jTextFieldCC.getText());
            
            if(jTextFieldCCO.getText() != "")
                msg.setRecipients(Message.RecipientType.BCC, jTextFieldCCO.getText());
            
            //Se añade el encabezado
            msg.setSubject(jTextFieldEncabezado.getText());
            //Se crea un objeto fecha en ese instante y se añade al mensaje
            msg.setSentDate(new Date());

            
            //se divide el contenido del mensaje en una parte y el archivo en otra
            
            //Cuerpo del mensaje
            messageBodyPart = new MimeBodyPart();
            messageBodyPart.setText(jTextAreaContenido.getText());
            
            //objeto multipart divide el mensaje en varias partes
            multipart = new MimeMultipart();
            
            //se añade el cuerpo del mensaje al multipart
            multipart.addBodyPart(messageBodyPart);
            
            
            //lógica para enviar archivo
            //Solo se ejecuta esta parte si se ha cargado un archivo
            //es decir, si la variable path lleva a un archivo
            if(path != ""){
                //se crea otra sección del mensaje ahora con el archivo
                messageBodyPart = new MimeBodyPart();
                DataSource source = new FileDataSource(path);
                messageBodyPart.setDataHandler(new DataHandler(source));
                messageBodyPart.setFileName(path);
                //se añade al multipart
                multipart.addBodyPart(messageBodyPart);
            }
            
            //se añade el multipart al mensaje
            msg.setContent(multipart);
            
            //Se envía el mensake
            Transport.send(msg, usuario, contraseña);
            
            JOptionPane.showMessageDialog(this, "Enviado exitosamente");
            
        } catch (MessagingException mex) {
            System.out.println("Algo falló :( \n excepción: " + mex);
            JOptionPane.showMessageDialog(this, "Algo falló :( \n excepción: " + mex);
        }
    }//GEN-LAST:event_jButtonEnviarActionPerformed

    private void jButtonArchivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonArchivoActionPerformed
        //File chooser se crea y se abre para elegir el archivo
        JFileChooser fc = new JFileChooser();
        fc.showOpenDialog(this);
        
        //Se guarda en un objeto File y se saca su path
        File archivo = fc.getSelectedFile();
        path = archivo.getPath();
        System.out.println(path);
        
        jLabelPath.setText(path);
    }//GEN-LAST:event_jButtonArchivoActionPerformed

    private void jButtonAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAtrasActionPerformed
        this.setVisible(false);
        login.setVisible(true);
    }//GEN-LAST:event_jButtonAtrasActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JFramePrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFramePrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFramePrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFramePrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonArchivo;
    private javax.swing.JButton jButtonAtras;
    private javax.swing.JButton jButtonEnviar;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabelPath;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextAreaContenido;
    private javax.swing.JTextField jTextFieldCC;
    private javax.swing.JTextField jTextFieldCCO;
    private javax.swing.JTextField jTextFieldEncabezado;
    private javax.swing.JTextField jTextFieldPara;
    // End of variables declaration//GEN-END:variables
}
