package model.vezaniPodaci;

import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Getter
@Setter
public class Grupe extends VezaniPodatak {
    private Set<String> grupe;

    public Grupe(Set<String> grupe) {
        super("grupe");
        this.grupe = grupe;
    }

    public Grupe() {
        super("grupe");
        grupe = new HashSet<>();
    }

    public void addGrupa(String grupa){
        grupe.add(grupa);
    }

    @Override
    public boolean equalsLogic(Object o) {
        return Objects.equals(grupe, ((Grupe)o).grupe);
    }

    @Override
    public boolean kriterijumZadovoljava(Object obj) {
        return !(obj instanceof Grupe) || this.grupe.containsAll(((Grupe)obj).grupe);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), grupe);
    }
}
