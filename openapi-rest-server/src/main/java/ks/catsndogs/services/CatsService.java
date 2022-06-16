package ks.catsndogs.services;

import ks.catsndogs.db.CatsRepository;
import ks.catsndogs.db.entities.CatEntity;
import ks.catsndogs.model.Cat;
import ks.catsndogs.model.CatUpdate;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
public class CatsService implements CRUDService<String, Cat, CatUpdate> {

    private final CatsRepository catsRepository;

    @Override
    @PreAuthorize("hasRole('catlover')")
    public Cat add(Cat cat) {
        return catsRepository.save(CatEntity.fromModel(cat))
                .toModel();
    }

    @Override
    @PreAuthorize("hasRole('catlover')")
    public void remove(String catName) {
        CatEntity cat = catsRepository.findTopByName(catName)
                .orElseThrow(EntityNotFoundException::new);

        catsRepository.delete(cat);
    }

    @Override
    public Cat get(String catName) {
        return catsRepository.findTopByName(catName)
                .map(CatEntity::toModel)
                .orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public List<Cat> getAll() {
        return StreamSupport.stream(catsRepository.findAll().spliterator(), false)
                .map(CatEntity::toModel)
                .toList();
    }

    @Override
    @PreAuthorize("hasRole('catlover')")
    public Cat update(String catName, CatUpdate catUpdate) {
        CatEntity cat = catsRepository.findTopByName(catName)
                .orElseThrow(EntityNotFoundException::new);

        if (catUpdate.getAge() != null) {
            cat.setAge(catUpdate.getAge());
        }

        if (catUpdate.getName() != null) {
            cat.setName(catUpdate.getName());
        }

        return catsRepository.save(cat).toModel();
    }
}
