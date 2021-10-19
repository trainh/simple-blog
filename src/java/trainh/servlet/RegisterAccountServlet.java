/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trainh.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.regex.Pattern;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import trainh.account.Tbl_AccountRegisterError;
import trainh.account.Tbl_Account_DAO;
import trainh.utils.Encode_256;

/**
 *
 * @author trainh
 */
@WebServlet(name = "RegisterAccountServlet", urlPatterns = {"/RegisterAccountServlet"})
public class RegisterAccountServlet extends HttpServlet {

    private final String REGISTER_JSP_PAGE = "registerJspPage";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        String url = REGISTER_JSP_PAGE;
        String email = request.getParameter("txtEmail").trim();
        String name = request.getParameter("txtName").trim();
        String password = request.getParameter("txtPassword").trim();
        boolean vaildInput;
        boolean vaildRegister = false;
        Tbl_AccountRegisterError error = new Tbl_AccountRegisterError();
        Tbl_Account_DAO dao = new Tbl_Account_DAO();
        HttpSession session = request.getSession();
        try {
            vaildInput = vaildInput(error, email, name, password);
            if (vaildInput) {
                password = Encode_256.encodePassword(password);
                vaildRegister = dao.registerAccount(email, name, password);
            } else {
                session.setAttribute("ErrorRegisterAccount", error);
            }
            if (vaildRegister) {
                session.setAttribute("StatusRegisterAccount", "Sign Up success.");
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

    private boolean vaildInput(Tbl_AccountRegisterError error, String email, String name, String password) throws SQLException, NamingException {
        boolean valid = true;
        Tbl_Account_DAO dao = new Tbl_Account_DAO();
        if (dao.checkAccountExisted(email)) {
            error.setEmailRegisterError("Email already exists!!!");
            valid = false;
        }
        if (!Pattern.compile("^[\\w.+\\-]+@gmail\\.com$").matcher(email).find()) {
            error.setEmailRegisterError("Email isn't vailid!!!");
            valid = false;
        }
        if (name.length() > 50) {
            error.setNameRegisterError("Name is too long, at most 50 words!!");
            valid = false;
        }
        if (password.length() < 6) {
            error.setPasswordRegisterError("Password must be more than 6 characters!!!");
            valid = false;
        }
        if (!Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{6,}$").matcher(password).find()) {
            error.setPasswordRegisterError("Password isn't valid!!!");
            valid = false;
        }
        return valid;
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
