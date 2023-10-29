package model;

import exceptions.ZauzetTerminException;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public abstract class Raspored {

    //zauzeti termini
    private List<Termin> termini;
    // moguce prostorije
    private List<Prostor> prostorije;

    private List<Termin> sviTermini;

    public Raspored() {
        termini = new ArrayList<>();
        prostorije = new ArrayList<>();
        sviTermini = new ArrayList<>();
    }

    public Raspored(List<Termin> termini) {
        this.termini = termini;
    }
    //moze da ima naziv ali ne mora, kapacitet mora, projektor i graficku tablu false

    public void addProstorija(int kapacitet, int brojRacunara, boolean projektor){
        addProstorija("Prostorija"+prostorije.size() + 1,kapacitet,brojRacunara,projektor,false);
    }
    public void addProstorijaProjektor(int kapacitet, boolean projektor){
        addProstorija("Prostorija"+prostorije.size() +1,kapacitet,0,projektor,false);
    }
    public void addProstorija(String naziv, int kapacitet, int brojRacunara, boolean projektor){
        addProstorija(naziv,kapacitet,brojRacunara,projektor,false);
    }
    public void addProstorija(
            String naziv,
            int kapacitet,
            int brojRacunara,
            boolean projektor,
            boolean grafickaTabla){
        prostorije.add(new Prostor(naziv,kapacitet,brojRacunara,projektor,grafickaTabla));
    }
    public void addProstorija(
            int kapacitet,
            int brojRacunara,
            boolean projektor,
            boolean grafickaTabla){
        addProstorija("Prostorija"+prostorije.size(),kapacitet,brojRacunara,projektor,grafickaTabla);
    }
    public void addProstorija(Prostor prostor){
        prostorije.add(prostor);
    }

    public void addTermin(Termin termin) throws ZauzetTerminException {
        if(terminZauzet(termin)){
            throw new ZauzetTerminException();
        }else{
            termini.add(termin);
        }
    }

    public void deleteTermin(Termin termin){
        termini.remove(termin);
    }

    public void premestiTermin(Termin termin, Trajanje trajanje) throws ZauzetTerminException {
        deleteTermin(termin);
        termin.setTrajanje(trajanje);
        addTermin(termin);
    }

    public void premestiTermin(Termin termin, Prostor prostor) throws ZauzetTerminException {
        deleteTermin(termin);
        termin.setProstor(prostor);
        addTermin(termin);
    }

    public void premestiTermin(Termin termin, Trajanje trajanje, Prostor prostor) throws ZauzetTerminException {
        deleteTermin(termin);
        termin.setTrajanje(trajanje);
        termin.setProstor(prostor);
        addTermin(termin);
    }


    public abstract boolean terminZauzet(Termin termin);

}
