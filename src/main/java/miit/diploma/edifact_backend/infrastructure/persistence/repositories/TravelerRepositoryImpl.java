package miit.diploma.edifact_backend.infrastructure.persistence.repositories;

import miit.diploma.edifact_backend.domain.models.Message;
import miit.diploma.edifact_backend.domain.models.Traveler;
import miit.diploma.edifact_backend.domain.ports.TravelerRepository;
import miit.diploma.edifact_backend.infrastructure.persistence.entites.MessageEntity;
import miit.diploma.edifact_backend.infrastructure.persistence.entites.TravelerEntity;
import miit.diploma.edifact_backend.infrastructure.persistence.repositories.mappers.TravelerEntityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class TravelerRepositoryImpl implements TravelerRepository {
    private final GenericRepositoryImpl<Long,TravelerEntity> crudRepository;
    private final TravelerEntityMapper travelerEntityMapper;

    @Autowired
    public TravelerRepositoryImpl(GenericRepositoryImpl<Long,TravelerEntity> crudRepository, TravelerEntityMapper travelerEntityMapper) {
        this.crudRepository = crudRepository;
        this.travelerEntityMapper = travelerEntityMapper;
    }


    @Override
    public Traveler save(Traveler traveler) {
        TravelerEntity travelerEntity = travelerEntityMapper.modelToEntity(traveler);
        travelerEntity = crudRepository.save(travelerEntity);
        return travelerEntityMapper.entityToModel(travelerEntity);
    }

    @Override
    public Optional<Traveler> findById(Long id, Class<Traveler> type) {
        Optional<TravelerEntity> travelerEntity = crudRepository.findById(id, TravelerEntity.class);
        Traveler traveler = null;
        if (travelerEntity.isPresent()){
            traveler = travelerEntityMapper.entityToModel(travelerEntity.get());
        }

        return Optional.ofNullable(traveler);

    }

    @Override
    public List<Traveler> findAll(Class<Traveler> type) {
        List<TravelerEntity> travelerEntityList = crudRepository.findAll(TravelerEntity.class);
        List<Traveler> travelerList = new ArrayList<>(travelerEntityList.size());
        for(TravelerEntity travelerEntity: travelerEntityList){

            travelerList.add(travelerEntityMapper.entityToModel(travelerEntity));
        }
        return travelerList;
    }

    @Override
    public List<Traveler> saveAll(List<Traveler> entities) {
        List<TravelerEntity> messageEntityList = entities.stream().map(travelerEntityMapper::modelToEntity).toList();
        messageEntityList = crudRepository.saveAll(messageEntityList);

        return messageEntityList.stream().map(travelerEntityMapper::entityToModel).toList();
    }
}
