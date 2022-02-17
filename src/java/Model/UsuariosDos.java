
package Model;


public class UsuariosDos 
{
    private String nombre;
    private String apellido;
    private String mailGlobant;
    private String clave;
    private int idTipoUsuario;
    private String iniciales;
    private int idProyecto;

    public UsuariosDos(String nombre, String apellido, String mailGlobant, String clave, int idTipoUsuario, String iniciales, int idProyecto) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.mailGlobant = mailGlobant;
        this.clave = clave;
        this.idTipoUsuario = idTipoUsuario;
        this.iniciales = iniciales;
        this.idProyecto = idProyecto;
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

    public String getMailGlobant() {
        return mailGlobant;
    }

    public void setMailGlobant(String mailGlobant) {
        this.mailGlobant = mailGlobant;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public int getIdTipoUsuario() {
        return idTipoUsuario;
    }

    public void setIdTipoUsuario(int idTipoUsuario) {
        this.idTipoUsuario = idTipoUsuario;
    }

    public String getIniciales() {
        return iniciales;
    }

    public void setIniciales(String iniciales) {
        this.iniciales = iniciales;
    }

    public int getIdProyecto() {
        return idProyecto;
    }

    public void setIdProyecto(int idProyecto) {
        this.idProyecto = idProyecto;
    }
    
    
}
