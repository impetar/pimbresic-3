package main.java.hr.java.covidportal.model;

/**
 * Predstavlja entite Virus koji je imeplmentiran ktoz zarazno
 */
public class Virus extends Bolest implements Zarazno {

    /**
     * Inicijalizacija podataka o nazivu i simptomu
     * @param naziv     podatak o nazivu
     * @param simptomi  podatak o simptomima
     */
    public Virus(String naziv, Simptom[] simptomi) {
        super(naziv, simptomi);
    }

    @Override
    public void prelazakZarazeNaOsobu(Osoba osoba) {
        osoba.setBolest(this);

    }
}
