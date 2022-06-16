package ks.catsndogs.db;

import ks.catsndogs.db.entities.CatEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface CatsRepository extends CrudRepository<CatEntity, Long> {

    Optional<CatEntity> findTopByName(String name);
}
