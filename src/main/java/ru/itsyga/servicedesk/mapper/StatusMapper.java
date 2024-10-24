package ru.itsyga.servicedesk.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.itsyga.servicedesk.dto.status.StatusRequestPayload;
import ru.itsyga.servicedesk.dto.status.StatusResponsePayload;
import ru.itsyga.servicedesk.entity.Status;

@Mapper(componentModel = "spring")
public interface StatusMapper {
    @Mapping(target = "id", ignore = true)
    Status toEntity(StatusRequestPayload requestPayload);
    StatusResponsePayload toDto(Status status);
}
