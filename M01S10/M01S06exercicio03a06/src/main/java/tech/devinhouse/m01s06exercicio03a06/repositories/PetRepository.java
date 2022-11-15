package tech.devinhouse.m01s06exercicio03a06.repositories;

import org.springframework.stereotype.Repository;
import tech.devinhouse.m01s06exercicio03a06.models.Pet;
import java.util.List;
import java.util.ArrayList;

@Repository
public class PetRepository {

    private static int sequencia = 0;
    private static List<Pet> pets = new ArrayList<>();

    public Pet save(Pet pet) {
        if (pet.getId() == null) {
            pet.setId(generateId());
            pets.add(pet);
            return pet;
        }

        Pet petEditacao = findById(pet.getId());
        petEditacao.setNome(pet.getNome());
        petEditacao.setTipo(pet.getTipo());
        petEditacao.setRaca(pet.getRaca());
        petEditacao.setIdade(pet.getIdade());
        petEditacao.setAlimentoPreferido(pet.getAlimentoPreferido());
        petEditacao.setTutor(pet.getTutor());

        return petEditacao;
    }

    public Pet findById(Integer id) {
        for (Pet pet : pets) {
            if (id == pet.getId()) {
                return pet;
            }
        }
        return null;
    }

    public List<Pet> findAll() {
        return pets;
    }

    public boolean delete(Integer id) {
        try {
            Pet pet = findById(id);
            pets.remove(pet);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    private Integer generateId() {
        return ++sequencia;
    }
}