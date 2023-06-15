package sprinkframework.petclinic.services.map;

import org.springframework.stereotype.Service;
import sprinkframework.petclinic.model.Owner;
import sprinkframework.petclinic.model.Pet;
import sprinkframework.petclinic.model.PetType;
import sprinkframework.petclinic.services.OwnerService;
import sprinkframework.petclinic.services.PetService;
import sprinkframework.petclinic.services.PetTypeService;

import java.util.Set;

@Service
public class OwnerServiceMap extends AbstractMapService<Owner, Long> implements OwnerService {

    private final PetTypeService petTypeService;
    private final PetService petService;

    public OwnerServiceMap(PetTypeService petTypeService, PetService petService) {
        this.petTypeService = petTypeService;
        this.petService = petService;
    }

    @Override
    public Set<Owner> findAll() {
        return super.findAll();
    }

    @Override
    public Owner findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Owner save(Owner object) {

        if(object != null){
            if(object.getPet() != null){
                object.getPet().forEach(pet -> {
                    if(pet.getPetType() != null){
                        pet.setPetType(petTypeService.save(pet.getPetType()));
                    }else {
                        throw new RuntimeException("Pet Type is required");
                    }

                    if(pet.getId() == null){
                        Pet savedPet = petService.save(pet);
                        pet.setId(savedPet.getId());
                    }
                });
            }
            return super.save(object);
        } else {
            return null;
        }
    }

    @Override
    public void delete(Owner object) {
        super.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public Owner findByLastName(String lastName) {
        return null;
    }
}
