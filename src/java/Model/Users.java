
package Model;


public class Users 
{
    private int idUsuario;
    private String nombre;
    private String apellido;
    private String mailGlobant;
    private String tipoUsuario;
    private String ini;
    private String nombreProyecto; 

    public Users(int idUsuario, String nombre, String apellido, String mailGlobant, String tipoUsuario, String ini, String nombreProyecto) {
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.apellido = apellido;
        this.mailGlobant = mailGlobant;
        this.tipoUsuario = tipoUsuario;
        this.ini = ini;
        this.nombreProyecto = nombreProyecto;
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

    public String getMailGlobant() {
        return mailGlobant;
    }

    public void setMailGlobant(String mailGlobant) {
        this.mailGlobant = mailGlobant;
    }

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public String getIni() {
        return ini;
    }

    public void setIni(String ini) {
        this.ini = ini;
    }

    public String getNombreProyecto() {
        return nombreProyecto;
    }

    public void setNombreProyecto(String nombreProyecto) {
        this.nombreProyecto = nombreProyecto;
    }

    @Override
    public String toString() {
        return nombre + " "+ apellido + " - " + ini;
    }
    
    
}
