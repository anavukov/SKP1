package model.vezaniPodaci;

import model.TipCasa;

public class TipCasaPodatak extends VezaniPodatak {
    private TipCasa tipCasa;

    public TipCasaPodatak() {
        super("tipCasa");
    }
    public TipCasaPodatak(TipCasa tipCasa) {
        super("tipCasa");
        this.tipCasa = tipCasa;
    }

    @Override
    public boolean equalsLogic(Object o) {
        return tipCasa.name().equalsIgnoreCase(((TipCasaPodatak)o).tipCasa.name());
    }

    @Override
    public boolean kriterijumZadovoljava(Object obj) {
        return !(obj instanceof TipCasaPodatak) || equals(obj);
    }
}
