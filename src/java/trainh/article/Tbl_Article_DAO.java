/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trainh.article;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;
import trainh.utils.DBHelper;
import trainh.utils.MyConstants;

/**
 *
 * @author trainh
 */
public class Tbl_Article_DAO implements Serializable {

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

    public int getQuantityOfSearchTital(String searchTital) throws NamingException, SQLException {
        int quantityPage = 0;
        try {
            con = DBHelper.getConnect();
            if (con != null) {
                String sql = "SELECT COUNT(articleID) AS quantity "
                        + "FROM tbl_Article "
                        + "WHERE tital LIKE ? ";
                stm = con.prepareStatement(sql);
                stm.setString(1, "%" + searchTital + "%");
                rs = stm.executeQuery();
                if (rs.next()) {
                    int quantityOfArticle = rs.getInt("quantity");
                    if (quantityOfArticle % MyConstants.TOTAL_ITEM_IN_PAGE > 0) {
                        quantityPage = quantityOfArticle / MyConstants.TOTAL_ITEM_IN_PAGE + 1;
                    } else {
                        quantityPage = quantityOfArticle / MyConstants.TOTAL_ITEM_IN_PAGE;
                    }
                    return quantityPage;
                }
            }
            return 0;
        } finally {
            closeDB();
        }
    }

    public int getQuantityOfSearchContent(String searchContent) throws NamingException, SQLException {
        int quantityPage = 0;
        try {
            con = DBHelper.getConnect();
            if (con != null) {
                String sql = "SELECT COUNT(articleID) AS quantity "
                        + "FROM tbl_Article "
                        + "WHERE contentArticle LIKE ? ";
                stm = con.prepareStatement(sql);
                stm.setString(1, "%" + searchContent + "%");
                rs = stm.executeQuery();
                if (rs.next()) {
                    int quantityOfArticle = rs.getInt("quantity");
                    if (quantityOfArticle % MyConstants.TOTAL_ITEM_IN_PAGE > 0) {
                        quantityPage = quantityOfArticle / MyConstants.TOTAL_ITEM_IN_PAGE + 1;
                    } else {
                        quantityPage = quantityOfArticle / MyConstants.TOTAL_ITEM_IN_PAGE;
                    }
                    return quantityPage;
                }
            }
            return 0;
        } finally {
            closeDB();
        }
    }

    public int getQuantityOfArticlePage(String search) throws NamingException, SQLException {
        int quantityPage = 0;
        try {
            con = DBHelper.getConnect();
            if (con != null) {
                String sql = "SELECT COUNT(articleID) AS quantity "
                        + "FROM tbl_Article "
                        + "WHERE contentArticle LIKE ? AND status = ?";
                stm = con.prepareStatement(sql);
                stm.setString(1, "%" + search + "%");
                stm.setInt(2, MyConstants.STATUS_ACTIVE);
                rs = stm.executeQuery();
                if (rs.next()) {
                    int quantityOfArticle = rs.getInt("quantity");
                    if (quantityOfArticle % MyConstants.TOTAL_ITEM_IN_PAGE > 0) {
                        quantityPage = quantityOfArticle / MyConstants.TOTAL_ITEM_IN_PAGE + 1;
                    } else {
                        quantityPage = quantityOfArticle / MyConstants.TOTAL_ITEM_IN_PAGE;
                    }
                    return quantityPage;
                }
            }
            return 0;
        } finally {
            closeDB();
        }
    }

    public int getQuantityOfArticlePage(String searchTital, String searchContent) throws NamingException, SQLException {
        int quantityPage = 0;
        try {
            con = DBHelper.getConnect();
            if (con != null) {
                String sql = "SELECT COUNT(articleID) AS quantity "
                        + "FROM tbl_Article "
                        + "WHERE contentArticle LIKE ? OR tital LIKE ?";
                stm = con.prepareStatement(sql);
                stm.setString(1, "%" + searchContent + "%");
                stm.setString(2, "%" + searchTital + "%");
                rs = stm.executeQuery();
                if (rs.next()) {
                    int quantityOfArticle = rs.getInt("quantity") / 2;
                    if (quantityOfArticle % MyConstants.TOTAL_ITEM_IN_PAGE > 0) {
                        quantityPage = quantityOfArticle / MyConstants.TOTAL_ITEM_IN_PAGE + 1;
                    } else {
                        quantityPage = quantityOfArticle / MyConstants.TOTAL_ITEM_IN_PAGE;
                    }
                    return quantityPage;
                }
            }
            return 0;
        } finally {
            closeDB();
        }
    }

