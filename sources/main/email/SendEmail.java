package email;


 
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;

public class SendEmail
{
  public static void main(String [] args)
  {    
     // Recipient's email ID needs to be mentioned.
     String to = "pintojoey@gmail.com";

     // Sender's email ID needs to be mentioned
     String from = "tulsi";
     final String username = "2013kucp1021@iiitkota.ac.in";
     final String password= "iiitk2013";
     //String username ="2013kucp1024@iiitkota.ac.in";
    // String password="iiitk1024";
     // Assuming you are sending email from localhost
     String host = "smtp.gmail.com";

     // Get system properties
     Properties properties = System.getProperties();

     // Setup mail server
     properties.setProperty("mail.smtp.host", host);
     properties.setProperty("mail.smtp.port", "587");
     properties.setProperty("mail.smtp.auth", "true");
     properties.setProperty("mail.smtp.starttls.enable","true");

     // Get the default Session object.
     Session session = Session.getInstance(properties, new javax.mail.Authenticator(){
    	 protected PasswordAuthentication getPasswordAuthentication(){
    		 return new PasswordAuthentication(username,password);
    	 }
    	 
    	 });

     try{
        // Create a default MimeMessage object.
        MimeMessage message = new MimeMessage(session);

        // Set From: header field of the header.
        message.setFrom(new InternetAddress(from));

        // Set To: header field of the header.
        message.addRecipients(Message.RecipientType.TO,  InternetAddress.parse(to));

        // Set Subject: header field
        message.setSubject("This is the Subject Line!");

        // Now set the actual message
        message.setText("This is actual message");
        
        // Create the message part 
        BodyPart messageBodyPart = new MimeBodyPart();
        

        // Fill the message
        messageBodyPart.setText("This is message body");
        
        // Create a multipar message
        Multipart multipart = new MimeMultipart();

        // Set text message part
        multipart.addBodyPart(messageBodyPart);

        // Part two is attachment
        messageBodyPart = new MimeBodyPart();
        String filename = "file.txt";
        DataSource source = new FileDataSource(filename);
        messageBodyPart.setDataHandler(new DataHandler(source));
        messageBodyPart.setFileName(filename);
        multipart.addBodyPart(messageBodyPart);

        // Send the complete message parts
        message.setContent(multipart );
        // Send message
        Transport.send(message);
        System.out.println("Sent message successfully....");
     }catch (MessagingException mex) {
        mex.printStackTrace();
     }
  }
}

