/***
 * Add the following stuff to Maven pom.xml
 * <dependency>
 *  <groupId>com.twilio.sdk</groupId>
 *  <artifactId>twilio</artifactId>
 *  <version>7.36.1</version>
 * </dependency>
 */

import org.springframework.beans.factory.annotation.Value;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

public class SMSService{
    //Write the following at application.properties
    @Value("${PHONE_NUMBER}")
    private String PHONE_NUMBER; //The Phone Number
    
    @Value("${Twlio_Account}")
    private String Twlio_Account;

    @Value("${AUTH_TOKEN}")
    private String AUTH_TOKEN;

    
    public void sendMessage(String targetPhone){
        Twilio.init(Twlio_Account, AUTH_TOKEN);
        Message message = Message.creator(
            new PhoneNumber(targetPhone),
            new PhoneNumber(PHONE_NUMBER),
            "You have a scheduled blood test"
        ).create();
    }
}