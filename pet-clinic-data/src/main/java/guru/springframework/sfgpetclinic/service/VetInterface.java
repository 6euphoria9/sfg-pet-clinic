package guru.springframework.sfgpetclinic.service;

import guru.springframework.sfgpetclinic.model.Vet;

import java.util.Set;

public interface VetInterface {

    Vet save(Vet vet);

    Vet findById(Long id);

    Set<Vet> finAll();

}
