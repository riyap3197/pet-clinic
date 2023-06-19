package sprinkframework.petclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import sprinkframework.petclinic.model.Visit;

public interface VisitRepository extends CrudRepository<Visit, Long> {
}
