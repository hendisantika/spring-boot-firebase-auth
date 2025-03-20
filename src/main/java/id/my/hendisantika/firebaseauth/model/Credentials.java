package id.my.hendisantika.firebaseauth.model;

import com.google.firebase.auth.FirebaseToken;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-firebase-auth
 * User: hendisantika
 * Link: s.id/hendisantika
 * Email: hendisantika@yahoo.co.id
 * Telegram : @hendisantika34
 * Date: 21/03/25
 * Time: 06.22
 * To change this template use File | Settings | File Templates.
 */
@Data
@AllArgsConstructor
public class Credentials {

    private CredentialType type;
    private FirebaseToken decodedToken;
    private String idToken;
    private String session;
    public enum CredentialType {
        ID_TOKEN, SESSION
    }
}
