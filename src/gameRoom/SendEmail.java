package gameRoom;
import java.util.Properties;
import  javax.mail.Message;
import javax.mail.BodyPart;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.SendFailedException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class SendEmail  {
	public static void main(String[] args)throws MessagingException{ // 

        String host = "smtp.gmail.com";
        String password = "bonjour123";
        String from = "gameroomAUB@gmail.com";
        String toAddress = args[0];


        Properties properties = System.getProperties();
        properties.put("mail.transport.protocol", "smtp");
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port",587 );
        properties.put("mail.smtp.auth", true);
        properties.put("mail.smtp.starttls.enable", true);
        Session session = Session.getInstance(properties, null);

        MimeMessage message = new MimeMessage(session);
        message.setFrom(new InternetAddress(from));
        message.setRecipients(Message.RecipientType.TO, toAddress);
        message.setSubject("GameRoom");
        BodyPart messageBodyPart = new MimeBodyPart();
        messageBodyPart.setText("Hello " + args[1] + ",\n"
        		+ "We are glad you are so eager to access our GAMEROOM again!\n"
        		+ "Your new password is: " + args[2] + "\n"
        		+ "Now you can go on and discover our Latest Games again :)\n"
        		+ "\n"
        		+"Regards\n"
        		+"Your Favorite GameRoom\n"
                
        );

        Multipart multipart = new MimeMultipart();
        multipart.addBodyPart(messageBodyPart);
        message.setContent(multipart);

        try{

            Transport transport = session.getTransport("smtp");

            transport.connect(host,from, password);
            transport.sendMessage(message, message.getAllRecipients());
            System.out.println("Mail Sent Successfully");
            transport.close();
        } catch (SendFailedException sfe){
            System.out.println("ss");
            System.out.println(sfe);
        }
    }
	
}