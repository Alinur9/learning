package com.practice.jackson;

public class JsonObj {
     String eventId;
     String eventName;

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    String requestId;

    public String getRequestId() {
        return requestId;
    }

    public void setEventId(String eventID) {
        this.eventId = eventID;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getEventId() {
        return eventId;
    }

    public String getEventName() {
        return eventName;
    }
}
