package main.hr.java.covidportal.iznimke;

public class PonovljenaBolestIliVirusException extends RuntimeException {
        /*
1.      Rješenje zadatka za pripremu proširiti na način da se doda nova neoznačena iznimka
 „PonovljenaBolestIliVirusException“ koja se baca u slučaju kad se unese virus s nazivom i
  simptomima koji već ima neka druga bolest ili ako se unese bolest s nazivom i simptomima
  koji već ima neki drugi virus. Od korisnika je potrebno zatražiti ponovni unos osobe u
  slučaju kad se baci iznimka „PonovljenaBolestIliVirusException“. Informaciju o iznimci je
  potrebno zabilježiti i u log datoteku. Provjeru je li unesena ponovljena osoba potrebno
  je obaviti u zasebnoj metodi.
2.      Osim toga je potrebno bilježiti koliko puta je korisnik unio ponovljenu bolest ili
 virus. Ako je tri puta unio ponovljenu bolest ili virus, potrebno je ispisati informaciju
 o tome i prekinuti rad programa.
     */


    public PonovljenaBolestIliVirusException() {
    }

    public PonovljenaBolestIliVirusException(String message) {
        super(message);
    }

    public PonovljenaBolestIliVirusException(String message, Throwable cause) {
        super(message, cause);
    }

    public PonovljenaBolestIliVirusException(Throwable cause) {
        super(cause);
    }

    public PonovljenaBolestIliVirusException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
