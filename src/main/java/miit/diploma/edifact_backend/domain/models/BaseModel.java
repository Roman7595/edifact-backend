package miit.diploma.edifact_backend.domain.models;

public abstract class BaseModel {
    private long id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
