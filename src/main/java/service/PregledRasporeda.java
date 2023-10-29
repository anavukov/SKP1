package service;

import model.Prostor;
import model.Termin;
import request.KriterijumRequest;
import request.SlobodanTerminRequest;

import java.time.LocalDate;
import java.util.List;

public interface PregledRasporeda {
    /*
    Izlistavanje slobodnih termina može da uključi i
tačnu prostoriju, prostoriju sa određenim osobinama (na primer učionica sa računarima, projektorom,

da ima više od 30 mesta i slično), a može i da bude nezavisno od prostorije (izlistati sve učionice koja je
slobodna tog i tog dana). Obezbediti i pretraživanje rasporeda prema vezanim podacima (na primer ako
je nastavnik vezani podatak, izlistati sve termine tog nastavnika ili sve termine kada je on slobodan).
     */

    List<Termin> slobodniTerminiUProstoru(LocalDate date, Prostor prostor);
    List<Termin> slobodanZaVreme(SlobodanTerminRequest request);
    List<Termin> filterSlobodne(SlobodanTerminRequest request,Prostor prostor);
    List<Termin> filterSlobodneSaRacunarima(SlobodanTerminRequest request);
    List<Termin> filterSlobodne(SlobodanTerminRequest request,
                                int kapacitet,
                                int brojRacunara,
                                boolean projektor,
                                boolean grafickaTabla
    );
    List<Termin> filterSlobodne(SlobodanTerminRequest request, KriterijumRequest kriterijumRequest);
    List<Termin> slobodanNastavnik(LocalDate date, int minutes, String nastavnik);
    List<Termin> terminiNastavnika(LocalDate date, int minutes, String nastavnik);


}
