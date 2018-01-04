package com.example.model;

import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by alex on 1/4/2018.
 */
public class ServiceCall {
    private static final AtomicLong counter = new AtomicLong(100000);
    private long id;
    private long assignedTo;

    private String title;
    private String description;
    private long clientID;
    private ServiceCallStatus status;

    public ServiceCall(String title, String description, long clientID, ServiceCallStatus status) {
        this.title = title;
        this.description = description;
        this.status = status;
        this.id = counter.incrementAndGet();
        this.clientID = clientID;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getClientID() {
        return clientID;
    }

    public void setClientID(long clientID) {
        this.clientID = clientID;
    }

    public long getAssignedTo() {
        return assignedTo;
    }

    public void setAssignedTo(long assignedTo) {
        this.assignedTo = assignedTo;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ServiceCallStatus getStatus() {
        return status;
    }

    public void setStatus(ServiceCallStatus status) {
        this.status = status;
    }
}
