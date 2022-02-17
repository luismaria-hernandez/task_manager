
package Model;


public class RespuestaRequest 
{
    private int idRespReq;
    private String respuesta;

    public RespuestaRequest(int idRespReq, String respuesta) {
        this.idRespReq = idRespReq;
        this.respuesta = respuesta;
    }

    public int getIdRespReq() {
        return idRespReq;
    }

    public void setIdRespReq(int idRespReq) {
        this.idRespReq = idRespReq;
    }

    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }

    
    
}
