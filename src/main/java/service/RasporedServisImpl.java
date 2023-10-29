package service;

import model.Prostor;
import model.Raspored;
import model.Termin;
import model.Trajanje;
import model.vezaniPodaci.Profesor;
import model.vezaniPodaci.VezaniPodatak;
import request.KriterijumRequest;
import request.SlobodanTerminRequest;
import request.SlobodanTerminZaDanRequest;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public abstract class RasporedServisImpl implements PregledRasporeda {
    private final Raspored raspored;

    public RasporedServisImpl(Raspored raspored) {
        this.raspored = raspored;
    }

    @Override
    public List<Termin> slobodniTerminiUProstoru(LocalDate date, Prostor prostor) {
        return null;
    }

    public List<Termin> getSlobodneTermineZaDatum(LocalDate date, int minutes) {
        List<Termin> slobodniTermini = new ArrayList<>();
        for (Prostor prostor : raspored.getProstorije()) {
            slobodniTermini.addAll(getSlobodneTermineZaDatumIProstoriju(date,minutes,prostor));
        }
        return slobodniTermini;
    }

    public List<Termin> getSlobodneTermineZaDatumIProstoriju(LocalDate date, int minutes, Prostor prostor) {
        List<Termin> slobodniTermini = new ArrayList<>();
        for (LocalDateTime start = date.atStartOfDay(); start.isBefore(date.plusDays(1).atStartOfDay()); start = start.plusMinutes(15)) {
            for (Termin zauzetiTermin : raspored.getTermini()) {
                Termin termin = new Termin(new Trajanje(start, minutes), prostor);
                if (!Termin.intercept(zauzetiTermin, termin)) {
                    slobodniTermini.add(termin);
                }
            }
        }
        return slobodniTermini;
    }

    @Override
    public List<Termin> slobodanNastavnik(LocalDate date, int minutes, String nastavnik) {
        List<VezaniPodatak> vezaniPodataks = new ArrayList<>();
        vezaniPodataks.add(new Profesor(nastavnik));
        return getSlobodneTermineZaDatum(date,minutes,new KriterijumRequest(vezaniPodataks));
    }


    public List<Termin> terminiNastavnika(String nastavnik) {
        List<VezaniPodatak> vezaniPodataks = new ArrayList<>();
        vezaniPodataks.add(new Profesor(nastavnik));
        return raspored.getTermini().stream().filter(termin ->
                terminZadovoljavaKriterijume(termin,new KriterijumRequest(vezaniPodataks))).toList();
    }

    public List<Termin> getSlobodneTermineZaDatum(LocalDate date, int minutes, KriterijumRequest kriterijumRequest) {
        return getSlobodneTermineZaDatum(date,minutes).stream()
                .filter(slobodanTermin->terminZadovoljavaKriterijume(slobodanTermin,kriterijumRequest))
                .toList();
    }

    // za svaki vezani podatak iz prostorije mi radimo da li se kriterijum zadovoljava za svaki kriterijum iz requesta
    // ako je kriterijumrequest grupe 102 i 103, broj racunara 300
    // u listi vezanih podataka ako pozove brojracunara.kriterijumzadovoljava(grupe) vraca true
    public boolean prostorijaZadovoljavaKriterijume(Prostor prostor, KriterijumRequest kriterijumRequest){
        return prostor.getVezaniPodaci().stream().allMatch(vezaniPodatak ->
                kriterijumRequest.getVezaniPodaci().stream().allMatch(vezaniPodatak::kriterijumZadovoljava)
        ) && kriterijumRequest.getVezaniPodaci().stream().allMatch(kriterijum ->
                prostor.getBrojRacunara().kriterijumZadovoljava(kriterijum) &&
                        prostor.getKapacitet().kriterijumZadovoljava(kriterijum) &&
                        prostor.getGrafickaTabla().kriterijumZadovoljava(kriterijum) &&
                        prostor.getProjektor().kriterijumZadovoljava(kriterijum)
        );
    }

    public boolean terminZadovoljavaKriterijume(Termin termin, KriterijumRequest kriterijumRequest){
        return termin.getVezaniPodaci().stream().allMatch(vezaniPodatak ->
                kriterijumRequest.getVezaniPodaci().stream().allMatch(vezaniPodatak::kriterijumZadovoljava)
        ) && prostorijaZadovoljavaKriterijume(termin.getProstor(),kriterijumRequest);
    }


    public List<Termin> slobodanZaVreme(SlobodanTerminZaDanRequest request) {

        return null;
    }


    public List<Termin> filterSlobodne(SlobodanTerminZaDanRequest request, Prostor prostor) {
        Trajanje trajanje = request.toTrajanje();
        return null;
    }

    @Override
    public List<Termin> filterSlobodneSaRacunarima(SlobodanTerminRequest request) {
        return null;
    }

    @Override
    public List<Termin> filterSlobodne(SlobodanTerminRequest request, int kapacitet, int brojRacunara, boolean projektor, boolean grafickaTabla) {
        return null;
    }

    @Override
    public List<Termin> filterSlobodne(SlobodanTerminRequest request, KriterijumRequest kriterijumRequest) {
        return null;
    }




}