/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.user;

import model.User;
import model.Discussion;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import dal.DiscussionDAO;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
@WebServlet(name = "DiscussionServlet", urlPatterns = {"/discussion"})
@MultipartConfig()
public class DiscussionServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet DiscussionServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet DiscussionServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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

        if (request.getParameter("like") != null) {
            int likenum = Integer.parseInt(request.getParameter("like"));
            DiscussionDAO dao = new DiscussionDAO();
            dao.rateDiscussion(likenum);
            response.sendRedirect("discussion");
        } else {
            List<Discussion> list = new ArrayList<>();
            DiscussionDAO dao = new DiscussionDAO();
            list = dao.getDiscussion();
            List<Discussion> list2 = new ArrayList<>();
            list2 = dao.getReplyDiscussion();
            request.setAttribute("discussion", list);
            request.setAttribute("replydiscussion", list2);
            request.getRequestDispatcher("/pages/user/comment/discussion.jsp").forward(request, response);
        }

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
        if (request.getParameter("discussion") != null) {
            String comment = request.getParameter("discussion");
            Part filePart = request.getPart("upFile");
            String image ;
            if (filePart == null) {
                image = "";
            } else {
                String fileName = filePart.getSubmittedFileName();
                for (Part part : request.getParts()) {
                    part.write("E:\\PRJ301\\Online-Learning\\web\\upload\\" + fileName);
                }
                image= fileName;
            }
            HttpSession session = request.getSession();
            User u = (User) session.getAttribute("account");
            Discussion d = new Discussion(u, comment, image);
            DiscussionDAO dao = new DiscussionDAO();
            dao.addDiscussion(d);
            response.sendRedirect("discussion");
        } else if (request.getParameter("discusionReply") != null) {
            String reply = request.getParameter("discusionReply");
            HttpSession session = request.getSession();
            User u = (User) session.getAttribute("account");
            Discussion d = new Discussion(u, reply);
            int replyof = Integer.parseInt(request.getParameter("Replyof"));
            DiscussionDAO dao = new DiscussionDAO();
            dao.replyDiscussion(replyof, d);
            response.sendRedirect("discussion");
        }

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
