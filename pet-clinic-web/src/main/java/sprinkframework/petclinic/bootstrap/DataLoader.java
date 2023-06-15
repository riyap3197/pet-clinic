package sprinkframework.petclinic.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import sprinkframework.petclinic.model.Owner;
import sprinkframework.petclinic.model.Pet;
import sprinkframework.petclinic.model.PetType;
import sprinkframework.petclinic.model.Vet;
import sprinkframework.petclinic.services.OwnerService;
import sprinkframework.petclinic.services.PetTypeService;
import sprinkframework.petclinic.services.VetService;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {

        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);

        Owner owner1 = new Owner();
        owner1.setFirstName("John");
        owner1.setLastName("Wick");
        owner1.setAddress("123 Heaven");
        owner1.setCity("Toronto");
        owner1.setTelephone("5198789098");

        Pet johnsPet = new Pet();
        johnsPet.setPetType(savedDogPetType);
        johnsPet.setOwner(owner1);
        johnsPet.setBirthdate(LocalDate.now());
        johnsPet.setName("Daisy");
        owner1.getPet().add(johnsPet);
        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Riya");
        owner2.setLastName("Patel");
        owner2.setAddress("4 Bridle Path");
        owner2.setCity("Toronto");
        owner2.setTelephone("5199763542");

        Pet riyasPet = new Pet();
        riyasPet.setPetType(savedCatPetType);
        riyasPet.setOwner(owner2);
        riyasPet.setBirthdate(LocalDate.now());
        riyasPet.setName("Simba");
        owner2.getPet().add(riyasPet);
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
