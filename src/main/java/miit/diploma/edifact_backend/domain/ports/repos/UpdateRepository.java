package miit.diploma.edifact_backend.domain.ports.repos;

public interface UpdateRepository<I,T> {
    public T update(T entity);
}
