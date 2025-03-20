package id.my.hendisantika.firebaseauth.endpoint;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-firebase-auth
 * User: hendisantika
 * Link: s.id/hendisantika
 * Email: hendisantika@yahoo.co.id
 * Telegram : @hendisantika34
 * Date: 21/03/25
 * Time: 06.25
 * To change this template use File | Settings | File Templates.
 */
@RestController
@RequestMapping("public")
public class PublicEndpoints {
    @GetMapping("test")
    ResponseEntity<String> getPublic() {
        return ResponseEntity.ok("OK");
    }
}
