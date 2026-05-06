package miit.diploma.edifact_backend.domain.ports.repos;

public interface SaveRepository<I,T>{
    public T save(T entity);
}
