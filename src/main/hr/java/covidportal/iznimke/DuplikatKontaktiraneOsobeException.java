package main.hr.java.covidportal.iznimke;

/**
 * Predstavlja označneu iznimku  DuplikatKontaktiraneOsobeException
 */
public class DuplikatKontaktiraneOsobeException extends  Exception{
    public DuplikatKontaktiraneOsobeException() {
    }

    /**
     * Inicijalizacija iznimke
     * @param message poruka
     *
     */
    public DuplikatKontaktiraneOsobeException(String message) {
        super(message);
    }

    /**
     * Inicijalizacija iznimke
     * @param message   poruka
     * @param cause     uzrok
     */
    public DuplikatKontaktiraneOsobeException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Inicijalizacija iznimke
     * @param cause  uzrok
     */
    public DuplikatKontaktiraneOsobeException(Throwable cause) {
        super(cause);
    }

}
