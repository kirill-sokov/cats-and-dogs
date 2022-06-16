package ks.catsndogs.db;

import ks.catsndogs.db.entities.DogEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface DogsRepository extends CrudRepository<DogEntity, Long> {

    DogEntity findTopByName(String name);
}
