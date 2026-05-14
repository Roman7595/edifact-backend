package miit.diploma.edifact_backend.domain.models;

import com.fasterxml.jackson.databind.JsonNode;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Random;


public class Message extends BaseModel {

    private String  edifact;
    private JsonNode structure;

    protected Message() {
    }

    public Message(String edifact) {
        setEdifact(edifact);
    }

    public String getEdifact() {
        return edifact;
    }

    public JsonNode getStructure() {
        return structure;
    }


    public void setStructure(JsonNode structure) {
        this.structure = structure;
    }

    public void setEdifact(String edifact) {
        if(edifact == null){
            throw new RuntimeException("Message must not be null");
        }
        this.edifact = edifact;
    }



    public List<Traveler> extractTravelers() {
        String name = String.valueOf(structure.get("messageHeader").get("referenceNumber"));
        Traveler traveler = new Traveler(name,name,name,name,name,name, LocalDateTime.now(),this);

        String[] list = {null,"1","2"};
        Random random = new Random();
        traveler.setFlightNumber(list[random.nextInt(list.length)]);
        return List.of(traveler);
    }

}
