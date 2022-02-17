
package Model;

public class Fixes 
{
    private int idFix;
    private String tituloFix;
    private String linkTicket;
    private String prioridadFix;
    private String estado;
    private String adminComment;

    public Fixes(int idFix, String tituloFix, String linkTicket, String prioridadFix, String estado, String adminComment) {
        this.idFix = idFix;
        this.tituloFix = tituloFix;
        this.linkTicket = linkTicket;
        this.prioridadFix = prioridadFix;
        this.estado = estado;
        this.adminComment = adminComment;
    }

    public int getIdFix() {
        return idFix;
    }

    public void setIdFix(int idFix) {
        this.idFix = idFix;
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

    public String getPrioridadFix() {
        return prioridadFix;
    }

    public void setPrioridadFix(String prioridadFix) {
        this.prioridadFix = prioridadFix;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getAdminComment() {
        return adminComment;
    }

    public void setAdminComment(String adminComment) {
        this.adminComment = adminComment;
    }

    
   
}
