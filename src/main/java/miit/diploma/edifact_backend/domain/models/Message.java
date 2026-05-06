package miit.diploma.edifact_backend.domain.models;

import java.util.List;
import java.util.Map;

public class Message extends BaseModel {

    private String  edifact;
    private Map<String, Object> structure;

    protected Message() {
    }

    public Message(String edifact) {
        setEdifact(edifact);
    }

    public String getEdifact() {
        return edifact;
    }

    public Map<String, Object> getStructure() {
        return structure;
    }


    public void setStructure(Map<String, Object> structure) {
        if(structure == null){
            throw new RuntimeException("Structure must not be null");
        }
        this.structure = structure;
    }

    public void setEdifact(String edifact) {
        if(edifact == null){
            throw new RuntimeException("Message must not be null");
        }
        this.edifact = edifact;
    }



    public List<Traveler> extractTravelers() {
//        logic
        return List.of();
    }

}
