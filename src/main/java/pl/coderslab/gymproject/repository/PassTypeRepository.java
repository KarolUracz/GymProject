package pl.coderslab.gymproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.coderslab.gymproject.entity.PassType;

@Repository
public interface PassTypeRepository extends JpaRepository<PassType, Long> {
}
