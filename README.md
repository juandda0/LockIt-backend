# 🔐 LockIt - Backend

**LockIt** es una aplicación segura de gestión de contraseñas. Permite a los usuarios **generar contraseñas seguras** de 12 a 14 caracteres que incluyen letras mayúsculas, minúsculas, símbolos y números, y además **almacenarlas de forma segura**.  
Este repositorio corresponde al **backend**, desarrollado en Java 17 con Spring Boot y PostgreSQL, usando JWT para autenticación y una arquitectura **hexagonal** que aplica buenas prácticas de desarrollo.

---

## 🛠️ Tecnologías

- Java 17
- Spring Boot
- PostgreSQL
- Spring Data JPA
- Spring Security (JWT)
- MapStruct
- Dotenv (para variables de entorno)
- Arquitectura Hexagonal

---

## ⚙️ Dependencias (Gradle)

```groovy
implementation 'org.springframework.boot:spring-boot-starter'
implementation 'org.springframework.boot:spring-boot-starter-web'
implementation 'org.postgresql:postgresql'
implementation 'org.springframework.boot:spring-boot-starter-data-jpa'
implementation 'io.github.cdimascio:dotenv-java:3.0.0'
implementation 'org.springframework.boot:spring-boot-starter-security'
implementation 'org.mapstruct:mapstruct:1.6.3'
annotationProcessor 'org.mapstruct:mapstruct-processor:1.6.3'
developmentOnly 'org.springframework.boot:spring-boot-devtools'
