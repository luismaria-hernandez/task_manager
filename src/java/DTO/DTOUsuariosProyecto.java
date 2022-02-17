
package DTO;


public class DTOUsuariosProyecto 
{
    private int idUsuario;
    private String nombre;
    private String apellido;
    private String iniciales;

    public DTOUsuariosProyecto(int idUsuario, String nombre, String apellido, String iniciales) {
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.apellido = apellido;
        this.iniciales = iniciales;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
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
