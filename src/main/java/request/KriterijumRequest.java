package request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import model.vezaniPodaci.*;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
public class KriterijumRequest {
    //kriterijum za vezani podatak, za prostor
    private List<VezaniPodatak> vezaniPodaci;

    public static KriterijumRequest of(
            Kapacitet kapacitet,
            BrojRacunara brojRacunara,
            GrafickaTabla grafickaTabla,
            Projektor projektor
    ) {
        List<VezaniPodatak> podaci = new ArrayList<>();
        podaci.add(kapacitet);
        podaci.add(projektor);
        podaci.add(grafickaTabla);
        podaci.add(brojRacunara);
        return new KriterijumRequest(podaci);
    }

}
