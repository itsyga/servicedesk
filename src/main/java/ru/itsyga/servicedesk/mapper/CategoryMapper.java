package ru.itsyga.servicedesk.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.itsyga.servicedesk.dto.category.CategoryRequestPayload;
import ru.itsyga.servicedesk.dto.category.CategoryResponsePayload;
import ru.itsyga.servicedesk.entity.Category;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "questions", ignore = true)
    Category toEntity(CategoryRequestPayload requestPayload);
    CategoryResponsePayload toDto(Category category);
}
