package sprinkframework.petclinic.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import sprinkframework.petclinic.model.*;
import sprinkframework.petclinic.services.OwnerService;
import sprinkframework.petclinic.services.PetTypeService;
import sprinkframework.petclinic.services.SpecialityService;
import sprinkframework.petclinic.services.VetService;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialityService specialityService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialityService specialityService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialityService = specialityService;
    }

    @Override
    public void run(String... args) throws Exception {

        int count = petTypeService.findAll().size();
        if(count == 0){
            loadData();
        }
    }

    private void loadData() {
        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);

        Speciality astronomy = new Speciality();
        astronomy.setDescription("Astronomy");
        Speciality savedAstronomy = specialityService.save(astronomy);

        Speciality radiology = new Speciality();
        radiology.setDescription("Radiology");
        Speciality savedRadiology= specialityService.save(radiology);

        Speciality dentistry = new Speciality();
        dentistry.setDescription("Dentistry");
        Speciality savedDentistry = specialityService.save(dentistry);

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
        vet1.getSpecialities().add(savedAstronomy);
        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Phil");
        vet2.setLastName("Dunphy");
        vet2.getSpecialities().add(savedRadiology);
        vetService.save(vet2);

        System.out.println("Loaded Vets...");
    }
}
