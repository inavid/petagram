package com.dfuentes.petgram;

import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Formulario extends AppCompatActivity {

    EditText nombre;
    EditText correo;
    EditText mensaje;
    Button enviar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

    }

    public void enviarComentario(View v){
        String nombre = ((EditText)findViewById(R.id.etNombre)).getText().toString();

        String correo = ((EditText)findViewById(R.id.etCorreo)).getText().toString();

        String mensaje = ((EditText)findViewById(R.id.etMensaje)).getText().toString();

        Properties props = new Properties();

        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication("inavid.divarolas@gmail.com", "@1Navid@");
                    }
                });

        String subject = "Petagram mensaje de prueba a "+nombre;

        try {
            MimeMessage msg = new MimeMessage(session);
            msg.setFrom("inavid.divarolas@gmail.com");
            msg.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse("inavid.divarolas@gmail"));
            msg.addRecipient(Message.RecipientType.CC, new InternetAddress(
                    correo));
            msg.setSubject(subject);
            msg.setSentDate(new Date());
            msg.setText(mensaje);
            Transport.send(msg);
        } catch (MessagingException mex) {
            System.out.println("send failed, exception: " + mex);
        }
    }
}
