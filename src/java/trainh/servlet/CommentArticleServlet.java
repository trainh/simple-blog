/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trainh.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Properties;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import trainh.comment.Tbl_Commnet_DAO;

/**
 *
 * @author trainh
 */
@WebServlet(name = "CommentArticleServlet", urlPatterns = {"/CommentArticleServlet"})
public class CommentArticleServlet extends HttpServlet {

    private final String ARTICLE_PAGE = "getArticleDetailsAction";
    private final String INVALID_PAGE = "invalidPage";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        Properties siteMap = (Properties) request.getServletContext().getAttribute("SITE_MAP");
        PrintWriter out = response.getWriter();
        String url = ARTICLE_PAGE;
        String comment = request.getParameter("txtComment");
        String articleIDString = request.getParameter("txtArticleID");
        String email = request.getParameter("txtEmail");
        Tbl_Commnet_DAO dao = new Tbl_Commnet_DAO();
        boolean validComment = false;
        try {
            int articleID = Integer.parseInt(articleIDString);
            validComment = dao.saveComment(articleID, email, comment);
            if (!validComment) {
                request.setAttribute("ERROR_STRING", "Comment failed!");
                url = INVALID_PAGE;
            } else {
                url = siteMap.getProperty(ARTICLE_PAGE) + "?articleID=" + articleID;
            }
        } catch (NamingException e) {
            log("Error NamingException at " + this.getClass().getName() + ": " + e.getMessage());
        } catch (SQLException e) {
            log("Error SQLException at " + this.getClass().getName() + ": " + e.getMessage());
        } catch (Exception e) {
            log("Error Exception at " + this.getClass().getName() + ": " + e.getMessage());
        } finally {
            response.sendRedirect(url);
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
