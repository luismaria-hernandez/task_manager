
package Model;


public class Asignados 
{
    private String iniciales;

    public Asignados(String iniciales) {
        this.iniciales = iniciales;
    }

    public String getIniciales() {
        return iniciales;
    }

    public void setIniciales(String iniciales) {
        this.iniciales = iniciales;
    }

    @Override
    public String toString() {
        return iniciales;
    }
    
    
    
}
