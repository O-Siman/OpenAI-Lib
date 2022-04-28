package com.columbushs.openailib.objects;

import java.util.ArrayList;

public class OpenAIResponse {
    final private String id;
    final private String object;
    final private long created;
    final private String model;
    final private ArrayList<OpenAIChoice> choices;

    public OpenAIResponse(String id, String object, long created, String model, ArrayList<OpenAIChoice> choices) {
        this.id = id;
        this.object = object;
        this.created = created;
        this.model = model;
        this.choices = choices;
    }

    public String getId() {
        return id;
    }

    public String getObject() {
        return object;
    }

    public long getCreated() {
        return created;
    }

    public String getModel() {
        return model;
    }

    public ArrayList<OpenAIChoice> getChoices() {
        return choices;
    }
}
