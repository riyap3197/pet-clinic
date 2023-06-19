package sprinkframework.petclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import sprinkframework.petclinic.model.Vet;

public interface VetRepository extends CrudRepository<Vet, Long> {
}
