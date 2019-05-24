package br.com.bancounipaulistana.servlets.planosdeprevidencia;

import br.com.bancounipaulistana.classes.planosdeprevidencia.Planos;
import br.com.bancounipaulistana.dao.planosdeprevidencia.PlanosDao;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author vvasc
 */
public class ExibePlanos extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            PlanosDao planosDao = new PlanosDao();

            out.println("<table class='container'><thead>");
            out.println("<th>Nome do Plano</th>");
            out.println("<th>Descrição do Plano</th>");
            out.println("<th>Tempo Limite (meses)</th>");
            out.println("<th>Aquisição</th>");
            out.println("</thead>");
            out.println("<tbody>");
            for (Planos plano : planosDao.planosDisponiveis()) {
                out.println("<tr><td>" + plano.getNomePlano() + "</td>");
                out.println("<td>" + plano.getDescPlano() + "</td>");
                out.println("<td>" + plano.getTempoLimite()+ "</td>");
                out.println("<td><button><a href='AdquirirPlano?idPlano="+ plano.getId() + "'>Quero este plano</a></button></td></tr>");
            }
            out.println("</tbody></table>");

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
