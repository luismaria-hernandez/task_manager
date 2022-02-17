
package Model;


public class Usuarios 
{
    private int idUsuario;
    private int idTipoUsuario;
    private String nombre;
    private String apellido;
    private String mailGlobant;
    private String iniciales;
    private int idProyecto;

    public Usuarios(int idUsuario, int idTipoUsuario, String nombre, String apellido, String mailGlobant, String iniciales, int idProyecto) {
        this.idUsuario = idUsuario;
        this.idTipoUsuario = idTipoUsuario;
        this.nombre = nombre;
        this.apellido = apellido;
        this.mailGlobant = mailGlobant;
        this.iniciales = iniciales;
        this.idProyecto = idProyecto;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdTipoUsuario() {
        return idTipoUsuario;
    }

    public void setIdTipoUsuario(int idTipoUsuario) {
        this.idTipoUsuario = idTipoUsuario;
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
