package main.java.hr.java.covidportal.main;

import main.hr.java.covidportal.iznimke.BolestIstihSimptomaException;
import main.hr.java.covidportal.iznimke.DuplikatKontaktiraneOsobeException;
import main.hr.java.covidportal.iznimke.PonovljenaBolestIliVirusException;
import main.java.hr.java.covidportal.model.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Služi za pokretanje programa za evidenciju ljudi zaraženih po županijama te njihove kontakte. Obrađuje klase, objekte, nasljeđivanje, označene i neoznačene izmnike.
 * Sadrži definirane konstante za brojčani unos simptoma, bolesti, zupanija, osoba.
 */

public class Glavna {
    private static Logger log = LoggerFactory.getLogger(Glavna.class);

    public  static final int BROJ_SIMPTOMA = 2;
    public  static final int BROJ_BOLESTI = 2;
    public static final int BROJ_ZUPANIJA=2;
    public static final int BROJ_OSOBA=2;

    /**
     * Služi za pokretanje programa za evidenciju Covid bolesnika.
     * Nakon usiješnog unosa traženih podataka program ih spremi u polja.
     * @param args argumenti komande linije se ne koriste.
     */
    public static void main(String[] args) {
        log.info("Program je pokrenut.");
        Scanner ulaz = new Scanner(System.in);

        Zupanija[] zupanije = new Zupanija[BROJ_ZUPANIJA];
        Simptom[] simptomi = new Simptom[BROJ_SIMPTOMA];
        Bolest[] bolesti = new Bolest[BROJ_BOLESTI];
        Osoba[] osobe = new Osoba[BROJ_OSOBA];

        System.out.println("UNOS PODATAKA ZA " + BROJ_ZUPANIJA + ". ŽPANIJE ");
        System.out.println("------------------------------------------------");
        log.info("Započet unos županija.");
        for (int i = 0; i < BROJ_ZUPANIJA; i++) {
            zupanije[i] = unosZupanija(ulaz, i);
        }
        log.info("Završen unos županija.");


        System.out.println("UNOS PODATAKA ZA " + BROJ_SIMPTOMA + ". SIMPTOMA ");
        System.out.println("------------------------------------------------");


        log.info("Započet unos simptoma.");
        for (int i = 0; i < BROJ_SIMPTOMA; i++) {

            simptomi[i] = unosSimptoma(ulaz, i);

        }
        log.info("Završen unos simptoma.");
        System.out.println("UNOS PODATAKA ZA " + BROJ_BOLESTI + ". BOLESTI");


        log.info("Započet unos bolesti.");
        for (int i = 0; i < BROJ_BOLESTI; i++) {

            bolesti[i] = unosBolesti(ulaz, simptomi, bolesti, i);
        }


        System.out.println("UNOS PODATAKA ZA " + BROJ_OSOBA + ". OSOBE");
        System.out.println("------------------------------------------------");

        for (int i = 0; i < BROJ_OSOBA; i++) {

            try {
                osobe[i]=unosOsoba(ulaz, zupanije, bolesti, osobe, i);
            } catch (DuplikatKontaktiraneOsobeException e) {
                System.out.println(e.getMessage());
                i--;
            }



        }

        log.info("Aplikacija je zavrsila s radom!");
    }


    /**
     * Služi za provjeru unosa duplih osoba.
     * Ukoliko se unese ista osoba poziva se exception.
     * @param osobe se koristie za provjeru sa imenom, prezimenom te starosti osobe.
     * @param ime koriste se za usporedbu sa listom osobe.
     * @param prezime koristi se za usporedbu s listom osobe.
     * @param starost kokoristi se za usporedbu s listom osobe.
     * @throws DuplikatKontaktiraneOsobeException  Ukoliko je unesne osoba sa istim imenom, prezimenom i starosti.
     */
    private static void provjeriDuplikate(Osoba[] osobe,String ime, String prezime,
                                          Integer starost) throws DuplikatKontaktiraneOsobeException {

        for (int i = 0; i < osobe.length; i++) {
            Osoba osobaIzLise = osobe[i];

            if (osobaIzLise!=null && osobaIzLise.getIme().equals(ime) && osobaIzLise.getPrezime().equals(prezime) &&
                    osobaIzLise.getStarost().equals(starost)) {
                throw  new DuplikatKontaktiraneOsobeException("Osoba već postoji");

            }
        }
    }

