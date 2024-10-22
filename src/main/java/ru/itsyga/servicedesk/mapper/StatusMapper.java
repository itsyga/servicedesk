package ru.itsyga.servicedesk.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.itsyga.servicedesk.dto.StatusRequestPayload;
import ru.itsyga.servicedesk.dto.StatusResponsePayload;
import ru.itsyga.servicedesk.entity.Status;

@Mapper(componentModel = "spring")
public interface StatusMapper {
    @Mapping(target = "id", ignore = true)
    Status toEntity(StatusRequestPayload requestPayload);
    StatusResponsePayload toDto(Status status);
}
