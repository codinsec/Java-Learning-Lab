package com.learning.lab.dto;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * MapStruct mapper for User entity and DTOs
 */
@Mapper(componentModel = "spring")
public interface UserMapper {
    // Map entity to response DTO (excludes password)
    @Mapping(target = "password", ignore = true)
    UserResponseDTO toResponseDTO(User user);
    
    // Map request DTO to entity
    User toEntity(UserRequestDTO dto);
}

