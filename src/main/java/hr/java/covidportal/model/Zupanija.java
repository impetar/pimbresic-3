package main.java.hr.java.covidportal.model;

/**
 * Predstavlja entitet Zupanija koji definira naziv i broj stanovnika
 */
public class Zupanija extends ImenovaniEntitet {


    private Integer brojStanovnika;

    /**
     * Inicijalizacija podataka s nazivom i brojem stanovnika
     * @param naziv             podatak o nazivu
     * @param brojStanovnika    podataka o broju simptoma
     */
    public Zupanija(String naziv, Integer brojStanovnika) {
        super(naziv);
        this.brojStanovnika = brojStanovnika;
    }

    public Integer getBrojStanovnika() {
        return brojStanovnika;
    }

    public void setBrojStanovnika(Integer brojStanovnika) {
        this.brojStanovnika = brojStanovnika;
    }
}
