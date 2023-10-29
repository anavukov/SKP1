package model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import model.vezaniPodaci.VezaniPodatak;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Getter
@Setter
@AllArgsConstructor
public class Termin {
    @NonNull
    private Trajanje trajanje;
    @NonNull
    private Prostor prostor;
    private List<VezaniPodatak> vezaniPodaci;

    public Termin(@NonNull Trajanje trajanje, @NonNull Prostor prostor) {
        this.trajanje = trajanje;
        this.prostor = prostor;
        vezaniPodaci = new ArrayList<>();
    }

    // za neki vezani podatak u svim zauzetim terminima proverimo da li postoji isti vezani podatak

    public static boolean intercept(Termin termin1, Termin termin2){
        return termin1.prostor.equals(termin2.prostor) && Trajanje.isThereOverlap(termin1.trajanje,termin2.trajanje);
    }



    // ako imamo vec vezani podatak za taj naziv ne treba dodati
    public void addVezaniPodatak(VezaniPodatak vezaniPodatak){
        Optional<VezaniPodatak> present = vezaniPodaci.stream().filter(vezaniPodatak1 ->
                vezaniPodatak1.getNaziv().equalsIgnoreCase(vezaniPodatak.getNaziv())
        ).findFirst();

        if(present.isPresent()) {
            vezaniPodaci.remove(present.get());
        }
        vezaniPodaci.add(vezaniPodatak);
    }


}
