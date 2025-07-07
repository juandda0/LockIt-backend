package org.juannn.lockit.aplication.shared.mapper;


import org.juannn.lockit.aplication.core.domain.model.User;
import org.juannn.lockit.aplication.infrastructure.adapter.out.persistence.user.UserJpaEntity;
import org.juannn.lockit.aplication.shared.dto.user.UserRegistrationRequest;
import org.juannn.lockit.aplication.shared.dto.user.UserRegistrationResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper {

    // DTOs <-> Dominio
    @Mapping(target = "id", ignore = true)
    User toDomain(UserRegistrationRequest userRequest);
    UserRegistrationResponse toResponse(User user);

    // Dominio <-> Entidad JPA
    UserJpaEntity toJpaEntity(User user);

    User toDomain(UserJpaEntity userJpaEntity);
}
