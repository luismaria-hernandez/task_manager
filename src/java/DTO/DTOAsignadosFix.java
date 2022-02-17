
package DTO;


public class DTOAsignadosFix 
{
    private int idUsuarioFix;
    private String nombre;
    private String apellido;
    private String iniciales;

    public DTOAsignadosFix(int idUsuarioFix, String nombre, String apellido, String iniciales) {
        this.idUsuarioFix = idUsuarioFix;
        this.nombre = nombre;
        this.apellido = apellido;
        this.iniciales = iniciales;
    }

    public int getIdUsuarioFix() {
        return idUsuarioFix;
    }

    public void setIdUsuarioFix(int idUsuarioFix) {
        this.idUsuarioFix = idUsuarioFix;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getIniciales() {
        return iniciales;
    }

    public void setIniciales(String iniciales) {
        this.iniciales = iniciales;
    }

    @Override
    public String toString() {
        return this.nombre+" "+this.apellido+" - "+this.iniciales;
    }
    
}
