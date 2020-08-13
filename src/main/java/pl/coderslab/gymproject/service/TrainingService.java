package pl.coderslab.gymproject.service;

import pl.coderslab.gymproject.entity.Training;
import pl.coderslab.gymproject.entity.User;

import java.util.List;

public interface TrainingService {
    void save(Training training);
    List<Training> getAll();
    void delete(long id);
    void update(User user, Training training);
    Training findById(long id);
    List<Training> findByUser(long userId);
}
