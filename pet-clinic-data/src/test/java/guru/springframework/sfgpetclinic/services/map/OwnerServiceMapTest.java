package guru.springframework.sfgpetclinic.services.map;

import guru.springframework.sfgpetclinic.model.Owner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class OwnerServiceMapTest {

    private final String lastName = "Smith";
    private final Long id = 1L;
    OwnerServiceMap ownerServiceMap;

    @BeforeEach
    void setUp() {
        ownerServiceMap = new OwnerServiceMap(new PetTypeServiceMap(), new PetServiceMap());


        ownerServiceMap.save(Owner.builder().id(id).lastName(lastName).build());
    }

    @Test
    void findAll() {
        Set<Owner> ownerSet = ownerServiceMap.findAll();

        assertEquals(1, ownerSet.size());
    }

    @Test
    void findByIdFound() {
        Owner owner = ownerServiceMap.findById(id);

        assertEquals(1L, owner.getId());
    }

    @Test
    void findByIdNotFound() {
        Owner owner = ownerServiceMap.findById(2L);

        assertNull(owner);
    }

    @Test
    void saveExistingId() {
        Owner toSave = Owner.builder().id(2L).build();

        Owner savedOwner = ownerServiceMap.save(toSave);

        assertEquals(2L, savedOwner.getId());
    }

    @Test
    void saveNotExistedId() {


        Owner save = ownerServiceMap.save(Owner.builder().build());

        assertNotNull(save);
        assertNotNull(save.getId());
    }

    @Test
    void delete() {
        ownerServiceMap.delete(ownerServiceMap.findById(id));

        assertEquals(0, ownerServiceMap.findAll().size());
    }

    @Test
    void deleteById() {
        ownerServiceMap.deleteById(id);

        assertEquals(0, ownerServiceMap.findAll().size());
    }

    @Test
    void findByLastNameFound() {
        Owner owner = ownerServiceMap.findByLastName(lastName);

        assertNotNull(owner);
        assertEquals(id, owner.getId());
    }

    @Test
    void findByLastNameNotFound() {
        Owner owner = ownerServiceMap.findByLastName("Hello");

        assertNull(owner);
    }
}