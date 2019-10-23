package ar.com.api.inmobiliaria.models.request;

import ar.com.api.inmobiliaria.entities.*;

/**
 * ReservaCreacionRequest
 */
public class ReservaCreacionRequest {
    //check this
    public int id;
    public int fecha; 
    public Locatario locatario;
    public Inmueble inmueble;
}