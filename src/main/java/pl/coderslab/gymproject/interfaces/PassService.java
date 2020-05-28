package pl.coderslab.gymproject.interfaces;

import pl.coderslab.gymproject.entity.Pass;

import java.util.List;

public interface PassService {
    List<Pass> getAll();
    Pass findById(long id);
}
