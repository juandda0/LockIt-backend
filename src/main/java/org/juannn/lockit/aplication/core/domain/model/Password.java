package org.juannn.lockit.aplication.core.domain.model;

import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Table
@Getter
@Setter
public class Password {
    private String generatedPassword;
}
