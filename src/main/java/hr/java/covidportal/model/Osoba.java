package main.java.hr.java.covidportal.model;

public class Osoba {

    private String ime;
    private String prezime;
    private Integer starost;
    private Zupanija zupanija;
    private Bolest bolest;
    private Osoba[] kontaktiraneOsobe;



    public Osoba(String ime, String prezime, Integer starost, Zupanija zupanija, Bolest bolest, Osoba[] kontaktiraneOsobe) {
        this.ime = ime;
        this.prezime = prezime;
        this.starost = starost;
        this.zupanija = zupanija;
        this.bolest = bolest;
        this.kontaktiraneOsobe = kontaktiraneOsobe;
        if(bolest instanceof Virus virus){
            for (Osoba kontakt:kontaktiraneOsobe ){
                virus.prelazakZarazeNaOsobu(kontakt);
            }
        }


    }
private Osoba (){


}
    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public Integer getStarost() {
        return starost;
    }

    public void setStarost(Integer starost) {
        this.starost = starost;
    }

    public Zupanija getZupanija() {
        return zupanija;
    }

    public void setZupanija(Zupanija zupanija) {
        this.zupanija = zupanija;
    }

    public Bolest getBolest() {
        return bolest;
    }

    public void setBolest(Bolest bolest) {
        this.bolest = bolest;
    }

    public Osoba[] getKontaktiraneOsobe() {
        return kontaktiraneOsobe;
    }

    public void setKontaktiraneOsobe(Osoba[] kontaktiraneOsobe) {
        this.kontaktiraneOsobe = kontaktiraneOsobe;
    }

    public static class Builder {
        private String ime;
        private String prezime;
        private Integer starost;
        private Zupanija zupanija;
        private Bolest bolest;
        private Osoba[] kontaktiraneOsobe;

        public Builder (){

        };
        public Builder saImenom(String ime){
            this.ime=ime;
            return this;
        }

        public Builder saPrezimenom(String prezime ){
            this.prezime=prezime ;
            return this;

        }
        public Builder saStarosti(Integer starost ){
            this.starost = starost  ;
            return this;

        }

        public Builder saZupanijom(Zupanija zupanija ){
            this.zupanija  = zupanija   ;
            return this;

        }

        public Builder saBolesto(Bolest bolest ){
            this.bolest  = bolest;
            return this;

        }
        public Builder saKontakitranimOsobama(Osoba[] kontaktiraneOsobe){
            this.kontaktiraneOsobe  = kontaktiraneOsobe   ;
            return this;

        }

        public Osoba build(){
            Osoba osoba = new Osoba();
            osoba.ime =this.ime;
            osoba.prezime = this.prezime;
            osoba.starost = this.starost;
            osoba.zupanija = this.zupanija;
            osoba.bolest = this.bolest;
            osoba.kontaktiraneOsobe = this.kontaktiraneOsobe;
            if(bolest instanceof Virus virus){
                for (Osoba kontakt:kontaktiraneOsobe ){
                    virus.prelazakZarazeNaOsobu(kontakt);
                }
            }
            return osoba;


        }


    }
}