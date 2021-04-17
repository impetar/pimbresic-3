package main.java.hr.java.covidportal.model;

// implementacija
public class Virus extends Bolest implements Zarazno {


    public Virus(String naziv, Simptom[] simptomi) {
        super(naziv, simptomi);
    }

    @Override
    public void prelazakZarazeNaOsobu(Osoba osoba) {
        osoba.setBolest(this);

    }
}
