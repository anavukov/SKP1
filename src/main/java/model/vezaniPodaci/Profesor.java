package model.vezaniPodaci;

import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
public class Profesor extends VezaniPodatak {
    private String ime;
    private String tipProfesora; //asistent ili prof

    public Profesor(String ime) {
        super("profesor");
        this.ime = ime;
        this.tipProfesora = "profesor";
    }

    public Profesor(String ime, String tipProfesora) {
        super("profesor");
        this.ime = ime;
        this.tipProfesora = tipProfesora;
    }

    @Override
    public boolean equalsLogic(Object o) {
        Profesor profesor = (Profesor) o;
        return Objects.equals(ime, profesor.ime) && Objects.equals(tipProfesora, profesor.tipProfesora);
    }

    @Override
    public boolean kriterijumZadovoljava(Object obj) {
        return !(obj instanceof Profesor) || equals(obj);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), ime);
    }
}
