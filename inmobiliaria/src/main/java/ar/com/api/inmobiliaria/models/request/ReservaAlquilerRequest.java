package ar.com.api.inmobiliaria.models.request;

import ar.com.api.inmobiliaria.entities.*;

/**
 * ReservaAlquilerRequest
 */
public class ReservaAlquilerRequest {
    
    public int id;
    public int fecha;
    public Alquiler alquiler;
    public Contrato contrato;
    
}