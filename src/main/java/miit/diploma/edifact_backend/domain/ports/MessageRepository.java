package miit.diploma.edifact_backend.domain.ports;

import miit.diploma.edifact_backend.domain.models.Message;
import miit.diploma.edifact_backend.domain.ports.repos.UpdateRepository;
import miit.diploma.edifact_backend.domain.ports.repos.GetRepository;
import miit.diploma.edifact_backend.domain.ports.repos.SaveRepository;


public interface MessageRepository extends GetRepository<Long, Message>, SaveRepository<Long, Message>, UpdateRepository<Long, Message> {

}
