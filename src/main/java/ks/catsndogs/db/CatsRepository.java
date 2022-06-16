package ks.catsndogs.db;

import ks.catsndogs.db.entities.CatEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CatsRepository extends CrudRepository<CatEntity, Long> {

    CatEntity findTopByName(String name);
}
