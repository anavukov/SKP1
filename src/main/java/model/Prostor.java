package model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import model.vezaniPodaci.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Getter
@Setter
@AllArgsConstructor
public class Prostor {
    private String naziv;
    private Kapacitet kapacitet;
    private BrojRacunara brojRacunara;
    private Projektor projektor;
    private GrafickaTabla grafickaTabla;
    private List<VezaniPodatak> vezaniPodaci;

    public Prostor(String naziv, int kapacitet, int brojRacunara, boolean projektor, boolean grafickaTabla) {
        this.naziv = naziv;
        this.kapacitet = new Kapacitet(kapacitet);
        this.brojRacunara = new BrojRacunara(brojRacunara);
        this.projektor = new Projektor(projektor);
        this.grafickaTabla = new GrafickaTabla(grafickaTabla);
        vezaniPodaci = new ArrayList<>();
    }

    public Prostor(String naziv, List<VezaniPodatak> vezaniPodaci) {
        this.naziv = naziv;
        for(VezaniPodatak vezaniPodatak:vezaniPodaci){
            if(vezaniPodatak instanceof Kapacitet kapacitet)
                this.kapacitet = kapacitet;
            if(vezaniPodatak instanceof BrojRacunara brojRacunara)
                this.brojRacunara = brojRacunara;
            if(vezaniPodatak instanceof Projektor projektor)
                this.projektor = projektor;
            if(vezaniPodatak instanceof GrafickaTabla grafickaTabla)
                this.grafickaTabla = grafickaTabla;
        }
        this.vezaniPodaci = vezaniPodaci;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Prostor prostor)) return false;
        return Objects.equals(naziv, prostor.naziv);
    }

    @Override
    public int hashCode() {
        return Objects.hash(naziv);
    }

    public void addVezaniPodatak(VezaniPodatak vezaniPodatak) {
        Optional<VezaniPodatak> present = vezaniPodaci.stream().filter(vezaniPodatak1 ->
                vezaniPodatak1.getNaziv().equalsIgnoreCase(vezaniPodatak.getNaziv())
        ).findFirst();

        present.ifPresent(podatak -> vezaniPodaci.remove(podatak));
        vezaniPodaci.add(vezaniPodatak);
    }
}
