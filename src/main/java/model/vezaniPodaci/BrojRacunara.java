package model.vezaniPodaci;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BrojRacunara extends VezaniPodatak{
    private int brojRacunara;

    public BrojRacunara( int brojRacunara) {
        super("brojracunara");
        this.brojRacunara = brojRacunara;
    }

    @Override
    public boolean equalsLogic(Object obj) {
        return ((BrojRacunara)obj).brojRacunara==brojRacunara;
    }

    @Override
    public boolean kriterijumZadovoljava(Object obj) {
        return !(obj instanceof BrojRacunara) || this.brojRacunara >= ((BrojRacunara) obj).brojRacunara;
    }
}