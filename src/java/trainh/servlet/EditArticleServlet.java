/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trainh.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import trainh.article.Tbl_Article_DAO;
import trainh.article.Tbl_Article_DTO;
import trainh.utils.MyConstants;

/**
 *
 * @author trainh
 */
@WebServlet(name = "EditArticleServlet", urlPatterns = {"/EditArticleServlet"})
public class EditArticleServlet extends HttpServlet {

    private final String SEARCH_ACTION = "searchArticleAction";
    private final String ARTICLE_PAGE = "articleAdminPage";
    private final String INVALID_PAGE = "invalidPage";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String url = INVALID_PAGE;
        Properties siteMap = (Properties) request.getServletContext().getAttribute("SITE_MAP");
        String bntAcion = request.getParameter("bntAction");
        String articleIDString = request.getParameter("articleID");
        boolean vaild;
        Tbl_Article_DTO dto;
        Tbl_Article_DAO daoA = new Tbl_Article_DAO();
        try {
            int articleID = Integer.parseInt(articleIDString);
            if (bntAcion == null) {
                request.setAttribute("ERRORSING", "Function isn't support!!");
                url = INVALID_PAGE;
            } else if ("view".equalsIgnoreCase(bntAcion)) {
                dto = daoA.getArticleDetailsByAdmin(articleID);
                request.setAttribute("ARTICLE", dto);
                url = ARTICLE_PAGE;
            } else if ("Approve".equals(bntAcion) || "Active".equals(bntAcion)) {
                vaild = daoA.updateArticle(MyConstants.STATUS_ACTIVE, articleID);
                if (vaild) {
                    url = siteMap.getProperty(SEARCH_ACTION) + "?status=2&txtSearch= ";
                } else {
                    request.setAttribute("ERRORSTRING", "Active failed");
                }
            } else if ("Delete".equals(bntAcion)) {
                vaild = daoA.updateArticle(MyConstants.STATUS_DELETE, articleID);
                if (vaild) {
                    url = siteMap.getProperty(SEARCH_ACTION) + "?status=5&txtSearch= ";
                } else {
                    request.setAttribute("ERRORSTRING", "Delete failed");
                }
            }
            Tbl_Article_DAO dao = new Tbl_Article_DAO();
            List listStatusArticleQuatity;
            listStatusArticleQuatity = dao.getQuantityStatus();
            request.getSession().setAttribute("STATUS_ARTICLE_QUANTITY", listStatusArticleQuatity);
        } catch (NamingException e) {
            log("Error NamingException at " + this.getClass().getName() + ": " + e.getMessage());
        } catch (SQLException e) {
            log("Error SQLException at " + this.getClass().getName() + ": " + e.getMessage());
        } catch (Exception e) {
            log("Error Exception at " + this.getClass().getName() + ": " + e.getMessage());
        } finally {
            RequestDispatcher rd = request.getRequestDispatcher(url);
            rd.forward(request, response);
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
