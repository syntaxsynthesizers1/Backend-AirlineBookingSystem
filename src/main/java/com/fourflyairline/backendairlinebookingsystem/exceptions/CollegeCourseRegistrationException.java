package com.fourflyairline.backendairlinebookingsystem.exceptions;

public class CollegeCourseRegistrationException extends Throwable {
    public CollegeCourseRegistrationException(String message){
        super(message);
    }

    public CollegeCourseRegistrationException(Throwable throwable){
        super(throwable);
    }
}
