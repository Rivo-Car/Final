package com.example.final_project.exception;

public class RouteException extends RuntimeException {

    public RouteException(String message) {
        super(message);
    }

    public RouteException(){
        this("Route already exists");
    }

}
