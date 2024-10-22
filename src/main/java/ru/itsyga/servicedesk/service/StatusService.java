package ru.itsyga.servicedesk.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.itsyga.servicedesk.dto.StatusRequestPayload;
import ru.itsyga.servicedesk.dto.StatusResponsePayload;
import ru.itsyga.servicedesk.mapper.StatusMapper;
import ru.itsyga.servicedesk.repository.StatusRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StatusService {
    private final StatusMapper statusMapper;
    private final StatusRepository statusRepository;

    public List<StatusResponsePayload> findAll() {
        return statusRepository.findAll().stream()
                .map(statusMapper::toDto)
                .toList();
    }

    public StatusResponsePayload save(StatusRequestPayload payload) {
        var status = statusRepository.save(statusMapper.toEntity(payload));
        return statusMapper.toDto(status);
    }
}
