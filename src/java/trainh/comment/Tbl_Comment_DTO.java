/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trainh.comment;

import java.io.Serializable;
import java.sql.Date;

/**
 *
 * @author trainh
 */
public class Tbl_Comment_DTO implements Serializable{
    
    private int articleID;
    private String email;
    private String comment;
    private Date date;

    public Tbl_Comment_DTO() {
    }

    public Tbl_Comment_DTO(String email, String comment) {
        this.email = email;
        this.comment = comment;
    }

    public Tbl_Comment_DTO(int articleID, String email, String comment, Date date) {
        this.articleID = articleID;
        this.email = email;
        this.comment = comment;
        this.date = date;
    }

    public int getArticleID() {
        return articleID;
    }

    public void setArticleID(int articleID) {
        this.articleID = articleID;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    
}
