package br.com.brasilprev.TesteBrasilPrev.utils;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

/**
 * Created by @memr_1979
 */
public class ReturnStatus
{
    ObjectMapper mapper = new ObjectMapper();

    public ObjectNode statusOk() {
        ObjectNode objectNode = mapper.createObjectNode();
        objectNode.put("status", "Record Inserted.");
        objectNode.put("code", "1");
        return objectNode;
    }

    public ObjectNode statusError(String msg) {
        ObjectNode objectNode = mapper.createObjectNode();
        objectNode.put("status", "Error: " + msg);
        objectNode.put("code", "0");
        return objectNode;
    }

    public ObjectNode NotFound() {
        ObjectNode objectNode = mapper.createObjectNode();
        objectNode.put("status", "Object not found.");
        objectNode.put("code", "2");
        return objectNode;
    }

    public ObjectNode statusDeleted() {
        ObjectNode objectNode = mapper.createObjectNode();
        objectNode.put("status", "Deleted with success.");
        objectNode.put("code", "5");
        return objectNode;
    }


    public ObjectNode statusUpdated() {
        ObjectNode objectNode = mapper.createObjectNode();
        objectNode.put("status", "Updated with success.");
        objectNode.put("code", "6");
        return objectNode;
    }

}