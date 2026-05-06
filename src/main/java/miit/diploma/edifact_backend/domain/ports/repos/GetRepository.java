package miit.diploma.edifact_backend.domain.ports.repos;

import java.util.List;
import java.util.Optional;

public interface GetRepository<I,T>{
    public Optional<T> findById(I id, Class<T> type);
    public List<T> findAll(Class<T> type);
}
