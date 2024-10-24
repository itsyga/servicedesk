package ru.itsyga.servicedesk.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import ru.itsyga.servicedesk.dto.status.StatusRequestPayload;
import ru.itsyga.servicedesk.dto.status.StatusResponsePayload;
import ru.itsyga.servicedesk.service.StatusService;

import java.util.List;

@RestController
@RequestMapping("/api/statuses")
@RequiredArgsConstructor
public class StatusController {
    private final StatusService statusService;

    @GetMapping
    public ResponseEntity<List<StatusResponsePayload>> getAll() {
        return ResponseEntity.ok(statusService.findAll());
    }

    @PostMapping
    public ResponseEntity<StatusResponsePayload> create(@Valid @RequestBody StatusRequestPayload payload,
                                                        BindingResult result, UriComponentsBuilder builder) throws BindException {
        if (result.hasErrors()) throw new BindException(result);
        var statusResponsePayload = statusService.save(payload);
        return ResponseEntity.created(builder
                        .path("/api/statuses/{id}")
                        .build(statusResponsePayload.getId()))
                .body(statusResponsePayload);
    }
}
