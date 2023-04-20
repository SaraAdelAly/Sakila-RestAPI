package gov.iti.jets.sakila.services.exceptionHandler;

public class ExceptionHandler extends RuntimeException{

    public ExceptionHandler (String message) {
        super(message);
    }
    
}
