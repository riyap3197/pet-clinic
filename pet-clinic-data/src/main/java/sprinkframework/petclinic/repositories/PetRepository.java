package sprinkframework.petclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import sprinkframework.petclinic.model.Pet;

public interface PetRepository extends CrudRepository<Pet, Long> {
}
