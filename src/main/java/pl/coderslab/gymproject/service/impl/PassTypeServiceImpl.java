package pl.coderslab.gymproject.service.impl;

import org.springframework.stereotype.Service;
import pl.coderslab.gymproject.entity.PassType;
import pl.coderslab.gymproject.service.PassTypeService;
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
        return this.passTypeRepository.getOne(id);
    }

    @Override
    public void delete(long id) {
        this.passTypeRepository.delete(passTypeRepository.getOne(id));
    }
}
