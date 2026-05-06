package miit.diploma.edifact_backend.domain.ports;

import miit.diploma.edifact_backend.domain.models.Traveler;
import miit.diploma.edifact_backend.domain.ports.crud.GetRepository;
import miit.diploma.edifact_backend.domain.ports.crud.SaveRepository;

public interface TravelerRepository extends SaveRepository<Long, Traveler>, GetRepository<Long,Traveler> {
}
