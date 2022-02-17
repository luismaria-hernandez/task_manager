
package Model;


public class PrioridadesReq 
{
    private int idPrioridadReq;
    private String prioridadReq;

    public PrioridadesReq(int idPrioridadReq, String prioridadReq) {
        this.idPrioridadReq = idPrioridadReq;
        this.prioridadReq = prioridadReq;
    }

    public int getIdPrioridadReq() {
        return idPrioridadReq;
    }

    public void setIdPrioridadReq(int idPrioridadReq) {
        this.idPrioridadReq = idPrioridadReq;
    }

    public String getPrioridadReq() {
        return prioridadReq;
    }

    public void setPrioridadReq(String prioridadReq) {
        this.prioridadReq = prioridadReq;
    }
    
    
}
