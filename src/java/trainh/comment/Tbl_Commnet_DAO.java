/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trainh.comment;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;
import trainh.utils.DBHelper;

/**
 *
 * @author trainh
 */
public class Tbl_Commnet_DAO implements Serializable {

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

    public List<Tbl_Comment_DTO> getCommentByArticleaID(int articleID) throws SQLException, NamingException {
        List<Tbl_Comment_DTO> list = new ArrayList<>();
        try {
            con = DBHelper.getConnect();
            if (con != null) {
                String sql = "SELECT email, comment "
                        + "FROM tbl_Comment "
                        + "WHERE articleID = ? "
                        + "ORDER BY date ASC";
                stm = con.prepareStatement(sql);
                stm.setInt(1, articleID);
                rs = stm.executeQuery();
                while (rs.next()) {
                    list.add(new Tbl_Comment_DTO(rs.getString("email"), rs.getString("comment")));
                }
            }
        } finally {
            closeDB();
        }
        return list;
    }

    public boolean saveComment(int article, String email, String comment) throws NamingException, SQLException {
        try {
            con = DBHelper.getConnect();
            if (con != null) {
                String sql = "INSERT INTO tbl_Comment (articleID, email, comment, date) "
                        + "VALUES (?, ?, ?, GETDATE())";
                stm = con.prepareStatement(sql);
                stm.setInt(1, article);
                stm.setString(2, email);
                stm.setString(3, comment);
                return stm.executeUpdate() > 0;
            }
        } finally {
            closeDB();
        }
        return false;
    }
}
