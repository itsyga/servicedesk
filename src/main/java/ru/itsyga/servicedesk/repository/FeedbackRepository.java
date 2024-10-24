package ru.itsyga.servicedesk.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itsyga.servicedesk.entity.Feedback;

public interface FeedbackRepository extends JpaRepository<Feedback, Integer> {
}
