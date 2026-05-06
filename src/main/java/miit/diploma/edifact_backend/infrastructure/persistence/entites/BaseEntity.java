package miit.diploma.edifact_backend.infrastructure.persistence.entites;

import jakarta.persistence.*;

@MappedSuperclass
public abstract class BaseEntity {

    private long id;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
