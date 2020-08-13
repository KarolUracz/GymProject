package pl.coderslab.gymproject.service.impl;

import org.springframework.stereotype.Service;
import pl.coderslab.gymproject.entity.Training;
import pl.coderslab.gymproject.entity.User;
import pl.coderslab.gymproject.service.TrainingService;
import pl.coderslab.gymproject.repository.TrainingRepository;

import java.util.List;
import java.util.Set;

@Service
public class TrainingServiceImpl implements TrainingService {

    private TrainingRepository trainingRepository;

    public TrainingServiceImpl(TrainingRepository trainingRepository) {
        this.trainingRepository = trainingRepository;
    }

    @Override
    public void save(Training training) {
        trainingRepository.save(training);
    }

    @Override
    public List<Training> getAll() {
        return trainingRepository.findAll();
    }

    @Override
    public void delete(long id) {
        trainingRepository.delete(trainingRepository.getOne(id));
    }

    @Override
    public void update(User user, Training training) {
        Set<User> participants = training.getParticipants();
        participants.add(user);
        training.setParticipants(participants);
        trainingRepository.save(training);
    }

    @Override
    public Training findById(long id) {
        return trainingRepository.findById(id).orElse(null);
    }

    @Override
    public List<Training> findByUser(long userId) {
        return trainingRepository.findByUser(userId);
    }
}
