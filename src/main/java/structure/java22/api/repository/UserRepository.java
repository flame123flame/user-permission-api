package structure.java22.api.repository;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import structure.java22.api.entity.UserEntity;

import java.util.Optional;


@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

    @Transactional
    Optional<UserEntity> findByUsername(String username);

    boolean existsByUsername(String username);


}