    public int getQuantityOfStatus(int status) throws NamingException, SQLException {
        int quantityPage = 0;
        try {
            con = DBHelper.getConnect();
            if (con != null) {
                String sql = "SELECT COUNT(articleID) AS quantity "
                        + "FROM tbl_Article "
                        + "WHERE status = ? ";
                stm = con.prepareStatement(sql);
                stm.setInt(1, status);
                rs = stm.executeQuery();
                if (rs.next()) {
                    int quantityOfArticle = rs.getInt("quantity");
                    if (quantityOfArticle % MyConstants.TOTAL_ITEM_IN_PAGE > 0) {
                        quantityPage = quantityOfArticle / MyConstants.TOTAL_ITEM_IN_PAGE + 1;
                    } else {
                        quantityPage = quantityOfArticle / MyConstants.TOTAL_ITEM_IN_PAGE;
                    }
                    return quantityPage;
                }
            }

        } finally {
            closeDB();
        }
        return 0;
    }

    public List<Tbl_Article_DTO> getListArticleByPage(int pageNumber, String search) throws NamingException, SQLException {
        List<Tbl_Article_DTO> list = new ArrayList<>();
        int itemInPage = MyConstants.TOTAL_ITEM_IN_PAGE;
        try {
            con = DBHelper.getConnect();
            String sql = "WITH X AS (SELECT ROW_NUMBER() OVER (ORDER BY date DESC) AS NO ,articleID , tital, shortDescription, author, date FROM tbl_Article WHERE contentArticle LIKE ? AND status = ?) "
                    + "SELECT articleID, tital, shortDescription, author, date FROM X WHERE NO BETWEEN ? AND ?";
            stm = con.prepareStatement(sql);
            stm.setString(1, "%" + search + "%");
            stm.setInt(2, MyConstants.STATUS_ACTIVE);
            stm.setInt(3, (itemInPage * pageNumber) - (itemInPage - 1));
            stm.setInt(4, itemInPage * pageNumber);
            rs = stm.executeQuery();
            while (rs.next()) {
                list.add(new Tbl_Article_DTO(rs.getInt("articleID"), rs.getString("tital"), rs.getString("shortDescription"), rs.getString("author"), rs.getDate("date")));
            }
        } finally {
            closeDB();
        }
        return list;
    }

    public Tbl_Article_DTO getArticleDetails(int articleID) throws NamingException, SQLException {
        try {
            con = DBHelper.getConnect();
            if (con != null) {
                String sql = "SELECT articleID, tital, shortDescription, author, date, contentArticle "
                        + "FROM tbl_Article "
                        + "WHERE articleID = ? AND status = ?";
                stm = con.prepareStatement(sql);
                stm.setInt(1, articleID);
                stm.setInt(2, MyConstants.STATUS_ACTIVE);
                rs = stm.executeQuery();
                if (rs.next()) {
                    return new Tbl_Article_DTO(articleID, rs.getString("tital"), rs.getString("shortDescription"), rs.getString("author"), rs.getDate("date"), rs.getString("contentArticle"));
                }
            }
        } finally {
            closeDB();
        }
        return null;
    }

    public Tbl_Article_DTO getArticleDetailsByAdmin(int articleID) throws NamingException, SQLException {
        try {
            con = DBHelper.getConnect();
            if (con != null) {
                String sql = "SELECT articleID, tital, shortDescription, author, date, contentArticle, status "
                        + "FROM tbl_Article "
                        + "WHERE articleID = ? ";
                stm = con.prepareStatement(sql);
                stm.setInt(1, articleID);
                rs = stm.executeQuery();
                if (rs.next()) {
                    return new Tbl_Article_DTO(articleID, rs.getString("tital"), rs.getString("shortDescription"), rs.getString("author"), rs.getDate("date"), rs.getString("contentArticle"), rs.getInt("status"));
                }
            }
        } finally {
            closeDB();
        }
        return null;
    }

