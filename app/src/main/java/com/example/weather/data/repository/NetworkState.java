package com.example.weather.data.repository;

public class NetworkState {

    private final Status status;
    private final String message;

    private NetworkState(Status status, String message) {
        this.status = status;
        this.message = message;
    }

    public Status getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public static NetworkState LOADED = new NetworkState(Status.SUCCESS, "Success");
    public static NetworkState LOADING = new NetworkState(Status.RUNNING, "Running");
    public static NetworkState ERROR = new NetworkState(Status.FAILED, "Something went wrong");
}
