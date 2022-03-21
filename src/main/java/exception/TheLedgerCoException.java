package exception;

public class TheLedgerCoException extends Exception {

    /*
        Description: Our own exception class to customize the exceptions.
     */

    public TheLedgerCoException() {
        super();
    }

    public TheLedgerCoException(String message) {
        super(message);
    }
}
