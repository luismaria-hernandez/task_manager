
package DTO;


public class DTOCommentAdhoc 
{
    private int idRespAdhoc;
    private String comment;

    public DTOCommentAdhoc(int idRespAdhoc, String comment) {
        this.idRespAdhoc = idRespAdhoc;
        this.comment = comment;
    }

    public int getIdRespAdhoc() {
        return idRespAdhoc;
    }

    public void setIdRespAdhoc(int idRespAdhoc) {
        this.idRespAdhoc = idRespAdhoc;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

}
