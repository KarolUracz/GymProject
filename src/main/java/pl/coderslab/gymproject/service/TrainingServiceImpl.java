package pl.coderslab.gymproject.service;

import org.springframework.stereotype.Service;
import pl.coderslab.gymproject.entity.Training;
import pl.coderslab.gymproject.interfaces.TrainingService;
import pl.coderslab.gymproject.repository.TrainingRepository;

import java.util.List;

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
}
