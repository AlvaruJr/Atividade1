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
@WebServlet(name = "NumSevlet", urlPatterns = {"/calc.html"})
public class NumSevlet extends HttpServlet {

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
            /* TODO output your page here. You may use following sample code. */
          out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet SumSevlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h4><a href = 'index.html'>Voltar</a></h4>");
            out.println("<h1>Alvaro</h1>");
            out.println("<h2>Calculando</h2>");
            try { 
                double n1 = Double.parseDouble( request.getParameter( "n1"));
                double n2 = Double.parseDouble( request.getParameter( "n2"));
                double sum = 0;
               String operacao = request.getParameter("operacao");

                if(operacao.equals("+")){
                    sum =n1+n2;
                    out.println("<h4 style='color:blue'>" + n1 + " + " + n2 + " = " + sum + "</h4>");
                }else if(operacao.equals("-")){
                    sum =n1-n2;
                    out.println("<h5 style='color:blue'>" + n1 + " - " + n2 + " = " + sum + "</h5>");
                }else if(operacao.equals("*")){
                    sum =n1*n2;
                    out.println("<h6 style='color:blue'>" + n1 + " * " + n2 + " = " + sum + "</h6>");
                }else if(operacao.equals("/")){
                    sum =n1/n2;
                    out.println("<h7 style='color:blue'>" + n1 + " - "+ "/ " + n2 + " = " + sum + "</h7>");
                }else{
                    out.println("<h8 style='color:red'>valor invalido!</h8>");
                }
            }catch(NumberFormatException ex){
                out.println("<h9 style='color:red'>valor invalido!</h9>");
            }
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
