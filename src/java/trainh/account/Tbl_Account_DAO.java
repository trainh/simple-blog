/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trainh.account;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.naming.NamingException;
import trainh.utils.DBHelper;
import trainh.utils.MyConstants;

/**
 *
 * @author trainh
 */
public class Tbl_Account_DAO implements Serializable {

    Connection con = null;
    PreparedStatement stm = null;
    ResultSet rs = null;

    private void closeDB() throws SQLException {
        if (rs != null) {
            rs.close();
        }
        if (stm != null) {
            stm.close();
        }
        if (con != null) {
            con.close();
        }
    }

    public Tbl_Account_DTO getAccountByUsernameAndPassword(String email, String password) throws NamingException, SQLException {
        Tbl_Account_DTO dto = null;
        con = DBHelper.getConnect();
        try {
            if (con != null) {
                String sql = "SELECT name, role "
                        + "FROM tbl_Account "
                        + "WHERE email = ? AND password = ? AND status = ?";
                stm = con.prepareStatement(sql);
                stm.setString(1, email);
                stm.setString(2, password);
                stm.setInt(3, MyConstants.STATUS_ACTIVE);
                rs = stm.executeQuery();
                if (rs.next()) {
                    dto = new Tbl_Account_DTO(email, rs.getString("name"), rs.getInt("role"));
                }
            }
        } finally {
            closeDB();
        }
        return dto;
    }

    public boolean registerAccount(String email, String name, String password) throws SQLException, NamingException {
        boolean valid = false;
        try {
            con = DBHelper.getConnect();
            if (con != null) {
                String sql = "INSERT INTO tbl_Account(email, name, password, role, status) "
                        + "VALUES (?, ?, ?, ?, ?)";
                stm = con.prepareStatement(sql);
                stm.setString(1, email);
                stm.setString(2, name);
                stm.setString(3, password);
                stm.setInt(4, MyConstants.ROLE_USER);
                stm.setInt(5, MyConstants.STATUS_ACTIVE);
                valid = stm.executeUpdate() > 0;
            }
        } finally {
            closeDB();
        }
        return valid;
    }

    public boolean checkAccountExisted(String email) throws SQLException, NamingException {
        try {
            con = DBHelper.getConnect();
            if (con != null) {

                String sql = "SELECT email "
                        + "FROM tbl_Account "
                        + "WHERE email = ?";
                stm = con.prepareStatement(sql);
                stm.setString(1, email);
                rs = stm.executeQuery();
                if (rs.next()) {
                    return true;
                }
            }
        } finally {
            closeDB();
        }
        return false;
    }
}
