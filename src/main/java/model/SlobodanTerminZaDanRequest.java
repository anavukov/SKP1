package model;

import model.Trajanje;
import request.SlobodanTerminRequest;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

// construktore getere seete izbaciti toTrajanje u specifikaciji i mvn clean install ovde obrisati totraajnje
public class SlobodanTerminZaDanRequest extends SlobodanTerminRequest {
    private LocalDate date;
    private int minuti;


    //obrisati
    @Override
    public Trajanje toTrajanje(){

        return null;
    }
}
