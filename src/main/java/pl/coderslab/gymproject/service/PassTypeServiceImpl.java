package pl.coderslab.gymproject.service;

import org.springframework.stereotype.Service;
import pl.coderslab.gymproject.entity.PassType;
import pl.coderslab.gymproject.interfaces.PassTypeService;
import pl.coderslab.gymproject.repository.PassTypeRepository;

import java.util.List;

@Service
public class PassTypeServiceImpl implements PassTypeService {

    private PassTypeRepository passTypeRepository;

    public PassTypeServiceImpl(PassTypeRepository passTypeRepository) {
        this.passTypeRepository = passTypeRepository;
    }


    @Override
    public void savePass(PassType passType) {
        this.passTypeRepository.save(passType);
    }

    @Override
    public List<PassType> getAll() {
        return this.passTypeRepository.findAll();
    }

    @Override
    public PassType findById(long id) {
        return this.passTypeRepository.findById(id).orElse(null);
    }

    @Override
    public void delete(long id) {
        this.passTypeRepository.delete(passTypeRepository.getOne(id));
    }
}
