package sprinkframework.petclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import sprinkframework.petclinic.model.Owner;

public interface OwnerRepository extends CrudRepository<Owner, Long> {
}
