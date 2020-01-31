public class NameExistException extends Exception {
    public NameExistException() {
        super();
    }

    public NameExistException(String message) {
        super(message);
    }

    public NameExistException(String message, Throwable cause) {
        super(message, cause);
    }

    public NameExistException(Throwable cause) {
        super(cause);
    }

    protected NameExistException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
