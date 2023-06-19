package sprinkframework.petclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import sprinkframework.petclinic.model.Speciality;

public interface SpecialityRepository extends CrudRepository<Speciality, Long> {
}
