package main.hr.java.covidportal.iznimke;

public class DuplikatKontaktiraneOsobeException extends  Exception{
    public DuplikatKontaktiraneOsobeException() {
    }

    public DuplikatKontaktiraneOsobeException(String message) {
        super(message);
    }

    public DuplikatKontaktiraneOsobeException(String message, Throwable cause) {
        super(message, cause);
    }

    public DuplikatKontaktiraneOsobeException(Throwable cause) {
        super(cause);
    }

    public DuplikatKontaktiraneOsobeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
