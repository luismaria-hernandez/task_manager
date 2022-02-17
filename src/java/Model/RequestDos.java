
package Model;


public class RequestDos 
{
    private String tituloReq;
    private String linkTicket;
    private int idEstado;
    private int idPrioridad;
    private String fecha;
    private String hora;
    private String req;
    private boolean bandera;

    public RequestDos(String tituloReq, String linkTicket, int idEstado, int idPrioridad, String fecha, String hora, String req, boolean bandera) {
        this.tituloReq = tituloReq;
        this.linkTicket = linkTicket;
        this.idEstado = idEstado;
        this.idPrioridad = idPrioridad;
        this.fecha = fecha;
        this.hora = hora;
        this.req = req;
        this.bandera = bandera;
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

    public int getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(int idEstado) {
        this.idEstado = idEstado;
    }

    public int getIdPrioridad() {
        return idPrioridad;
    }

    public void setIdPrioridad(int idPrioridad) {
        this.idPrioridad = idPrioridad;
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

    public boolean isBandera() {
        return bandera;
    }

    public void setBandera(boolean bandera) {
        this.bandera = bandera;
    }

    
}
