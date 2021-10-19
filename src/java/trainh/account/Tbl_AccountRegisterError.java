/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trainh.account;

import java.io.Serializable;

/**
 *
 * @author trainh
 */
public class Tbl_AccountRegisterError implements Serializable{
    private String emailRegisterError;
    private String nameRegisterError;
    private String passwordRegisterError;

    public Tbl_AccountRegisterError() {
    }

    public Tbl_AccountRegisterError(String emailRegisterError, String nameRegisterError, String passwordRegisterError) {
        this.emailRegisterError = emailRegisterError;
        this.nameRegisterError = nameRegisterError;
        this.passwordRegisterError = passwordRegisterError;
    }

    public String getEmailRegisterError() {
        return emailRegisterError;
    }

    public void setEmailRegisterError(String emailRegisterError) {
        this.emailRegisterError = emailRegisterError;
    }

    public String getNameRegisterError() {
        return nameRegisterError;
    }

    public void setNameRegisterError(String nameRegisterError) {
        this.nameRegisterError = nameRegisterError;
    }

    public String getPasswordRegisterError() {
        return passwordRegisterError;
    }

    public void setPasswordRegisterError(String passwordRegisterError) {
        this.passwordRegisterError = passwordRegisterError;
    }
    
}
