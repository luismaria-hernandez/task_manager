
package DTO;

import java.util.Date;


public class DTOFixesDos 
{
    private String tituloFix;
    private String linkTicket;
    private int idPrioridadFix;
    private Date fecha;
    private String adminComment;
    private int idEstado;
    private int idSprint;

    public DTOFixesDos(String tituloFix, String linkTicket, int idPrioridadFix, Date fecha, String adminComment, int idEstado, int idSprint) {
        this.tituloFix = tituloFix;
        this.linkTicket = linkTicket;
        this.idPrioridadFix = idPrioridadFix;
        this.fecha = fecha;
        this.adminComment = adminComment;
        this.idEstado = idEstado;
        this.idSprint = idSprint;
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

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
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


}
