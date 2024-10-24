package ru.itsyga.servicedesk.specification;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import ru.itsyga.servicedesk.entity.Category;
import ru.itsyga.servicedesk.entity.Category_;

@Component
public class CategorySpecification {

    public Specification<Category> build(String name, Short targetHours) {
        return Specification.allOf(withName(name), withTargetHours(targetHours));
    }

    private Specification<Category> withName(String name) {
        if (name == null || name.isEmpty()) return null;
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.like(root.get(Category_.name), name);
    }

    private Specification<Category> withTargetHours(Short targetHours) {
        if (targetHours == null) return null;
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.equal(root.get(Category_.targetHours), targetHours);
    }
}
