package VascoPanigi.exceptions;

public class EventNotFoundException extends RuntimeException {
    public EventNotFoundException(long id) {
        super("The event with id " + id + " isn't in our database!");
    }

}
