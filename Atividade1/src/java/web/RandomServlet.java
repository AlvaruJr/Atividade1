/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package web;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author Alvaro
 */
@WebServlet(name = "RandomServlet", urlPatterns = {"/random.html"})
public class RandomServlet extends HttpServlet {

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
        int n=60;
       String errorMessage;
        errorMessage = null;
        try{
            n = Integer.parseInt(request.getParameter("n"));

       }catch (Exception ex){
           errorMessage = "parametro invalido!";
       }
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet RandomServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Sorteio</h1>");
            out.println("<h4><a href = 'index.html'>Voltar</a></h4>");
            out.println("<form>");
            out.println("<input type='number' name='n'/>");
            out.println("<input type='submit' name='Randon' value ='gerar'>");
            out.println("</form>");
            out.println("<table border=1>");
            if(errorMessage!=null){
                out.println("<h4 style='color:red'>"+ errorMessage+"!</h4>");
            }else{
                out.println("<tr>");
                out.println("<th>index</th><th>Number</th>");
                out.println("</tr>");
                try{
                    for( int i=1; i<=n; i++){
                        out.println("<tr>");
                        out.println("<th>"+ i +"</th>");
                        int r =((int)( 60*Math.random()));
                        out.println("<th>"+ r +"</th>");
                        out.println("</tr>");
                    }
                }catch(Exception ex){
                     out.println("<tr><td colspan='2' style='color:red'>valor invalido!</td></tr>");
                }
            }
            out.println("</table>");
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
