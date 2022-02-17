
package DTO;

import java.sql.Time;
import java.util.Date;


public class DTOReq 
{
    private String tituloRequest;
    private String linkTicket;
    private Date fecha;
    private Time hora;
    private String req;
    private String prioridadReq;
    private String estado;

    public DTOReq(String tituloRequest, String linkTicket, Date fecha, Time hora, String req, String prioridadReq, String estado) {
        this.tituloRequest = tituloRequest;
        this.linkTicket = linkTicket;
        this.fecha = fecha;
        this.hora = hora;
        this.req = req;
        this.prioridadReq = prioridadReq;
        this.estado = estado;
    }

    public String getTituloRequest() {
        return tituloRequest;
    }

    public void setTituloRequest(String tituloRequest) {
        this.tituloRequest = tituloRequest;
    }

    public String getLinkTicket() {
        return linkTicket;
    }

    public void setLinkTicket(String linkTicket) {
        this.linkTicket = linkTicket;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Time getHora() {
        return hora;
    }

    public void setHora(Time hora) {
        this.hora = hora;
    }

    public String getReq() {
        return req;
    }

    public void setReq(String req) {
        this.req = req;
    }

    public String getPrioridadReq() {
        return prioridadReq;
    }

    public void setPrioridadReq(String prioridadReq) {
        this.prioridadReq = prioridadReq;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    
            
}
