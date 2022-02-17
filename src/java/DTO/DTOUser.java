
package DTO;


public class DTOUser 
{
    private int idUsuario;
    private String name;
    private String apellido;
    private String mailGlobant;
    private int idTipoUsuario;
    private String iniciales;
    private int idProyecto;

    public DTOUser(int idUsuario, String name, String apellido, String mailGlobant, int idTipoUsuario, String iniciales, int idProyecto) {
        this.idUsuario = idUsuario;
        this.name = name;
        this.apellido = apellido;
        this.mailGlobant = mailGlobant;
        this.idTipoUsuario = idTipoUsuario;
        this.iniciales = iniciales;
        this.idProyecto = idProyecto;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
