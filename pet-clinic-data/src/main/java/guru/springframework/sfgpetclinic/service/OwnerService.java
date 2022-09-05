package guru.springframework.sfgpetclinic.service;

import guru.springframework.sfgpetclinic.model.Owner;

import java.util.Set;

public interface OwnerService {

    Owner findByLastName(String lastName);

    Owner save(Owner owner);

    Owner findById(Long id);

    Set<Owner> finAll();

}
