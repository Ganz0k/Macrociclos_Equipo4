package excepciones;

public class PersistenciaException extends RuntimeException {
    
    public PersistenciaException(String mensaje) {
        super(mensaje);
    }

    public PersistenciaException(Throwable causa) {
        super(causa);
    }

    public PersistenciaException(String mensaje, Throwable causa) {
        super(mensaje, causa);
    }
}
