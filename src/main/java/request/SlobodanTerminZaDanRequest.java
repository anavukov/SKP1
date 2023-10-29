package request;

import model.Trajanje;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class SlobodanTerminZaDanRequest extends SlobodanTerminRequest {
    public LocalDate date;
    public LocalTime pocetak;
    public LocalTime kraj;
    public Trajanje toTrajanje(){
        LocalDateTime pocetak = LocalDateTime.of(date,this.pocetak);
        LocalDateTime kraj = LocalDateTime.of(date,this.kraj);
        return new Trajanje(pocetak,kraj);
    }
}
