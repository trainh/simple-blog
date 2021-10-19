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

/**
 *
 * @author trainh
 */
@WebServlet(name = "SearchArticleServlet", urlPatterns = {"/SearchArticleServlet"})
public class SearchArticleServlet extends HttpServlet {

    private final String ADMIN_PAGE = "adminJspPage";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        String url = ADMIN_PAGE;
        String content = null;
        String tital = null;
        if (request.getParameter("txtSearchContent") != null || request.getParameter("txtSearchTital") != null) {
            content = request.getParameter("txtSearchContent");
            tital = request.getParameter("txtSearchTital");
        }
        Tbl_Article_DAO dao = new Tbl_Article_DAO();
        int posPage = 1;
        int numPage;
        List<Tbl_Article_DTO> list;
        String posPageString = request.getParameter("posPage");
        try {
            if (posPageString != null) {
                posPage = Integer.parseInt(posPageString);
            }
            if (request.getParameter("status") != null) {
                String statusString = request.getParameter("status").trim();
                int status = Integer.parseInt(statusString);
                numPage = dao.getQuantityOfStatus(status);
                list = dao.searchStatusArticleByAdmin(status, posPage);
                request.setAttribute("QUANTITY_PAGE", numPage);
                request.setAttribute("LIST_ARTICLE", list);
                request.setAttribute("status", status);
            } else {
                if ((content != null && !("".endsWith(content))) && (tital != null && !("".endsWith(tital)))) {
                    numPage = dao.getQuantityOfArticlePage(tital, content);
                    list = dao.searchArticleByAdmin(tital, content, numPage);
                    request.setAttribute("QUANTITY_PAGE", numPage);
                    request.setAttribute("LIST_ARTICLE", list);
                } else if ((tital != null || !("".endsWith(tital))) && (content == null || ("".endsWith(content)))) {
                    numPage = dao.getQuantityOfSearchTital(tital);
                    list = dao.searchTitalByAdmin(tital, posPage);
                    request.setAttribute("QUANTITY_PAGE", numPage);
                    request.setAttribute("LIST_ARTICLE", list);
                } else {
                    numPage = dao.getQuantityOfSearchContent(content);
                    list = dao.searchContentByAdmin(content, posPage);
                    request.setAttribute("QUANTITY_PAGE", numPage);
                    request.setAttribute("LIST_ARTICLE", list);
                }
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
