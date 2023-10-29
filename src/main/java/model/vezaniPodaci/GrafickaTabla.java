package model.vezaniPodaci;

import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
public class GrafickaTabla extends VezaniPodatak{
    private boolean grafickaTabla;

    public GrafickaTabla(boolean grafickaTabla) {
        super("grafickatabla");
        this.grafickaTabla = grafickaTabla;
    }

    @Override
    public boolean equalsLogic(Object o) {
        return Objects.equals(grafickaTabla, ((GrafickaTabla) o).grafickaTabla);
    }

    @Override
    public boolean kriterijumZadovoljava(Object obj) {
        return !(obj instanceof GrafickaTabla) || equals(obj);
    }
}
