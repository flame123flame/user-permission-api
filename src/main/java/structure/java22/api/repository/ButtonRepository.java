package structure.java22.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import structure.java22.api.entity.ButtonEntity;



@Repository
public interface ButtonRepository extends JpaRepository<ButtonEntity, Long> {


}