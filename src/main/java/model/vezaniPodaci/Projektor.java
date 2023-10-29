package model.vezaniPodaci;

import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
public class Projektor extends VezaniPodatak{
    private boolean projektor;

    public Projektor( boolean projektor) {
        super("projektor");
        this.projektor = projektor;
    }

    @Override
    public boolean equalsLogic(Object o) {
        return Objects.equals(projektor, ((Projektor) o).projektor);
    }

    @Override
    public boolean kriterijumZadovoljava(Object obj) {
        return !(obj instanceof Projektor) || equals(obj);
    }
}
