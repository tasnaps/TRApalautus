package Viikko8;

public class ListException extends RuntimeException {
    public ListException() {
        super();
    }
    public ListException(String reason) {
        super(reason);
    }
    public ListException(Throwable t) {
        super(t);
    }
}