    /**
     * Koristi za provjeru unesenih duplih nazova bolesti.
     * Ukoliko je naziv bolesti jednak za dvije bolesti javlja se exception.
     * @param bolesti Korisite se za usporedbu sa nazivom bolesti.
     * @param nazivBolesti Koristi se za usporedbu sa listom bolesti.
     * @throws BolestIstihSimptomaException Poziva se ako se naziv i naziv iz liste jednak,
     */

    private static void provjeriDubpleBolestiIVirusa(Bolest[] bolesti, String nazivBolesti) throws BolestIstihSimptomaException {
        for(int i = 0; i < bolesti.length; i++) {
            Bolest bolestiIzListe = bolesti[i];

            if(bolestiIzListe!=null && bolestiIzListe.getNaziv().equals(nazivBolesti)){
                throw new BolestIstihSimptomaException ("Ta bolest je već UNESENA!!! ");
            }
        }

    }

    /**
     * Služi za unos i popunjavanje liste sa zupanijama.
     * @param ulaz KOrisite se kao ulaz informacija sa tipkovnice u aplikaciju.
     * @param i Korisie za informaciju o broju unosa.
     * @return Vraca popunjenu jednu listu uz količinu definiranih konstanti.
     */

    private static Zupanija unosZupanija(Scanner ulaz, int i) {
        System.out.print("Unesi naziv " + (i + 1) + ". županije: ");

        String nazivZupanija = ulaz.nextLine();
        log.trace("Unesen je naziv zupanije! "+   (i+1) + " "+ nazivZupanija);

        Boolean greska;
        Integer brojStanovnikaZupanija = null;
        do {
            greska = false;
            try {
                System.out.print("Unesi broj stanovnika: ");
                brojStanovnikaZupanija = ulaz.nextInt();

            } catch (InputMismatchException ex) {
                ulaz.nextLine();
                greska = true;
                System.out.println("Pogreška u formatu podataka, molimo ponovite unos!");
                log.info("Unesen je pogresni tip podatka!");
                log.error(ex.getMessage(), ex);;
            }
        } while (greska);

        Zupanija novaZupanija = new Zupanija(nazivZupanija, brojStanovnikaZupanija);

        ulaz.nextLine();

        return novaZupanija;


    }

    /**
     * Metodo služi za unos osoba te zupanija bolesti i kontakitranih osoba
     *
     * @param ulaz  scanner
     * @param zupanije lista zupaija
     * @param bolesti list bolest
     * @param osobe  listsa osoba
     * @param i brojač
     * @return novu osobu
     * @throws DuplikatKontaktiraneOsobeException
     */

