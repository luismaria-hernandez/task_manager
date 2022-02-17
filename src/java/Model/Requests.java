
package Model;

import java.sql.Date;


public class Requests 
{
    private int idRequest;
    private String tituloRequest;
    private String linkTicket;
    private String prioridadRequest;
    private String estado;
    private Date fecha;

    public Requests(int idRequest, String tituloRequest, String linkTicket, String prioridadRequest, String estado, Date fecha) {
        this.idRequest = idRequest;
        this.tituloRequest = tituloRequest;
        this.linkTicket = linkTicket;
        this.prioridadRequest = prioridadRequest;
        this.estado = estado;
        this.fecha = fecha;
    }

    public int getIdRequest() {
        return idRequest;
    }

    public void setIdRequest(int idRequest) {
        this.idRequest = idRequest;
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

    public String getPrioridadRequest() {
        return prioridadRequest;
    }

    public void setPrioridadRequest(String prioridadRequest) {
        this.prioridadRequest = prioridadRequest;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    
    
 
    
}
