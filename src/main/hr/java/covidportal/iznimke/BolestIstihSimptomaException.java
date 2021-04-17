package main.hr.java.covidportal.iznimke;

//neoznačena iznimka

public class BolestIstihSimptomaException extends Exception {
    public BolestIstihSimptomaException() {
    }

public BolestIstihSimptomaException(String message) {
        super(message);
    }

    public BolestIstihSimptomaException(String message, Throwable cause) {
        super(message, cause);
    }

    public BolestIstihSimptomaException(Throwable cause) {
        super(cause);
    }

    public BolestIstihSimptomaException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
