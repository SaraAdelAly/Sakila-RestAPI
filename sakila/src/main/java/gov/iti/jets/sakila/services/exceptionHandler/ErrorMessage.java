package gov.iti.jets.sakila.services.exceptionHandler;

import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ErrorMessage {
    private String errorMessage;


    public ErrorMessage(String errorMessage, int errorCode, String errorDescription) {
        this.errorMessage = errorMessage;
        this.errorCode = errorCode;
        this.errorDescription = errorDescription;
    }
    private int errorCode;
    private String errorDescription;

    
    public String getErrorMessage() {
        return errorMessage;
    }
    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
    public int getErrorCode() {
        return errorCode;
    }
    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }
    public String getErrorDescription() {
        return errorDescription;
    }
    public void setErrorDescription(String errorDescription) {
        this.errorDescription = errorDescription;
    }
}
