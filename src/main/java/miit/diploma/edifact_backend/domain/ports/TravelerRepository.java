package miit.diploma.edifact_backend.domain.ports;

import miit.diploma.edifact_backend.domain.models.Traveler;

import java.util.List;
import java.util.Optional;

public interface TravelerRepository {
    Traveler save(Traveler traveler);
    Optional<Traveler> findById(Long id);
    List<Traveler> getAll();

}
