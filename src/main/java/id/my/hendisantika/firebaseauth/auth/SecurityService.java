package id.my.hendisantika.firebaseauth.auth;

import id.my.hendisantika.firebaseauth.util.CookieUtils;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.stereotype.Service;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-firebase-auth
 * User: hendisantika
 * Link: s.id/hendisantika
 * Email: hendisantika@yahoo.co.id
 * Telegram : @hendisantika34
 * Date: 21/03/25
 * Time: 06.19
 * To change this template use File | Settings | File Templates.
 */
@Service
@RequiredArgsConstructor
public class SecurityService {

    private final HttpServletRequest httpServletRequest;

    private final CookieUtils cookieUtils;

    private final SecurityProperties securityProps;
}
