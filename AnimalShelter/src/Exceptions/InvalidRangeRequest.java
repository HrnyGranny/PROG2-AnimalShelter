package Exceptions;

public class InvalidRangeRequest extends Exception {
    public InvalidRangeRequest() {
    }
    public InvalidRangeRequest(String description) {
        super(description);
    }
   
}
