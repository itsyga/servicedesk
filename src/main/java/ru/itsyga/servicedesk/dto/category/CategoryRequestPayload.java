package ru.itsyga.servicedesk.dto.category;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CategoryRequestPayload {
    @NotBlank(message = "Field 'name' can't be blank or null")
    private String name;
    @Min(value = 1, message = "Field 'targetHours' can't below one")
    @NotNull(message = "Field 'targetHours' can't be null")
    private Short targetHours;
}
