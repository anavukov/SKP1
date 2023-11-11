package model;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class TrajanjeDnevno  extends Trajanje{
    private LocalDate datum;
    private DayOfWeek danUNedelji;

    public TrajanjeDnevno(LocalTime pocetak, long minuti, LocalDate datum ) {
        super(pocetak, minuti);
        this.datum = datum;
        this.danUNedelji = datum.getDayOfWeek();

    }

    public TrajanjeDnevno(LocalTime pocetak, LocalTime kraj, LocalDate datum) {
        super(pocetak, kraj);
        this.datum = datum;
        this.danUNedelji = datum.getDayOfWeek();
    }
}
