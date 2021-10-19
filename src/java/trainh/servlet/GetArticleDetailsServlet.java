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
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import trainh.article.Tbl_Article_DAO;
import trainh.article.Tbl_Article_DTO;
import trainh.comment.Tbl_Comment_DTO;
import trainh.comment.Tbl_Commnet_DAO;

/**
 *
 * @author trainh
 */
@WebServlet(name = "GetArticleDetailsServlet", urlPatterns = {"/GetArticleDetailsServlet"})
public class GetArticleDetailsServlet extends HttpServlet {

    private final String ARTICLE_DETAILS_PAGE = "getArticleDetailsPage";
    private final String INVALID_PAGE = "invalidPage";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String url = INVALID_PAGE;
        String articleIDString = request.getParameter("articleID");
        int articleID = Integer.parseInt(articleIDString);
        Tbl_Article_DTO dto;
        Tbl_Article_DAO daoA = new Tbl_Article_DAO();
        Tbl_Commnet_DAO daoC = new Tbl_Commnet_DAO();
        List<Tbl_Comment_DTO> list;
        try {
            dto = daoA.getArticleDetails(articleID);
            list = daoC.getCommentByArticleaID(articleID);
            if (dto != null) {
                if (list != null) {
                    request.setAttribute("COMMENTLIST", list);
                } else {
                    request.setAttribute("COMMENTSTRING", "To be the first person to comment!");
                }
                request.setAttribute("ARTICLE", dto);
                url = ARTICLE_DETAILS_PAGE;
            } else {
                request.setAttribute("ERROR_STRING", "Article isn't available!!!");
                url = INVALID_PAGE;
            }
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
