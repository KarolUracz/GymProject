package pl.coderslab.gymproject.service;

import pl.coderslab.gymproject.entity.Pass;

import java.util.List;

public interface PassService {
    List<Pass> getAll();
    Pass findById(long id);
    void savePass(Pass pass);
    void delete(long id);
}
