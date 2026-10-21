package id.my.hendisantika.firebaseauth.config;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-firebase-auth
 * User: hendisantika
 * Link: s.id/hendisantika
 * Email: hendisantika@yahoo.co.id
 * Telegram : @hendisantika34
 * Date: 21/03/25
 * Time: 06.23
 * To change this template use File | Settings | File Templates.
 */
@Slf4j
@Configuration
public class FirebaseConfig {

    private static final String SERVICE_ACCOUNT_PATH = "src/main/resources/notifikasi-270506-firebase-adminsdk-yhyuu-474a5f1795.json";

    @PostConstruct
    public void initialize() {
        if (!Files.exists(Path.of(SERVICE_ACCOUNT_PATH))) {
            log.warn("Firebase service account file not found at {}, skipping Firebase initialization", SERVICE_ACCOUNT_PATH);
            return;
        }
        try (FileInputStream serviceAccount = new FileInputStream(SERVICE_ACCOUNT_PATH)) {
            FirebaseOptions options = new FirebaseOptions.Builder()
                    .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                    .build();

            if (FirebaseApp.getApps().isEmpty()) {
                FirebaseApp.initializeApp(options);
            }
        } catch (IOException e) {
            throw new RuntimeException("Firebase initialization failed", e);
        }
    }
}
