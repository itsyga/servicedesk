package ru.itsyga.servicedesk.dto.category;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CategoryResponsePayload {
    private Integer id;
    private String name;
    private Short targetHours;
}
