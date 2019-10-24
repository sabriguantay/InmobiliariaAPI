package ar.com.api.inmobiliaria.models.request;

import ar.com.api.inmobiliaria.entities.*;

/**
 * ReservaVentaRequest
 */
public class ReservaVentaRequest {

    public int id;
    public int fecha;
    public Venta venta;
    public Contrato contrato;
    
}