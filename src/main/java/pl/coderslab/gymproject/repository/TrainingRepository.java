package pl.coderslab.gymproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.coderslab.gymproject.entity.Training;

import java.util.List;

@Repository
public interface TrainingRepository extends JpaRepository<Training, Long> {
    @Query("SELECT t from Training t JOIN t.participants as u WHERE u.id = :userId")
    List<Training> findByUser(@Param("userId") long userId);
}
