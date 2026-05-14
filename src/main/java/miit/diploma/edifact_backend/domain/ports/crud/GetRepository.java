package miit.diploma.edifact_backend.domain.ports.crud;

import java.util.List;
import java.util.Optional;

public interface GetRepository<I,T>{
    public Optional<T> findById(I id);
    public List<T> findAll();
}
