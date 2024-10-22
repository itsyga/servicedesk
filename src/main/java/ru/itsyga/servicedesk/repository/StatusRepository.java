package ru.itsyga.servicedesk.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itsyga.servicedesk.entity.Status;

public interface StatusRepository extends JpaRepository<Status, Integer> {
}
