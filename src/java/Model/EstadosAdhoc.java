
package Model;

public class EstadosAdhoc 
{
    private int idEstadoAdhoc;
    private String estadoAdhoc;

    public EstadosAdhoc(int idEstadoAdhoc, String estadoAdhoc) {
        this.idEstadoAdhoc = idEstadoAdhoc;
        this.estadoAdhoc = estadoAdhoc;
    }

    public int getIdEstadoAdhoc() {
        return idEstadoAdhoc;
    }

    public void setIdEstadoAdhoc(int idEstadoAdhoc) {
        this.idEstadoAdhoc = idEstadoAdhoc;
    }

    public String getEstadoAdhoc() {
        return estadoAdhoc;
    }

    public void setEstadoAdhoc(String estadoAdhoc) {
        this.estadoAdhoc = estadoAdhoc;
    }
    
    
}
