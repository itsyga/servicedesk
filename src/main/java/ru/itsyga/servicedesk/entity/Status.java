package ru.itsyga.servicedesk.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "status")
public class Status {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "status_id_seq")
    @SequenceGenerator(name = "status_id_seq", sequenceName = "status_id_seq")
    @Column(name = "id", nullable = false, unique = true)
    private Integer id;

    @Column(name = "name", length = 50)
    private String name;
}
