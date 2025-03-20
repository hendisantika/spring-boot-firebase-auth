package id.my.hendisantika.firebaseauth.auth;

import id.my.hendisantika.firebaseauth.util.CookieUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-firebase-auth
 * User: hendisantika
 * Link: s.id/hendisantika
 * Email: hendisantika@yahoo.co.id
 * Telegram : @hendisantika34
 * Date: 21/03/25
 * Time: 06.18
 * To change this template use File | Settings | File Templates.
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class SecurityFilter extends OncePerRequestFilter {

    private final SecurityService securityService;

    private final SecurityProperties restSecProps;

    private final CookieUtils cookieUtils;

    private final SecurityProperties securityProps;

}
