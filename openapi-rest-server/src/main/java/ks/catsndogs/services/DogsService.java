package ks.catsndogs.services;

import ks.catsndogs.db.DogsRepository;
import ks.catsndogs.db.entities.DogEntity;
import ks.catsndogs.model.Dog;
import ks.catsndogs.model.DogUpdate;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;
import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
public class DogsService implements CRUDService<String, Dog, DogUpdate> {

    private final DogsRepository dogsRepository;

    @Override
    public Dog add(Dog dog) {
        return dogsRepository.save(DogEntity.fromModel(dog))
                .toModel();
    }

    @Override
    public void remove(String name) {
        DogEntity dogEntity = dogsRepository.findTopByName(name)
                .orElseThrow(EntityNotFoundException::new);

        dogsRepository.delete(dogEntity);
    }

    @Override
    public Dog get(String name) {
        return dogsRepository.findTopByName(name)
                .map(DogEntity::toModel)
                .orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public List<Dog> getAll() {
        return StreamSupport.stream(dogsRepository.findAll().spliterator(), false)
                .map(DogEntity::toModel)
                .toList();
    }

    @Override
    public Dog update(String name, DogUpdate dogUpdate) {
        DogEntity dogEntity = dogsRepository.findTopByName(name)
                .orElseThrow(EntityNotFoundException::new);

        if (dogUpdate.getAge() != null) {
            dogEntity.setAge(dogUpdate.getAge());
        }

        if (dogUpdate.getName() != null) {
            dogEntity.setName(dogUpdate.getName());
        }

        return dogsRepository.save(dogEntity).toModel();
    }
}
