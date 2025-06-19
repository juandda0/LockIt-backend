package org.juannn.lockit.aplication.shared.mapper;

import org.juannn.lockit.aplication.core.domain.model.Password;
import org.juannn.lockit.aplication.infrastructure.adapter.out.persistence.password.PasswordJpaEntity;
import org.juannn.lockit.aplication.shared.dto.password.PasswordRequest;
import org.juannn.lockit.aplication.shared.dto.password.PasswordResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PasswordMapper {

    // DTOs <-> Dominio
    @Mapping(target = "id", ignore = true)
    Password toDomain(PasswordRequest userRequest);
    PasswordResponse toResponse(Password password);

    // Domain <-> JPA
    PasswordJpaEntity toJpaEntity(Password password);
    Password toDomain(PasswordJpaEntity passwordJpaEntity);
}