    public List<Tbl_Article_DTO> getListArticleBySearch(int pageNumber, String search) throws NamingException, SQLException {
        List<Tbl_Article_DTO> list = new ArrayList<>();
        int itemInPage = MyConstants.TOTAL_ITEM_IN_PAGE;
        try {
            con = DBHelper.getConnect();
            String sql = "WITH X AS (SELECT ROW_NUMBER() OVER (ORDER BY date DESC) AS NO ,articleID , tital, shortDescription, author, date FROM tbl_Article WHERE contentArticle LIKE ?) "
                    + "SELECT articleID, tital, shortDescription, author, date FROM X WHERE NO BETWEEN ? AND ?";
            stm = con.prepareStatement(sql);
            stm.setString(1, "%" + search + "%");
            stm.setInt(2, (itemInPage * pageNumber) - (itemInPage - 1));
            stm.setInt(3, itemInPage * pageNumber);
            rs = stm.executeQuery();
            while (rs.next()) {
                list.add(new Tbl_Article_DTO(rs.getInt("articleID"), rs.getString("tital"), rs.getString("shortDescription"), rs.getString("author"), rs.getDate("date")));
            }
        } finally {
            closeDB();
        }
        return list;
    }

    public boolean postArticle(String tital, String shortDesciption, String author, String contentArticle) throws NamingException, SQLException {
        try {
            con = DBHelper.getConnect();
            if (con != null) {
                String sql = "INSERT INTO tbl_Article (tital, short Description, author, date, contentArticle, status) "
                        + "VALUES (?, ?, ?, GETDATE(), ?, ?)";
                stm = con.prepareStatement(sql);
                stm.setString(1, tital);
                stm.setString(2, shortDesciption);
                stm.setString(3, author);
                stm.setString(4, contentArticle);
                stm.setInt(5, MyConstants.STATUS_NEW);
                return stm.executeUpdate() > 0;
            }
        } finally {
            closeDB();
        }
        return false;
    }

    public List<Tbl_Article_DTO> searchTitalByAdmin(String searchTital, int pageNumber) throws NamingException, SQLException {
        List<Tbl_Article_DTO> list = new ArrayList<>();
        int itemInPage = MyConstants.TOTAL_ITEM_IN_PAGE;
        try {
            con = DBHelper.getConnect();
            String sql = "WITH X AS (SELECT ROW_NUMBER() OVER (ORDER BY date DESC) AS NO ,articleID, tital, shortDescription, author, date FROM tbl_Article WHERE tital LIKE ? ) "
                    + "SELECT articleID, tital, shortDescription, author, date FROM X WHERE NO BETWEEN ? AND ?";
            stm = con.prepareStatement(sql);
            stm.setString(1, "%" + searchTital + "%");
            stm.setInt(2, (itemInPage * pageNumber) - (itemInPage - 1));
            stm.setInt(3, itemInPage * pageNumber);
            rs = stm.executeQuery();
            while (rs.next()) {
                list.add(new Tbl_Article_DTO(rs.getInt("articleID"), rs.getString("tital"), rs.getString("shortDescription"), rs.getString("author"), rs.getDate("date")));
            }
        } finally {
            closeDB();
        }
        return list;
    }

    public List<Tbl_Article_DTO> searchContentByAdmin(String searchContent, int pageNumber) throws NamingException, SQLException {
        List<Tbl_Article_DTO> list = new ArrayList<>();
        int itemInPage = MyConstants.TOTAL_ITEM_IN_PAGE;
        try {
            con = DBHelper.getConnect();
            String sql = "WITH X AS (SELECT ROW_NUMBER() OVER (ORDER BY date DESC) AS NO ,articleID, tital, shortDescription, author, date FROM tbl_Article WHERE contentArticle LIKE ? ) "
                    + "SELECT articleID, tital, shortDescription, author, date FROM X WHERE NO BETWEEN ? AND ?";
            stm = con.prepareStatement(sql);
            stm.setString(1, "%" + searchContent + "%");
            stm.setInt(2, (itemInPage * pageNumber) - (itemInPage - 1));
            stm.setInt(3, itemInPage * pageNumber);
            rs = stm.executeQuery();
            while (rs.next()) {
                list.add(new Tbl_Article_DTO(rs.getInt("articleID"), rs.getString("tital"), rs.getString("shortDescription"), rs.getString("author"), rs.getDate("date")));
            }
        } finally {
            closeDB();
        }
        return list;
    }

