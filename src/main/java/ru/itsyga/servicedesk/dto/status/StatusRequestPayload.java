package ru.itsyga.servicedesk.dto.status;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StatusRequestPayload {
    @NotBlank(message = "Field 'name' can't be blank or null")
    private String name;
}
