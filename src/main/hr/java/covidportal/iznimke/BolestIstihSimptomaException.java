package main.hr.java.covidportal.iznimke;

/**
 * Predstavlja neoznačenu iznimku BolestIstihSimptomaException+
 *
 */
//neoznačena iznimka

public class BolestIstihSimptomaException extends RuntimeException {
    public BolestIstihSimptomaException() {
    }

    /**
     * Inicijalizacija iznimke
     *
     * @param message poruka
     */
    public BolestIstihSimptomaException(String message) {
        super(message);
    }

    /**
     * Inicijalizacija iznimke
     *
     * @param message poruka
     * @param cause   uzrok
     */
    public BolestIstihSimptomaException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Inicijalizacija iznimke
     *
     * @param cause uzrok
     */
    public BolestIstihSimptomaException(Throwable cause) {
        super(cause);
    }
}