
package DTO;


public class DTOReqDos 
{
    private String tituloReq;
    private String linkTicket;
    private int idPrioridad;
    private int idEstado;
    private String fecha;
    private String hora;
    private String req;

    public DTOReqDos(String tituloReq, String linkTicket, int idPrioridad, int idEstado, String fecha, String hora, String req) {
        this.tituloReq = tituloReq;
        this.linkTicket = linkTicket;
        this.idPrioridad = idPrioridad;
        this.idEstado = idEstado;
        this.fecha = fecha;
        this.hora = hora;
        this.req = req;
    }

    public String getTituloReq() {
        return tituloReq;
    }

    public void setTituloReq(String tituloReq) {
        this.tituloReq = tituloReq;
    }

    public String getLinkTicket() {
        return linkTicket;
    }

    public void setLinkTicket(String linkTicket) {
        this.linkTicket = linkTicket;
    }

    public int getIdPrioridad() {
        return idPrioridad;
    }

    public void setIdPrioridad(int idPrioridad) {
        this.idPrioridad = idPrioridad;
    }

    public int getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(int idEstado) {
        this.idEstado = idEstado;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getReq() {
        return req;
    }

    public void setReq(String req) {
        this.req = req;
    }
    
}
