package ks.catsndogs.db;

import ks.catsndogs.db.entities.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UsersRepository extends CrudRepository<UserEntity, Long> {

    UserEntity findTopByUsername(String name);
}
