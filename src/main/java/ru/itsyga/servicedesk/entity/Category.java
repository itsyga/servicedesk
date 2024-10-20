package ru.itsyga.servicedesk.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "category_id_seq")
    @SequenceGenerator(name = "category_id_seq", sequenceName = "category_id_seq")
    @Column(name = "id", nullable = false, unique = true)
    private Integer id;

    @Column(name = "name", length = 100, nullable = false, unique = true)
    private String name;

    @Column(name = "target_hours", nullable = false)
    private Short targetHours;

    @OneToMany(mappedBy = "category", orphanRemoval = true)
    private Set<Question> questions = new LinkedHashSet<>();
}
