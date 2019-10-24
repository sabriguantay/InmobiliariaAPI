package ar.com.api.inmobiliaria.excepciones;

import ar.com.api.inmobiliaria.entities.Inmobiliaria;

/**
 * InmobiliariaException
 */
public class InmobiliariaException extends Exception{

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public InmobiliariaException(Inmobiliaria i, String mensaje) {
        super(i.getNombre() + ":" + mensaje);
    }
    
}