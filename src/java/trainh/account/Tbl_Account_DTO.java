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
public class Tbl_Account_DTO implements Serializable {

    private String email;
    private String name;
    private String password;
    private int role;
    private int status;

    public Tbl_Account_DTO() {
    }

    public Tbl_Account_DTO(String email, String name, int role) {
        this.email = email;
        this.name = name;
        this.role = role;
    }

    public Tbl_Account_DTO(String email, String name, String password, int role, int status) {
        this.email = email;
        this.name = name;
        this.password = password;
        this.role = role;
        this.status = status;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

}
