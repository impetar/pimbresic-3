package main.java.hr.java.covidportal.model;

/**
 * Predstavlja entitet Simptom
 */
public class Simptom extends ImenovaniEntitet {

    private String vrijednost;

    /**
     * Inicijalizacija podataka o nazivu i vrijednosti
     * @param naziv         podatak o nazivu simptoma
     * @param vrijednost    podatak o vrijednosti simptoma
     */
    public Simptom(String naziv, String vrijednost) {
        super(naziv);
        this.vrijednost = vrijednost;
    }

    public String getVrijednost() {
        return vrijednost;
    }

    public void setVrijednost(String vrijednost) {
        this.vrijednost = vrijednost;
    }
}
