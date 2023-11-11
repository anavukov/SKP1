package model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import model.Trajanje;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.List;

@Getter
@AllArgsConstructor
public class SlobodanTerminUPerioduRequest extends SlobodanTerminRequest{
    private DayOfWeek danUNedelji;
    private LocalDate pocetniDatum;
    private LocalDate krajnjiDatum;
    private LocalTime pocetak;
    private LocalTime kraj;

    public List<Trajanje> toTrajanje(){
        List<Trajanje> sviDatumi = new ArrayList<>();
        pocetniDatum = pocetniDatum.with(TemporalAdjusters.next(danUNedelji));
        for(LocalDate date = pocetniDatum;date.isBefore(krajnjiDatum);date=date.plusWeeks(1)){
            //sviDatumi.add(new Trajanje(LocalDateTime.of(date,pocetak),LocalDateTime.of(date,kraj)));
        }
        return sviDatumi;
    }
}
// proci za sve od pocetnog do krajnjeg datuma ali cemo pamtiti termin kao danpocetak i kraj
