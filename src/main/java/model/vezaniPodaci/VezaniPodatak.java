package model.vezaniPodaci;

import lombok.AllArgsConstructor;
import lombok.Getter;
import model.Equals;

import java.util.Objects;

@Getter
//nasledjuje ga konkretan podatak sa podacima
// mora da implementira equals
@AllArgsConstructor
public abstract class VezaniPodatak implements Equals {
    private String naziv;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof VezaniPodatak that)) return false;
        return Objects.equals(naziv, that.naziv) && equalsLogic(o);
    }

    @Override
    public int hashCode() {
        return Objects.hash(naziv);
    }
}
