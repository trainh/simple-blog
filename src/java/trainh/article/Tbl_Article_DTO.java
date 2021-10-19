/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trainh.article;

import java.io.Serializable;
import java.sql.Date;

/**
 *
 * @author trainh
 */
public class Tbl_Article_DTO implements Serializable{
    private int articleID;
    private String tital;
    private String shortDescription;
    private String author;
    private Date date;
    private String contentArticle;
    private int status;

    public Tbl_Article_DTO() {
    }

    public Tbl_Article_DTO(int articleID, String tital, String shortDescription, String author, Date date) {
        this.articleID = articleID;
        this.tital = tital;
        this.shortDescription = shortDescription;
        this.author = author;
        this.date = date;
    }

    public Tbl_Article_DTO(int articleID, String tital, String shortDescription, String author, Date date, String contentArticle) {
        this.articleID = articleID;
        this.tital = tital;
        this.shortDescription = shortDescription;
        this.author = author;
        this.date = date;
        this.contentArticle = contentArticle;
    }

    public Tbl_Article_DTO(int articleID, String tital, String shortDescription, String author, Date date, String contentArticle, int status) {
        this.articleID = articleID;
        this.tital = tital;
        this.shortDescription = shortDescription;
        this.author = author;
        this.date = date;
        this.contentArticle = contentArticle;
        this.status = status;
    }

    public int getArticleID() {
        return articleID;
    }

    public void setArticleID(int articleID) {
        this.articleID = articleID;
    }

    public String getTital() {
        return tital;
    }

    public void setTital(String tital) {
        this.tital = tital;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getContentArticle() {
        return contentArticle;
    }

    public void setContentArticle(String contentArticle) {
        this.contentArticle = contentArticle;
    }
    
    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
