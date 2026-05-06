package miit.diploma.edifact_backend.infrastructure.persistence.repositories.mappers;

public interface EntityMapper<T,E> {
    E modelToEntity(T model);
    T entityToModel(E entity);

}
