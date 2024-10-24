package ru.itsyga.servicedesk.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedModel;
import org.springframework.stereotype.Service;
import ru.itsyga.servicedesk.dto.category.CategoryRequestPayload;
import ru.itsyga.servicedesk.dto.category.CategoryResponsePayload;
import ru.itsyga.servicedesk.mapper.CategoryMapper;
import ru.itsyga.servicedesk.repository.CategoryRepository;
import ru.itsyga.servicedesk.specification.CategorySpecification;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryMapper mapper;
    private final CategoryRepository categoryRepository;
    private final CategorySpecification categorySpecification;

    public PagedModel<CategoryResponsePayload> findAll(String name, Short targetHours, Pageable pageable) {
        var specification = categorySpecification.build(name, targetHours);
        return new PagedModel<>(categoryRepository
                .findAll(specification, pageable)
                .map(mapper::toDto));
    }

    public CategoryResponsePayload save(CategoryRequestPayload payload) {
        var category = categoryRepository.save(mapper.toEntity(payload));
        return mapper.toDto(category);
    }
}
