package pl.coderslab.gymproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.coderslab.gymproject.entity.Pass;

@Repository
public interface PassRepository extends JpaRepository<Pass, Long> {
}
