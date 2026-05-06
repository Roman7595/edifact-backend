package miit.diploma.edifact_backend.application.dto;

public class TravelerResponse {
    private long id;
    private String name;

    public TravelerResponse(long id, String name) {
        setId(id);
        setName(name);
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
}
