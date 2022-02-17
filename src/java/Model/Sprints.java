
package Model;


public class Sprints 
{
    private int idSprint;
    private float numeroSprint;
    private String versionBuild;

    public Sprints(int idSprint, float numeroSprint, String versionBuild) {
        this.idSprint = idSprint;
        this.numeroSprint = numeroSprint;
        this.versionBuild = versionBuild;
    }

    public int getIdSprint() {
        return idSprint;
    }

    public void setIdSprint(int idSprint) {
        this.idSprint = idSprint;
    }

    public float getNumeroSprint() {
        return numeroSprint;
    }

    public void setNumeroSprint(float numeroSprint) {
        this.numeroSprint = numeroSprint;
    }

    public String getVersionBuild() {
        return versionBuild;
    }

    public void setVersionBuild(String versionBuild) {
        this.versionBuild = versionBuild;
    }

    @Override
    public String toString() {
        return "SP"+numeroSprint+" - "+versionBuild;
    }

}
