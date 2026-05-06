package miit.diploma.edifact_backend.domain.ports.crud;

import java.util.List;

public interface SaveRepository<I,T>{
    public T save(T entity);
    public List<T> saveAll(List<T> entity);
}