    private static Osoba unosOsoba(Scanner ulaz, Zupanija[] zupanije, Bolest[] bolesti, Osoba[] osobe, int i) throws DuplikatKontaktiraneOsobeException {
        System.out.print("Unesi ime " + (i + 1) + ". osobe: ");
        String imeOsoba = ulaz.nextLine();
        log.trace("Unesen je ime zupanije! "+   (i+1) + " "+ imeOsoba);

        System.out.print("Unesi prezime osobe: ");
        String prezimeOsoba = ulaz.nextLine();
        log.trace("Unesen je ime prezime! "+   (i+1) + " "+ prezimeOsoba);

        Integer starostOsoba = null;
        Integer izborZupanije = null;
        Integer izborBolesti = null;
        Integer brojKontakata = null;
        boolean greska;
        try {
            System.out.print("Unesi starost osobe: ");
            starostOsoba = ulaz.nextInt();
            ulaz.nextLine();
            log.trace("Unesen je ime storsot osobe!" + starostOsoba);

        } catch (InputMismatchException ex) {
            System.out.println("NESIPRAVAN unos!! Mogući unos samo brojeva.");
            log.error("Došlo je do pogreške u radu aplikacije! {} ", ex.getMessage());
        }

        provjeriDuplikate(osobe, imeOsoba, prezimeOsoba, starostOsoba);

        do {
            greska = false;
            try {
                System.out.println("Odaberite županiju kojoj pripada  osoba: ");
                for (int z = 0; z < BROJ_ZUPANIJA; z++) {
                    System.out.println((z + 1) + ". " + zupanije[z].getNaziv());
                }
                System.out.print("Odabir >> ");
                izborZupanije = ulaz.nextInt();
                ulaz.nextLine();

            } catch (InputMismatchException ex) {
                ulaz.nextLine();
                greska = true;
                System.out.println("NESIPRAVN unos!! SAMO brojevi!");
                log.info("Unesen je pogresni tip podatka!");
                log.error(ex.getMessage(), ex);;            }
        } while (greska);
        Zupanija zupanija = zupanije[izborZupanije - 1];


        do {
            greska = false;
            try {
                System.out.println("Odaberite bolesti osobe: ");
                for (int b = 0; b < BROJ_BOLESTI; b++) {
                    System.out.println((b + 1) + ". " + bolesti[b].getNaziv());
                }
                System.out.println("Odabir >>  ");
                izborBolesti = ulaz.nextInt();
                ulaz.nextLine();
            } catch (InputMismatchException ex) {
                ulaz.nextLine();
                greska = true;
                System.out.println("NESIPRAVN unos!! SAMO brojevi!");
                log.info("Unesen je pogresni tip podatka!");
                log.error(ex.getMessage(), ex);;

            }
        } while (greska);

        Bolest bolest = bolesti[izborBolesti - 1];
        Osoba[] kontaktiraneOsobe;

        if (i > 0) {
            do {
                greska = false;
                try {
                    System.out.println("Unesite broj osoba s kojima je " + imeOsoba + "  bio u kontaku:");
                    brojKontakata = ulaz.nextInt();
                    ////////
                    if(brojKontakata > osobe.length-1){
                        ulaz.nextLine();
                        greska=true;
                        System.out.println("broj kontakat je veči od unesenih!!");

                    }
                } catch (InputMismatchException ex) {
                    ulaz.nextLine();
                    greska = true;
                    System.out.println("NESIPRAVN unos!! SAMO brojevi!");
                    log.info("Unesen je pogresni tip podatka!");
                    log.error(ex.getMessage(), ex);
                }
            } while (greska);


            if (brojKontakata > 0) {
                kontaktiraneOsobe = new Osoba[brojKontakata];

                System.out.println("Odaberite kontakt osobu: ");
                for (int k = 0; k < i; k++) {
                    System.out.println((k + 1) + ". " + osobe[k].getIme() + " " + osobe[k].getPrezime());
                }

                for (int k = 0; k < brojKontakata; k++) {


                    try {
                        System.out.println("Odabir " + (k + 1) + ". osobe s kojima je bio kontakt: ");
                        Integer izborOsobe = ulaz.nextInt();
                        ulaz.nextLine();
                        kontaktiraneOsobe[k] = osobe[izborOsobe - 1];
                    } catch (InputMismatchException ex) {
                        ulaz.nextLine();
                        System.out.println("NESIPRAVN unos!! SAMO brojevi!");
                        log.info("Unesen je pogresni tip podatka!");
                        log.error(ex.getMessage(), ex);
                    }
                }
            } else {
                kontaktiraneOsobe = new Osoba[0];
            }
        } else {
            kontaktiraneOsobe = new Osoba[0];
        }

        Osoba novaOsoba = new Osoba.Builder().saImenom(imeOsoba).saBolesto(bolest)
                .saKontakitranimOsobama(kontaktiraneOsobe).saPrezimenom(prezimeOsoba)
                .saStarosti(starostOsoba).saZupanijom(zupanija).build();

        return novaOsoba;
    }

    /**
     * Metoda služi za unos Bolesti ili Virusa
     *
     * @param ulaz scanner s tipkovnice
     * @param simptomi lista
     * @param bolesti lsita
     * @param i brojač
     * @return bolest
     */

