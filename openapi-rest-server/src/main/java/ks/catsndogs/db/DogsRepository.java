package ks.catsndogs.db;

import ks.catsndogs.db.entities.DogEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface DogsRepository extends CrudRepository<DogEntity, Long> {

    Optional<DogEntity> findTopByName(String name);
}
