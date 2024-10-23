package ru.itsyga.servicedesk.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.itsyga.servicedesk.dto.FeedbackRequestPayload;
import ru.itsyga.servicedesk.dto.FeedbackResponsePayload;
import ru.itsyga.servicedesk.entity.Feedback;

@Mapper(componentModel = "spring")
public interface FeedbackMapper {
    @Mapping(target = "id", ignore = true)
    Feedback toEntity(FeedbackRequestPayload requestPayload);
    FeedbackResponsePayload toDto(Feedback feedback);
}