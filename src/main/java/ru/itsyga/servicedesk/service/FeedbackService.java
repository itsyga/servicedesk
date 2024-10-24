package ru.itsyga.servicedesk.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.itsyga.servicedesk.dto.feedback.FeedbackRequestPayload;
import ru.itsyga.servicedesk.dto.feedback.FeedbackResponsePayload;
import ru.itsyga.servicedesk.mapper.FeedbackMapper;
import ru.itsyga.servicedesk.repository.FeedbackRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FeedbackService {
    private final FeedbackMapper mapper;
    private final FeedbackRepository feedbackRepository;

    public List<FeedbackResponsePayload> findAll() {
        return feedbackRepository.findAll().stream()
                .map(mapper::toDto)
                .toList();
    }

    public FeedbackResponsePayload save(FeedbackRequestPayload payload) {
        var feedback = feedbackRepository.save(mapper.toEntity(payload));
        return mapper.toDto(feedback);
    }
}
