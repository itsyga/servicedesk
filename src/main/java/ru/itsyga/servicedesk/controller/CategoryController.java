package ru.itsyga.servicedesk.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.PagedModel;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import ru.itsyga.servicedesk.dto.category.CategoryRequestPayload;
import ru.itsyga.servicedesk.dto.category.CategoryResponsePayload;
import ru.itsyga.servicedesk.service.CategoryService;

@RestController
@RequestMapping("/api/categories")
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryService categoryService;

    @GetMapping
    public ResponseEntity<PagedModel<CategoryResponsePayload>> getAll(@RequestParam(required = false) String name,
                                                                      @RequestParam(required = false) Short targetHours,
                                                                      @PageableDefault(size = 20) Pageable pageable) {
        return ResponseEntity.ok(
                categoryService.findAll(name, targetHours, pageable)
        );
    }

    @PostMapping
    public ResponseEntity<CategoryResponsePayload> create(@Valid @RequestBody CategoryRequestPayload payload,
                                                          BindingResult bindingResult, UriComponentsBuilder builder) throws BindException {
        if (bindingResult.hasErrors()) throw new BindException(bindingResult);
        var categoryResponsePayload = categoryService.save(payload);
        return ResponseEntity.created(builder
                        .path("/api/categories/{id}")
                        .build(categoryResponsePayload.getId()))
                .body(categoryResponsePayload);
    }
}
