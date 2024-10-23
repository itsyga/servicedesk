package ru.itsyga.servicedesk.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FeedbackRequestPayload {
    @NotBlank(message = "Field 'type' can't be blank or null")
    private String type;
}