    private static Bolest unosBolesti(Scanner ulaz, Simptom[] simptomi, Bolest[] bolesti, int i) {

        Integer odabranaVrsta;
        Boolean greska;
        Integer brojSimptoma = -1;
        Integer brojsss = BROJ_SIMPTOMA + 1;
        Integer redniBrojOdaranogSimptoma = null;


        do {
            odabranaVrsta = -1;
            System.out.println("------------------------------------------------");
            System.out.println("Unosi se bolest ili virus?");
            System.out.println("1) BOLEST");
            System.out.println("2) VIRUS");
            System.out.print("Odabir>>");
            try {
                odabranaVrsta = ulaz.nextInt();
                if (odabranaVrsta >= 3 || odabranaVrsta <= 0) {
                    System.out.println("Krivi Unos, moguće unjeti samo 1 ili 2");

                }
            } catch (InputMismatchException ex) {
                ulaz.nextLine();
                System.out.println("NESIPRAVAN unos!! SAMO brojevi! ");
                log.info("Unesen je pogresni tip podatka!");
                log.error(ex.getMessage(), ex);
            }
        } while (odabranaVrsta >= 3 || odabranaVrsta <= 0);
        ulaz.nextLine();
        String nazivBolesti;
        Boolean gres;
        do {gres=false;

            System.out.print("Unesite naziv  " + (i + 1) + ". bolesti ili virusa: ");
            nazivBolesti = ulaz.nextLine();

            try {

                provjeriDubpleBolestiIVirusa(bolesti, nazivBolesti);
            } catch (BolestIstihSimptomaException e) {

                log.error("Došlo je do pogreške u radu aplikacije! {} ", e.getMessage());
                System.out.println(e.getMessage());
                log.info("Unesen je pogresni tip podatka!");
                gres=true;

            }//ako nije greska


        }while(gres);

        do {
            greska = false;
            try {
                do {
                    System.out.print("unesite broj simptoma za " + (i + 1) + ". bolest (" + nazivBolesti + "): ");
                    brojSimptoma = ulaz.nextInt();

                    if (brojSimptoma >= brojsss || brojSimptoma <= 0) {
                        System.out.println("Unijeli ste neispravan broj simptoma, ukupno postoji unešno " + BROJ_SIMPTOMA + " simptoma");
                    }

                } while (brojSimptoma >= brojsss || brojSimptoma <= 0);
            } catch (InputMismatchException ex) {
                ulaz.nextLine();
                greska = true;
                System.out.println("NESIPRAVAN unos!! SAMO brojevi!");
                log.info("Unesen je pogresni tip podatka!");
                log.error(ex.getMessage(), ex);
            }
        } while (greska);


        Simptom[] simptomiBolesti = new Simptom[brojSimptoma];


        for (int s = 0; s < brojSimptoma; s++) {
            redniBrojOdaranogSimptoma = -1;

            Boolean gre;
            do {
                gre = false;
                try {
                    do {
                        System.out.println("odaberi " + (s + 1) + ". simptom za bolest (" + nazivBolesti + "):");
                        for (int j = 0; j < BROJ_SIMPTOMA; j++) {
                            System.out.println((j + 1) + ") " + simptomi[j].getNaziv() + " " + simptomi[j].getVrijednost());
                        }
                        System.out.print("Odabir >>");
                        redniBrojOdaranogSimptoma = ulaz.nextInt();

                        if (redniBrojOdaranogSimptoma <= 0 || redniBrojOdaranogSimptoma > BROJ_SIMPTOMA) {
                            System.out.println("Neispravan unos, odabrati redni broj s popisa");
                        }

                    } while (redniBrojOdaranogSimptoma <= 0 || redniBrojOdaranogSimptoma > BROJ_SIMPTOMA);
                } catch (InputMismatchException ex) {
                    ulaz.nextLine();
                    gre = true;
                    System.out.println("NESIPRAVAN unos!! SAMO brojevi!");
                }
            } while (gre);

            Simptom odabraniSimptom = simptomi[redniBrojOdaranogSimptoma - 1];
            simptomiBolesti[s] = odabraniSimptom;

        }

        Bolest bolest;
        switch (odabranaVrsta) {
            case 1:
                bolest = new Bolest(nazivBolesti, simptomiBolesti);
                break;
            case 2:
                bolest = new Virus(nazivBolesti, simptomiBolesti);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + odabranaVrsta);
        }
        ulaz.nextLine();
        return bolest;
    }


    /**
     * Motada za unos simptoma
     *
     * @param ulaz scanner  unso podataka s tipkovnice
     * @param i brojač
     * @return novo uneseni simptom
     */
    private static Simptom unosSimptoma(Scanner ulaz, int i) {
        System.out.print("Unesite naziv  " + (i + 1) + ". simptoma: ");
        String nazivSimptoma = ulaz.nextLine();
        log.trace("Unesen je naziv simptoma! "+   (i+1) + ". "+ nazivSimptoma);

        System.out.print("Unesite vrijednost " + (i + 1) + ". simptoma (RIJETKO, SREDNJE ILI ČESTO): ");
        String vrijednostSimptoma = ulaz.nextLine();
        log.trace("Unesena je vrijednost stimptma ! "+   (i+1) + ". "+ vrijednostSimptoma);


        Simptom noviSimptom = new Simptom(nazivSimptoma, vrijednostSimptoma);
        return noviSimptom;

    }

}