package main.java.hr.java.covidportal.model;

/**
 * Predstavlja entitet ImenovaniEntitet koji definira naziv
 */
public abstract class ImenovaniEntitet {
    private String naziv;

    /**
     * Inicijalizacija podatakao nazivu
     * @param naziv
     */
    public ImenovaniEntitet(String naziv) {
        this.naziv = naziv;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }
}
