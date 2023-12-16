package Exceptions;

public class NoAnimalFound extends Exception {
    public NoAnimalFound(){}
    public NoAnimalFound(String description){
        super(description);
    }
}
