package ar.com.api.inmobiliaria.excepciones;

import ar.com.api.inmobiliaria.entities.Inmobiliaria;

/**
 * InmobiliariaException
 */
public class InmobiliariaException extends Exception{

    public InmobiliariaException(Inmobiliaria i, String mensaje) {
        super(i.getNombre() + ":" + mensaje);
    }

    
}