    public List<Tbl_Article_DTO> searchArticleByAdmin(String tital, String content, int pageNumber) throws NamingException, SQLException {
        List<Tbl_Article_DTO> list = new ArrayList<>();
        int itemInPage = MyConstants.TOTAL_ITEM_IN_PAGE;
        try {
            con = DBHelper.getConnect();
            String sql = "WITH X AS (SELECT ROW_NUMBER() OVER (ORDER BY date DESC) AS NO ,articleID, tital, shortDescription, author, date FROM tbl_Article WHERE contentArticle LIKE ? OR tital LIKE ? ) "
                    + "SELECT articleID, tital, shortDescription, author, date FROM X WHERE NO BETWEEN ? AND ?";
            stm = con.prepareStatement(sql);
            stm.setString(1, "%" + content + "%");
            stm.setString(2, "%" + tital + "%");
            stm.setInt(3, (itemInPage * pageNumber) - (itemInPage - 1));
            stm.setInt(4, itemInPage * pageNumber);
            rs = stm.executeQuery();
            while (rs.next()) {
                list.add(new Tbl_Article_DTO(rs.getInt("articleID"), rs.getString("tital"), rs.getString("shortDescription"), rs.getString("author"), rs.getDate("date")));
            }
        } finally {
            closeDB();
        }
        return list;
    }

    public boolean updateArticle(int status, int articleID) throws NamingException, SQLException {
        try {
            con = DBHelper.getConnect();
            if (con != null) {
                String sql = "UPDATE tbl_Article "
                        + "SET status = ? "
                        + "WHERE articleID = ?";
                stm = con.prepareStatement(sql);
                stm.setInt(1, status);
                stm.setInt(2, articleID);
                return stm.executeUpdate() > 0;
            }
        } finally {
            closeDB();
        }
        return false;
    }

    public List<Integer> getQuantityStatus() throws NamingException, SQLException {
        List<Integer> status = new ArrayList();
        try {
            con = DBHelper.getConnect();
            if (con != null) {
                String sql = "SELECT (SELECT COUNT(articleID) FROM tbl_Article WHERE status = ?) AS New, \n"
                        + "(SELECT COUNT(articleID) AS Active FROM tbl_Article WHERE status = ?) AS Active, \n"
                        + "(SELECT COUNT(articleID) AS Active FROM tbl_Article WHERE status = ?) AS Delte";
                stm = con.prepareStatement(sql);
                stm.setInt(1, MyConstants.STATUS_NEW);
                stm.setInt(2, MyConstants.STATUS_ACTIVE);
                stm.setInt(3, MyConstants.STATUS_DELETE);
                rs = stm.executeQuery();
                while (rs.next()) {
                    status.add(rs.getInt("New"));
                    status.add(rs.getInt("Active"));
                    status.add(rs.getInt("Delte"));
                }
                status.get(0);
            }
        } finally {
            closeDB();
        }
        return status;
    }

    public List<Tbl_Article_DTO> searchStatusArticleByAdmin(int status, int pageNumber) throws NamingException, SQLException {
        List<Tbl_Article_DTO> list = new ArrayList<>();
        int itemInPage = MyConstants.TOTAL_ITEM_IN_PAGE;
        try {
            con = DBHelper.getConnect();
            String sql = "WITH X AS (SELECT ROW_NUMBER() OVER (ORDER BY date DESC) AS NO ,articleID, tital, shortDescription, author, date FROM tbl_Article WHERE status = ? ) "
                    + "SELECT articleID, tital, shortDescription, author, date FROM X WHERE NO BETWEEN ? AND ?";
            stm = con.prepareStatement(sql);
            stm.setInt(1, status);
            stm.setInt(2, (itemInPage * pageNumber) - (itemInPage - 1));
            stm.setInt(3, itemInPage * pageNumber);
            rs = stm.executeQuery();
            while (rs.next()) {
                list.add(new Tbl_Article_DTO(rs.getInt("articleID"), rs.getString("tital"), rs.getString("shortDescription"), rs.getString("author"), rs.getDate("date")));
            }
        } finally {
            closeDB();
        }
        return list;
    }
}
