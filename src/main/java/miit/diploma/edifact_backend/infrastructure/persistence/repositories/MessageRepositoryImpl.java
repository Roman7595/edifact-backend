package miit.diploma.edifact_backend.infrastructure.persistence.repositories;

import miit.diploma.edifact_backend.domain.models.Message;
import miit.diploma.edifact_backend.domain.ports.MessageRepository;

import miit.diploma.edifact_backend.infrastructure.persistence.repositories.mappers.MessageEntityMapper;
import miit.diploma.edifact_backend.infrastructure.persistence.entites.MessageEntity;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class MessageRepositoryImpl implements MessageRepository {

    private final GenericRepositoryImpl<Long, MessageEntity> crudRepository;
    private final MessageEntityMapper messageEntityMapper;

    public MessageRepositoryImpl(GenericRepositoryImpl<Long, MessageEntity> crudRepository, MessageEntityMapper messageEntityMapper) {
        this.crudRepository = crudRepository;
        this.messageEntityMapper = messageEntityMapper;
    }

    @Override
    public Optional<Message> findById(Long id) {

        Optional<MessageEntity> messageEntity = crudRepository.findById(id,MessageEntity.class);
        Message message = null;
        if (messageEntity.isPresent()){
             message = messageEntityMapper.entityToModel(messageEntity.get());
        }

        return Optional.ofNullable(message);
    }

    @Override
    public List<Message> findAll() {
        List<MessageEntity> messageEntityList = crudRepository.findAll(MessageEntity.class);
        List<Message> messageList = new ArrayList<>(messageEntityList.size());
        for (MessageEntity messageEntity : messageEntityList){
            messageList.add(messageEntityMapper.entityToModel(messageEntity));
        }
        return messageList;
    }

    @Override
    public List<Message> saveAll(List<Message> entities) {
        List<MessageEntity> messageEntityList = entities.stream().map(messageEntityMapper::modelToEntity).toList();
        messageEntityList = crudRepository.saveAll(messageEntityList);

        return messageEntityList.stream().map(messageEntityMapper::entityToModel).toList();
    }

    @Override
    public Message save(Message entity) {
        MessageEntity messageEntity = messageEntityMapper.modelToEntity(entity);
        messageEntity = crudRepository.save(messageEntity);

        return messageEntityMapper.entityToModel(messageEntity);
    }

    @Override
    public Message update(Message entity) {

        MessageEntity messageEntity = messageEntityMapper.modelToEntity(entity);
        messageEntity = crudRepository.update(messageEntity);

        return messageEntityMapper.entityToModel(messageEntity);
    }
}
