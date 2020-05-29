package pl.coderslab.gymproject.interfaces;

import pl.coderslab.gymproject.entity.PassType;

import java.util.List;

public interface PassTypeService {
    void savePass(PassType passType);
    List<PassType> getAll();
    PassType findById(long id);
    void delete(long id);
}
