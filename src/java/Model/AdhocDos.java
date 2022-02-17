
package Model;


public class AdhocDos 
{
    private String tituloTicket;
    private String linkTicket;
    private int idEstado;
    private int idSprint;
    private int idEstadosAdhoc;
    private boolean bandera;
    private String fecha;

    public AdhocDos(String tituloTicket, String linkTicket, int idEstado, int idSprint, int idEstadosAdhoc, boolean bandera, String fecha) {
        this.tituloTicket = tituloTicket;
        this.linkTicket = linkTicket;
        this.idEstado = idEstado;
        this.idSprint = idSprint;
        this.idEstadosAdhoc = idEstadosAdhoc;
        this.bandera = bandera;
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

    public int getIdEstadosAdhoc() {
        return idEstadosAdhoc;
    }

    public void setIdEstadosAdhoc(int idEstadosAdhoc) {
        this.idEstadosAdhoc = idEstadosAdhoc;
    }

    public boolean isBandera() {
        return bandera;
    }

    public void setBandera(boolean bandera) {
        this.bandera = bandera;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    
    
}
