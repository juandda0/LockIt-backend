package org.juannn.lockit.aplication.shared.mapper;

import org.juannn.lockit.aplication.core.domain.model.Token;
import org.juannn.lockit.aplication.infrastructure.adapter.out.persistence.jwt.TokenJpaEntity;
import org.juannn.lockit.aplication.shared.dto.user.TokenResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface TokenMapper {

    // DTOs <-> Dominio
    Token toDomain(TokenJpaEntity tokenJpaEntity);

    TokenResponse toResponse(Token token);

    // Domain <-> JPA
    TokenJpaEntity toJpaEntity(Token token);

}
