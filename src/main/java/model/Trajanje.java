package model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
public abstract class Trajanje {
    private LocalDateTime pocetak;
    private LocalDateTime kraj;

    public Trajanje(LocalDateTime pocetak, long minuti) {
        this.pocetak = pocetak;
        kraj=pocetak.plusMinutes(minuti);
    }
    protected static boolean isThereOverlap(Trajanje t1, Trajanje t2) {

        return t1.pocetak.isAfter(t2.pocetak) && t1.pocetak.isBefore(t2.kraj) ||
                t1.kraj.isAfter(t2.pocetak) && t1.kraj.isBefore(t2.kraj) ||
                t1.pocetak.isBefore(t2.pocetak) && t1.kraj.isAfter(t2.kraj);
    }

}
