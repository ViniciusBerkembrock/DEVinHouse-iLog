
package tech.devinhouse.m01s06exercicio03a06.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.devinhouse.m01s06exercicio03a06.models.Pet;
import tech.devinhouse.m01s06exercicio03a06.models.Tutor;
import tech.devinhouse.m01s06exercicio03a06.repositories.PetRepository;
import tech.devinhouse.m01s06exercicio03a06.repositories.TutorRepository;
import java.util.List;

@Service
public class PetService {

    @Autowired
    private PetRepository petRepository;

    @Autowired
    private TutorRepository tutorRepository;

    public Pet save(Pet pet) {
        try {
            if (pet.getTutor().getId() != null) {
                Tutor tutor = tutorRepository.findById(pet.getTutor().getId());
                pet.setTutor(tutor);
            }
        } catch (Exception e) {
            pet.setTutor(null);
        }
        return petRepository.save(pet);
    }

    public List<Pet> findAll() {
        return petRepository.findAll();
    }

    public boolean delete(Integer id) {
        return petRepository.delete(id);
    }
}