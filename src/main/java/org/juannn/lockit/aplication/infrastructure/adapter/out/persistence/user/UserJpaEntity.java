package org.juannn.lockit.aplication.infrastructure.adapter.out.persistence.user;

import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import org.juannn.lockit.aplication.infrastructure.adapter.out.persistence.password.PasswordJpaEntity;

@Entity
@Table(name = "Users")
public class UserJpaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false, unique = true) // Agregamos unique para el username
    private String username;

    @Column(nullable = false, unique = true) // Agregamos unique para el email
    private String email;

    @Column(nullable = false)
    private String password;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private Set<PasswordJpaEntity> passwords = new HashSet<>();

    public UserJpaEntity() {
    }

    public UserJpaEntity(UUID id, String username, String email, String password) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public UserJpaEntity(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<PasswordJpaEntity> getPasswords() {
        return passwords;
    }

    public void setPasswords(Set<PasswordJpaEntity> passwords) {
        this.passwords = passwords;
    }

    public void addPassword(PasswordJpaEntity password) {
        this.passwords.add(password);
        password.setUser(this);
    }

    public void removePassword(PasswordJpaEntity password) {
        this.passwords.remove(password);
        password.setUser(null);
    }
}