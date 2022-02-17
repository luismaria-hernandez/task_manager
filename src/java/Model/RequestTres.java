
package Model;

import java.sql.Time;
import java.util.Date;

public class RequestTres 
{
    private String tituloRequest;
    private String linkTicket;
    private Date fecha;
    private Time hora;
    private String req;
    private int idPrioridadRequest;
    private int idEstado;

    public RequestTres(String tituloRequest, String linkTicket, Date fecha, Time hora, String req, int idPrioridadRequest, int idEstado) {
        this.tituloRequest = tituloRequest;
        this.linkTicket = linkTicket;
        this.fecha = fecha;
        this.hora = hora;
        this.req = req;
        this.idPrioridadRequest = idPrioridadRequest;
        this.idEstado = idEstado;
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

    public int getIdPrioridadRequest() {
        return idPrioridadRequest;
    }

    public void setIdPrioridadRequest(int idPrioridadRequest) {
        this.idPrioridadRequest = idPrioridadRequest;
    }

    public int getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(int idEstado) {
        this.idEstado = idEstado;
    }
    
    
}
