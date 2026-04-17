package com.carcomparer.car_comparer.catalog.utils;

public class StorageFileNotFoundException extends StorageException{

    public StorageFileNotFoundException(String message){
        super(message);
    }

    public StorageFileNotFoundException (String message, Throwable cause){
        super(message, cause);
    }
    
}
 