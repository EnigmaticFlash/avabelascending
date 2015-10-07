/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ascending.avabel;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author enigma
 */
public class tryLogin extends HttpServlet {

    private String userName, pword, profileName;

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
        response.sendRedirect("http//:www.google.com");
        loginOrNot(request, response);
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

    void loginOrNot(HttpServletRequest request, HttpServletResponse resposne) {

        userName = request.getParameter("userName");
        pword = request.getParameter("password");

        
        String url = "jdbc:mysql://localhost/avabelAscending";

        String user = "root";

        String password = "Amaterasu";

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con;
            con = DriverManager.getConnection(url, user, password);
            System.out.println("Success");

            Statement stmt;
            ResultSet rs;
            stmt = con.createStatement();
            rs = stmt.executeQuery("Select * from user");

            while (rs.next()) {
                if (rs.getString("userName").equals(userName) && rs.getString("password").equals(pword)) {
                    HttpSession session=request.getSession(); 
                    profileName = rs.getString("profileName");
        session.setAttribute("pName",profileName); 
        resposne.sendRedirect("Profile.jsp");
 
                }
            }
            resposne.getWriter().print("<!DOCTYPE html>\n"
                    + "<html>\n"
                    + "    <head>\n"
                    + "        <meta content=\"text/html; charset=utf-8\" http-equiv=\"Content-Type\" />\n"
                    + "        <title>Sign In</title>\n"
                    + "        <link type=\"text/css\" rel=\"stylesheet\" href=stylesheet.css>\n"
                    + "    </head>\n"
                    + "    <body>\n"
                    + "        <div id=\"header\"><span></span></div>\n"
                    + "\n"
                    + "        <div class=\"sideLeft\">\n"
                    + "\n"
                    + "            <ul id=\"sideLink\">\n"
                    + "                <li><a href=\"index.html\">Home</a></li>\n"
                    + "                <li><a href=\"registerGuild.html\">Register Guild</a></li>\n"
                    + "                <li><a href=\"findGuild.html\">Find Guild</a></li>\n"
                    + "                <li><a href=\"planEvent.html\">Plan Event</a></li>\n"
                    + "                <li><a href=\"viewEvents.html\">View Events</a></li>\n"
                    + "                <li><a href=\"signUp.html\">Sign Up</a></li>\n"
                    + "                <li><a href=\"signIn.html\">Sign In</a></li>\n"
                    + "            </ul>\n"
                    + "        </div>\n"
                    + "\n"
                    + "        <div class=\"main\">\n"
                    + "            <form action=\"tryLogin\" method=\"post\">\n"
                    + "                <p>Username and or password does not exist <br> <a href=\"signUp.html\">Sign Up?</a></p>"
                    + "                Username: <input name=\"userName\" placeholder=\"coolguy\" type=\"text\" required  /><br />\n"
                    + "                Password: <input name=\"password\" placeholder=\"hocuspocus\" type=\"password\" required /><br />\n"
                    + "                <br />\n"
                    + "                <input type=\"submit\" value=\"Sign In\" />"
                    + "</form>\n"
                    + "        </div>\n"
                    + "    </body>\n"
                    + "</html>");
            stmt.close();

        } catch (Exception e) {

            e.printStackTrace();

        }

    }
}
