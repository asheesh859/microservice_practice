package com.lwcd.hotel.Hotel.exceptions;

public class ResourceNotFoundException extends RuntimeException{
    public ResourceNotFoundException(String smg){
        super(smg);
    }

    public ResourceNotFoundException(){
        super("Resource Not Found Exception !!");
    }
}
