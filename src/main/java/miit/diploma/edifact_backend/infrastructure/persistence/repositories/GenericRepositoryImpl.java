package miit.diploma.edifact_backend.infrastructure.persistence.repositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import miit.diploma.edifact_backend.domain.ports.repos.GetRepository;
import miit.diploma.edifact_backend.domain.ports.repos.SaveRepository;
import miit.diploma.edifact_backend.domain.ports.repos.UpdateRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class GenericRepositoryImpl<I,T> implements GetRepository<I,T>, SaveRepository<I,T>, UpdateRepository<I,T> {

    @PersistenceContext
    private EntityManager entityManager;


    @Transactional
    public Optional<T> findById(I id, Class<T> entityClass){
        return Optional.of(entityManager.find(entityClass, id));
    }

    @Transactional
    public List<T> findAll(Class<T> entityClass){
        return entityManager.createQuery("Select t from " + entityClass.getName() + " t").getResultList();
    }


    @Transactional
    public T save(T entity){
        entityManager.persist(entity);
        return entity;
    }

    @Transactional
    public T update(T entity) {
        entityManager.merge(entity);
        return entity;
    }
}
