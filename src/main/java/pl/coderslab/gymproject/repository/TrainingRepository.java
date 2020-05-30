package pl.coderslab.gymproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.coderslab.gymproject.entity.Training;

@Repository
public interface TrainingRepository extends JpaRepository<Training, Long> {

}
