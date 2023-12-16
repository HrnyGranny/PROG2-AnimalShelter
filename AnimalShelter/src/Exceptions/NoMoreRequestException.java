package Exceptions;

public class NoMoreRequestException extends Exception {
    public NoMoreRequestException(){}
    public NoMoreRequestException(String description){
        super(description);
    }
}
