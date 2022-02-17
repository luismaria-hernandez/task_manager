
package Model;


public class Proyectos
{
    private int idProyecto;
    private String nombreProyecto;

    public Proyectos(int idProyecto, String nombreProyecto) {
        this.idProyecto = idProyecto;
        this.nombreProyecto = nombreProyecto;
    }

    
    
    public int getIdProyecto() {
        return idProyecto;
    }

    public void setIdProyecto(int idProyecto) {
        this.idProyecto = idProyecto;
    }

    public String getNombreProyecto() {
        return nombreProyecto;
    }

    public void setNombreProyecto(String nombreProyecto) {
        this.nombreProyecto = nombreProyecto;
    }

    
    
}
