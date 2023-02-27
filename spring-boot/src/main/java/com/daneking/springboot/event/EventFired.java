package com.daneking.springboot.event;

public class EventFired {
    private final String name;
    private final String status;


    public EventFired(String name, String status) {
        this.name = name;
        this.status = status;
    }

    public String getName() {
        return name;
    }


    public String getStatus() {
        return status;
    }


    @Override
    public String toString() {
        return "EventFired{" +
                "name='" + name + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
