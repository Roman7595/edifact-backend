package miit.diploma.edifact_backend.domain.ports.crud;

public interface UpdateRepository<T> {
    public T update(T entity);
}
