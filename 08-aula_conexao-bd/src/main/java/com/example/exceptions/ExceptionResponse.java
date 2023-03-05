package com.example.exceptions;


import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

public class ExceptionResponse implements Serializable {

    @Serial
    private static final long serialVersionUID=1L;

    private Date timesTamp;
    private String message;
    private String details;

    public ExceptionResponse(Date timesTamp, String message, String details) {
        this.timesTamp = timesTamp;
        this.message = message;
        this.details = details;
    }

    public Date getTimesTamp() {
        return timesTamp;
    }

    public void setTimesTamp(Date timesTamp) {
        this.timesTamp = timesTamp;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}
