package sprinkframework.petclinic.services;

import sprinkframework.petclinic.model.Owner;


public interface OwnerService extends CrudService<Owner, Long> {

    Owner findByLastName(String lastName);

}
