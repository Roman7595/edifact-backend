package miit.diploma.edifact_backend.domain.ports;

import miit.diploma.edifact_backend.domain.models.Message;
import miit.diploma.edifact_backend.domain.ports.crud.UpdateRepository;
import miit.diploma.edifact_backend.domain.ports.crud.GetRepository;
import miit.diploma.edifact_backend.domain.ports.crud.SaveRepository;


public interface MessageRepository extends GetRepository<Long, Message>, SaveRepository<Message>, UpdateRepository<Message> {

}
