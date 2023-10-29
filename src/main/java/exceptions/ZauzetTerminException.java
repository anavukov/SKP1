package exceptions;

public class ZauzetTerminException extends Exception{
    public ZauzetTerminException() {
        super("Trazeni termin je zauzet!");
    }
}
