# Spring Boot Firebase Authentication

[![Java CI with Maven](https://github.com/hendisantika/spring-boot-firebase-auth/actions/workflows/maven.yml/badge.svg)](https://github.com/hendisantika/spring-boot-firebase-auth/actions/workflows/maven.yml)
![Java](https://img.shields.io/badge/Java-25-orange)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-4.1.1-brightgreen)

A comprehensive Spring Boot application demonstrating secure user authentication and authorization using Firebase Auth
with session-based security.

## 🚀 Features

- **Firebase Authentication Integration**: Complete JWT token validation and user management
- **Session-based Security**: Secure cookie-based session management with Spring Security
- **Public & Private Endpoints**: Role-based access control for different API endpoints
- **Database Integration**: H2 in-memory database with JPA support (MySQL ready)
- **CORS Configuration**: Proper cross-origin resource sharing setup
- **RESTful API**: Clean REST endpoints for authentication and user management
- **Frontend Integration**: Sample HTML/JavaScript login form

## 🛠️ Technology Stack

- **Java 25** - Latest LTS version
- **Spring Boot 4.1.1** - Main framework
- **Jackson 3** - JSON serialization (Spring Boot 4 default)
- **Spring Security** - Authentication & authorization
- **Spring Data JPA** - Database operations
- **Firebase Admin SDK 9.11.0** - Firebase integration
- **H2 Database** - In-memory database (development)
- **MySQL** - Production database support
- **Maven 3.10 (wrapper)** - Build tool
- **Lombok** - Code generation

## 📋 Prerequisites

- Java 25 or higher
- Maven 3.10+ (or use the bundled `./mvnw` wrapper)
- Firebase project with Authentication enabled
- Firebase service account key

## ⚙️ Configuration

### 1. Firebase Setup

1. Create a Firebase project at [Firebase Console](https://console.firebase.google.com/)
2. Enable Authentication with Email/Password
3. Generate a service account key:
    - Go to Project Settings → Service Accounts
    - Generate new private key
    - Save as `src/main/resources/notifikasi-270506-firebase-adminsdk-*.json`

> ⚠️ The service account key is a secret. Never commit it to Git. If the key file is missing (for example in CI),
> the application still starts but skips Firebase initialization and logs a warning.

### 2. Application Configuration

Update `src/main/resources/application.yml`:

```yaml
security:
  firebase-props:
    database-url: ${FIREBASE_DATABASE:your-project.firebasestorage.app}
  cookie-props:
    domain: ${DOMAIN:your-project.firebaseapp.com}
  allowed-origins:
    - https://${DOMAIN:your-project.firebaseapp.com}
    - http://localhost:3000
```

### 3. Frontend Configuration

Update `index.html` with your Firebase config:

```javascript
var firebaseConfig = {
    apiKey: "your-api-key",
    authDomain: "your-project.firebaseapp.com",
    projectId: "your-project-id",
    // ... other config
};
```

## 🏃‍♂️ Running the Application

### Using Maven

```bash
# Clone the repository
git clone <repository-url>
cd spring-boot-firebase-auth

# Run the application
./mvnw spring-boot:run
```

### Using JAR

```bash
# Build the application
./mvnw clean package

# Run the JAR
java -jar target/firebase-auth-0.0.1-SNAPSHOT.jar
```

The application will start on `http://localhost:8080`

## 🔌 API Endpoints

### Public Endpoints

| Method | Endpoint         | Description        |
|--------|------------------|--------------------|
| GET    | `/public/test`   | Test public access |
| GET    | `/favicon.ico`   | Favicon            |
| POST   | `/session/login` | User login         |

### Private Endpoints (Requires Authentication)

| Method | Endpoint                | Description                    |
|--------|-------------------------|--------------------------------|
| GET    | `/private/user-details` | Get authenticated user details |

## 🔐 Authentication Flow

1. **Frontend Login**: User enters credentials in `index.html`
2. **Firebase Auth**: Frontend authenticates with Firebase
3. **Token Exchange**: Send Firebase ID token to `/session/login`
4. **Session Creation**: Backend validates token and creates secure session
5. **API Access**: Use session cookie for subsequent API calls

### Sample Authentication Response

```json
{
  "kind": "identitytoolkit#VerifyPasswordResponse",
  "localId": "user-unique-id",
  "email": "user@example.com",
  "displayName": "",
  "idToken": "eyJhbGciOiJSUzI1NiIs...",
  "registered": true,
  "refreshToken": "AMf-vBxkMD_s8HHq...",
  "expiresIn": "3600"
}
```

## 📁 Project Structure

```
src/
├── main/
│   ├── java/id/my/hendisantika/firebaseauth/
│   │   ├── auth/              # Security configuration
│   │   │   ├── SecurityConfig.java
│   │   │   ├── SecurityFilter.java
│   │   │   └── SecurityService.java
│   │   ├── config/            # Application configuration
│   │   │   ├── FirebaseConfig.java
│   │   │   └── SpringConfig.java
│   │   ├── endpoint/          # REST controllers
│   │   │   ├── PublicEndpoints.java
│   │   │   └── PrivateEndpoint.java
│   │   ├── model/             # Data models
│   │   │   ├── User.java
│   │   │   ├── Credentials.java
│   │   │   └── *Properties.java
│   │   ├── util/              # Utilities
│   │   │   └── CookieUtils.java
│   │   └── SpringBootFirebaseAuthApplication.java
│   └── resources/
│       ├── application.yml    # Configuration
│       └── notifikasi-*-firebase-adminsdk-*.json  # Firebase service account (not committed)
├── test/
└── index.html                 # Sample frontend
```

## 🛡️ Security Features

- **JWT Token Validation**: Secure Firebase token verification
- **Session Management**: HTTP-only, secure cookies
- **CORS Protection**: Configurable allowed origins
- **CSRF Protection**: Built-in Spring Security CSRF
- **Path-based Security**: Public/private endpoint separation

## 🔧 Development

### Database

- **Development**: H2 in-memory database (auto-configured)
- **Production**: MySQL support (uncomment in `application.yml`)

### Testing

```bash
./mvnw test
```

### Building

```bash
./mvnw clean package
```

## ⚙️ CI/CD & Dependency Management

- **GitHub Actions** (`.github/workflows/maven.yml`): builds and tests every push and pull request to `main` on
  Temurin JDK 25, then submits the Maven dependency graph for better Dependabot alerts.
- **Dependabot** (`.github/dependabot.yml`):
    - **Maven** (daily, 05:00 Asia/Jakarta): updates `pom.xml` and the Maven wrapper, with grouped PRs for Spring,
      Firebase, Maven plugins and other minor/patch updates.
    - **GitHub Actions** (weekly, Monday): all action bumps grouped into a single PR.
    - Commit messages follow Conventional Commits (`build(deps): ...`, `ci(deps): ...`) and PRs are labelled
      automatically.

## 📱 Frontend Usage

1. Open `index.html` in a browser
2. Enter email and password
3. Click "Login" to authenticate
4. Use the session for API calls

## 🖼️ Screenshots

| Public Endpoint           | Private Endpoint            | Web Interface       |
|---------------------------|-----------------------------|---------------------|
| ![Public](img/public.png) | ![Private](img/private.png) | ![Web](img/web.png) |

## 🐳 Docker Support

```dockerfile
FROM eclipse-temurin:25-jre
COPY target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app.jar"]
```

## 📝 Environment Variables

| Variable            | Description           | Default                                 |
|---------------------|-----------------------|-----------------------------------------|
| `FIREBASE_DATABASE` | Firebase database URL | `notifikasi-270506.firebasestorage.app` |
| `DOMAIN`            | Application domain    | `notifikasi-270506.firebaseapp.com`     |

## 🤝 Contributing

1. Fork the repository
2. Create a feature branch
3. Commit your changes
4. Push to the branch
5. Create a Pull Request

## 📄 License

This project is licensed under the MIT License.

## 👤 Author

**Hendi Santika**

- Email: hendisantika@yahoo.co.id
- Telegram: @hendisantika34
- Link: [s.id/hendisantika](https://s.id/hendisantika)

## 🔗 Useful Links

- [Firebase Console](https://console.firebase.google.com/)
- [Spring Boot Documentation](https://docs.spring.io/spring-boot/docs/current/reference/html/)
- [Firebase Admin SDK](https://firebase.google.com/docs/admin/setup)