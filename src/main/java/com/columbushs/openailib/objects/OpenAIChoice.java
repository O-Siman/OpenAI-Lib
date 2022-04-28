package com.columbushs.openailib.objects;

public class OpenAIChoice {
    final private String text;
    final private int index;
    final private String finishReason;

    public OpenAIChoice(String text, int index, String finishReason) {
        this.text = text;
        this.index = index;
        this.finishReason = finishReason;
    }

    public String getText() {
        return text;
    }

    public int getIndex() {
        return index;
    }

    public String getFinishReason() {
        return finishReason;
    }
}
