
package Model;

import java.util.Calendar;
import java.util.Date;


public class FixesDos 
{
    private String tituloFix;
    private String linkTicket;
    private int idPrioridadFix;
    private String fecha;
    private String adminComment;
    private int idEstado;
    private int idSprint;
    private boolean bandera;

    public FixesDos(String tituloFix, String linkTicket, int idPrioridadFix, String fecha, String adminComment, int idEstado, int idSprint, boolean bandera) {
        this.tituloFix = tituloFix;
        this.linkTicket = linkTicket;
        this.idPrioridadFix = idPrioridadFix;
        this.fecha = fecha;
        this.adminComment = adminComment;
        this.idEstado = idEstado;
        this.idSprint = idSprint;
        this.bandera = bandera;
    }

    public String getTituloFix() {
        return tituloFix;
    }

    public void setTituloFix(String tituloFix) {
        this.tituloFix = tituloFix;
    }

    public String getLinkTicket() {
        return linkTicket;
    }

    public void setLinkTicket(String linkTicket) {
        this.linkTicket = linkTicket;
    }

    public int getIdPrioridadFix() {
        return idPrioridadFix;
    }

    public void setIdPrioridadFix(int idPrioridadFix) {
        this.idPrioridadFix = idPrioridadFix;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getAdminComment() {
        return adminComment;
    }

    public void setAdminComment(String adminComment) {
        this.adminComment = adminComment;
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

    public boolean isBandera() {
        return bandera;
    }

    public void setBandera(boolean bandera) {
        this.bandera = bandera;
    }

   

   
}
