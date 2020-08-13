package pl.coderslab.gymproject.service.impl;

import org.springframework.stereotype.Service;
import pl.coderslab.gymproject.entity.Pass;
import pl.coderslab.gymproject.service.PassService;
import pl.coderslab.gymproject.repository.PassRepository;

import java.util.List;

@Service
public class PassServiceImpl implements PassService {
    private PassRepository passRepository;

    public PassServiceImpl(PassRepository passRepository) {
        this.passRepository = passRepository;
    }

    @Override
    public List<Pass> getAll() {
        return passRepository.findAll();
    }

    @Override
    public Pass findById(long id) {
        return passRepository.findById(id).orElse(null);
    }

    @Override
    public void savePass(Pass pass) {
        passRepository.save(pass);
    }

    @Override
    public void delete(long id) {
        passRepository.delete(passRepository.findById(id).orElse(null));
    }
}
