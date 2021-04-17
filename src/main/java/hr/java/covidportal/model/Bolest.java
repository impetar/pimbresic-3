package main.java.hr.java.covidportal.model;

/**
 * Predstavlja entiet Bolest
 */
public class Bolest extends ImenovaniEntitet{

   private Simptom[] simptomi;

    /**
     * Inicijalizacija podataka nazivu i simtomima
     * @param naziv podatak o navivu bolesti
     * @param simptomi podatak o simptomu
     */
    public Bolest(String naziv, Simptom[] simptomi) {
        super(naziv);
        this.simptomi = simptomi;
    }

    public Simptom[] getSimptomi() {
        return simptomi;
    }

    public void setSimptomi(Simptom[] simptomi) {
        this.simptomi = simptomi;
    }
}