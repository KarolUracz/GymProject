package pl.coderslab.gymproject.interfaces;

import pl.coderslab.gymproject.entity.Training;

import java.util.List;

public interface TrainingService {
    void save(Training training);
    List<Training> getAll();
    void delete(long id);
}
