package model.vezaniPodaci;

import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
public class Predmet extends VezaniPodatak {
    private String predmet;

    public Predmet(String predmet) {
        super("predmet");
        this.predmet = predmet;
    }

    @Override
    public boolean equalsLogic(Object o) {
        return Objects.equals(this.predmet, ((Predmet) o).predmet);
    }

    @Override
    public boolean kriterijumZadovoljava(Object obj) {
        return !(obj instanceof Predmet) || equals(obj);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), predmet);
    }
}
