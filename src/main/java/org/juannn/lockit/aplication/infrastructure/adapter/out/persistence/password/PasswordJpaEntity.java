package org.juannn.lockit.aplication.infrastructure.adapter.out.persistence.password;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Passwords")
public class PasswordJpaEntity {

    @Id
    private Long id;

    @Column(nullable = false)
    private String generatedPassword;
}
