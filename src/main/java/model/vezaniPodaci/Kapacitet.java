package model.vezaniPodaci;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Kapacitet extends VezaniPodatak{
    private int kapacitet;

    public Kapacitet( int kapacitet) {
        super("kapacitet");
        this.kapacitet = kapacitet;
    }

    @Override
    public boolean equalsLogic(Object obj) {
        return ((Kapacitet)obj).kapacitet == kapacitet;
    }
    @Override
    public boolean kriterijumZadovoljava(Object obj) {
        return !(obj instanceof Kapacitet) || this.kapacitet >= ((Kapacitet) obj).kapacitet;
    }
}
