package ru.itsyga.servicedesk.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "feedback")
public class Feedback {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "feedback_id_seq")
    @SequenceGenerator(name = "feedback_id_seq", sequenceName = "feedback_id_seq")
    @Column(name = "id", nullable = false, unique = true)
    private Integer id;

    @Column(name = "type", length = 30, nullable = false, unique = true)
    private String type;
}
