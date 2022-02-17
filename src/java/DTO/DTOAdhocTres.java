
package DTO;

public class DTOAdhocTres 
{
    private String tituloTicket;
    private String linkTicket;
    private int idEstado;
    private int idEstadoAdhoc;
    private int idSprint;
    private String fecha;

    public DTOAdhocTres(String tituloTicket, String linkTicket, int idEstado, int idEstadoAdhoc, int idSprint, String fecha) {
        this.tituloTicket = tituloTicket;
        this.linkTicket = linkTicket;
        this.idEstado = idEstado;
        this.idEstadoAdhoc = idEstadoAdhoc;
        this.idSprint = idSprint;
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

    public int getIdEstadoAdhoc() {
        return idEstadoAdhoc;
    }

    public void setIdEstadoAdhoc(int idEstadoAdhoc) {
        this.idEstadoAdhoc = idEstadoAdhoc;
    }

    public int getIdSprint() {
        return idSprint;
    }

    public void setIdSprint(int idSprint) {
        this.idSprint = idSprint;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    
    
}
