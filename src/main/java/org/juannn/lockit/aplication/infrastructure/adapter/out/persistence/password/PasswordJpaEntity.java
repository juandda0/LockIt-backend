package org.juannn.lockit.aplication.infrastructure.adapter.out.persistence.password;

import jakarta.persistence.*;
import java.util.UUID;
import org.juannn.lockit.aplication.infrastructure.adapter.out.persistence.user.UserJpaEntity; // Importa UserJpaEntity

@Entity
@Table(name = "Passwords")
public class PasswordJpaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String generatedPassword;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private UserJpaEntity user;

    public PasswordJpaEntity() {
    }

    public PasswordJpaEntity(UUID id, String name, String generatedPassword, UserJpaEntity user) {
        this.id = id;
        this.name = name;
        this.generatedPassword = generatedPassword;
        this.user = user;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGeneratedPassword() {
        return generatedPassword;
    }

    public void setGeneratedPassword(String generatedPassword) {
        this.generatedPassword = generatedPassword;
    }

    public UserJpaEntity getUser() {
        return user;
    }

    public void setUser(UserJpaEntity user) {
        this.user = user;
    }
}