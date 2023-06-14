package sprinkframework.petclinic.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import sprinkframework.petclinic.model.Owner;
import sprinkframework.petclinic.model.Vet;
import sprinkframework.petclinic.services.OwnerService;
import sprinkframework.petclinic.services.VetService;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoader(OwnerService ownerService, VetService vetService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
    }

    @Override
    public void run(String... args) throws Exception {
        Owner owner1 = new Owner();
        owner1.setFirstName("John");
        owner1.setLastName("Wick");

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Riya");
        owner2.setLastName("Patel");

        ownerService.save(owner2);
        System.out.println("Loaded Owners...");

        Vet vet1 = new Vet();
        vet1.setFirstName("Urvish");
        vet1.setLastName("Tank");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Phil");
        vet2.setLastName("Dunphy");

        vetService.save(vet2);

        System.out.println("Loaded Vets...");
    }
}
