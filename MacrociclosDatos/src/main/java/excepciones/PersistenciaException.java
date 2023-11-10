/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package excepciones;

/**
 * 
 * @author luisg
 */
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
