package ks.catsndogs.db;

import ks.catsndogs.db.entities.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface UsersRepository extends CrudRepository<UserEntity, Long> {

    Optional<UserEntity> findTopByUsername(String name);
}
