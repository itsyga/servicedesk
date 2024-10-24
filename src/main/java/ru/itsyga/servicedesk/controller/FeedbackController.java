package ru.itsyga.servicedesk.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import ru.itsyga.servicedesk.dto.feedback.FeedbackRequestPayload;
import ru.itsyga.servicedesk.dto.feedback.FeedbackResponsePayload;
import ru.itsyga.servicedesk.service.FeedbackService;

import java.util.List;

@RestController
@RequestMapping("/api/feedbacks")
@RequiredArgsConstructor
public class FeedbackController {
    private final FeedbackService feedbackService;

    @GetMapping
    public ResponseEntity<List<FeedbackResponsePayload>> getAll() {
        return ResponseEntity.ok(feedbackService.findAll());
    }

    @PostMapping
    public ResponseEntity<FeedbackResponsePayload> create(@Valid @RequestBody FeedbackRequestPayload payload,
                                                          BindingResult result, UriComponentsBuilder builder) throws BindException {
        if (result.hasErrors()) throw new BindException(result);
        var feedbackResponse = feedbackService.save(payload);
        return ResponseEntity.created(builder
                        .path("/api/feedbacks/{id}")
                        .build(feedbackResponse.getId()))
                .body(feedbackResponse);
    }
}
