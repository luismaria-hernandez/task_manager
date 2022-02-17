
package DTO;

import java.util.Date;


public class DTOAdhocDos 
{
    private String tituloTicket;
    private String linkTicket;
    private int idEstado;
    private int idSprint;
    private int idEstadoAdhoc;
    private Date fecha;

    public DTOAdhocDos(String tituloTicket, String linkTicket, int idEstado, int idSprint, int idEstadoAdhoc, Date fecha) {
        this.tituloTicket = tituloTicket;
        this.linkTicket = linkTicket;
        this.idEstado = idEstado;
        this.idSprint = idSprint;
        this.idEstadoAdhoc = idEstadoAdhoc;
        this.fecha = fecha;
    }

    public String getTituloTicket() {
        return tituloTicket;
    }

    public void setTituloTicket(String tituloTicket) {
        this.tituloTicket = tituloTicket;
    }

    public String getLinkTicket() {
        return linkTicket;
    }

    public void setLinkTicket(String linkTicket) {
        this.linkTicket = linkTicket;
    }

    public int getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(int idEstado) {
        this.idEstado = idEstado;
    }

    public int getIdSprint() {
        return idSprint;
    }

    public void setIdSprint(int idSprint) {
        this.idSprint = idSprint;
    }

    public int getIdEstadoAdhoc() {
        return idEstadoAdhoc;
    }

    public void setIdEstadoAdhoc(int idEstadoAdhoc) {
        this.idEstadoAdhoc = idEstadoAdhoc;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    
    
}
