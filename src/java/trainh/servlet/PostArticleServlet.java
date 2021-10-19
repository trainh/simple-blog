/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trainh.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import trainh.article.Tbl_Article_DAO;
import trainh.account.Tbl_Account_DTO;

/**
 *
 * @author trainh
 */
@WebServlet(name = "PostArticleServlet", urlPatterns = {"/PostArticleServlet"})
public class PostArticleServlet extends HttpServlet {

    private final String POST_PAGE = "postArticleJspPage";
    private final String INVAILD_PAGE = "invalidPage";
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String url = INVAILD_PAGE;
        String tital = request.getParameter("txtTital").trim();
        String shortDescription = request.getParameter("txtShortDescription").trim();
        String contentArticle = request.getParameter("txtContentArticle").trim();
        HttpSession session = request.getSession();
        Tbl_Article_DAO dao = new Tbl_Article_DAO();
        Tbl_Account_DTO dto;
        boolean validatePostArticle = false;
        try {
            dto = (Tbl_Account_DTO) session.getAttribute("USER");
            validatePostArticle = dao.postArticle(tital, shortDescription, dto.getEmail(), contentArticle);
            if (validatePostArticle) {
                session.setAttribute("STATUS_POST", "Waiting for approval from admin");
                url = POST_PAGE;
            } else {
                session.setAttribute("ERROR_STRING", dto);
                url = INVAILD_PAGE;
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
