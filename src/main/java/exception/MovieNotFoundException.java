package exception;

public class MovieNotFoundException extends Exception{
    private static final long serialVersionUID = 1L;
    private String message;

    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }

    public MovieNotFoundException(String message) {
        super();
        this.message = message;
    }

    public MovieNotFoundException(String message, String message1) {
        super(message);
        this.message = message1;
    }

    public MovieNotFoundException(String message, Throwable cause, String message1) {
        super(message, cause);
        this.message = message1;
    }

    public MovieNotFoundException(Throwable cause, String message) {
        super(cause);
        this.message = message;
    }

    public MovieNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, String message1) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.message = message1;
    }

}
