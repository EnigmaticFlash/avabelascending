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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author enigma
 */
public class tryRegister extends HttpServlet {

    private String profileName, userName, pword, email;
    private int numberOfCharacters;

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
        registerOrNot(request, response);
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

    /**
     * Checks to see if userName and email are not taken if not adds to database
     *
     * @param request
     * @param resposne
     */
    void registerOrNot(HttpServletRequest request, HttpServletResponse resposne) {
        profileName = request.getParameter("profileName");
        userName = request.getParameter("userName");
        pword = request.getParameter("password");
        email = request.getParameter("email");
        numberOfCharacters = 0;
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
                if (rs.getString("userName").equals(userName)) {
                    resposne.getWriter().print("<html>\n"
                            + "    <head>\n"
                            + "        <meta content=\"text/html; charset=utf-8\" http-equiv=\"Content-Type\" />\n"
                            + "        <title>Sign Up</title>\n"
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
                            + "            <form action=\"tryRegister\" method=\"post\">\n"
                            + "UserName already taken, please choose another one.<br>"
                            + "                Profile Name: <input name=\"profileName\" value=\"" + profileName + " \" placeholder=\"Mr. Handsome\" type=\"text\" maxlength=\"10\" required /><br>\n"
                            + "                User Name: <input name=\"userName\" placeholder=\"lemein\" type=\"text\"   maxlength=\"15\" required /><br> \n"
                            + "                Password: <input name=\"password\" placeholder=\"hocuspocus (5 Minimum)\" type=\"password\" maxlength=\"15\" pattern=\".{5,}\" required /> <br />\n"
                            + "                Email: <input name=\"email\" value=\"" + email + " \" placeholder=\"blah@email.com\" type=\"email\" required /><br />\n"
                            + "                <br />\n"
                            + "                <input type=\"submit\" value=\"Sign Up\" />\n"
                            + "            </form>\n"
                            + "        </div>\n"
                            + "    </body>\n"
                            + "");
                } else if (rs.getString("email").equals(email)) {
                    resposne.getWriter().print("<html>\n"
                            + "    <head>\n"
                            + "        <meta content=\"text/html; charset=utf-8\" http-equiv=\"Content-Type\" />\n"
                            + "        <title>Sign Up</title>\n"
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
                            + "            <form action=\"tryRegister\" method=\"post\">\n"
                            + "Email already taken, please choose another one.<br>"
                            + "                Profile Name: <input name=\"profileName\" value=\"" + profileName + " \" placeholder=\"Mr. Handsome\" type=\"text\" maxlength=\"10\" required /><br>\n"
                            + "                User Name: <input name=\"userName\" value=\"" + userName + " \" placeholder=\"lemein\" type=\"text\"   maxlength=\"15\" required /><br> \n"
                            + "                Password: <input name=\"password\" placeholder=\"hocuspocus (5 Minimum)\" type=\"password\" maxlength=\"15\" pattern=\".{5,}\" required /> <br />\n"
                            + "                Email: <input name=\"email placeholder=\"blah@email.com\" type=\"email\" required /><br />\n"
                            + "                <br />\n"
                            + "                <input type=\"submit\" value=\"Sign Up\" />\n"
                            + "            </form>\n"
                            + "        </div>\n"
                            + "    </body>\n"
                            + "");
                }else if (rs.getString("profileName").equals(profileName)) {
                    resposne.getWriter().print("<html>\n"
                            + "    <head>\n"
                            + "        <meta content=\"text/html; charset=utf-8\" http-equiv=\"Content-Type\" />\n"
                            + "        <title>Sign Up</title>\n"
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
                            + "            <form action=\"tryRegister\" method=\"post\">\n"
                            + "Profile name already taken, please choose another one.<br>"
                            + "                Profile Name: <input name=\"profileName\"  placeholder=\"Mr. Handsome\" type=\"text\" maxlength=\"10\" required /><br>\n"
                            + "                User Name: <input name=\"userName\" value=\"" + userName + " \" placeholder=\"lemein\" type=\"text\"   maxlength=\"15\" required /><br> \n"
                            + "                Password: <input name=\"password\" placeholder=\"hocuspocus (5 Minimum)\" type=\"password\" maxlength=\"15\" pattern=\".{5,}\" required /> <br />\n"
                            + "                Email: <input name=\"email\" value=\"" + email + " \" placeholder=\"blah@email.com\" type=\"email\" required /><br />\n"
                            + "                <br />\n"
                            + "                <input type=\"submit\" value=\"Sign Up\" />\n"
                            + "            </form>\n"
                            + "        </div>\n"
                            + "    </body>\n"
                            + "");
                }
            } stmt.executeUpdate("insert into user(profileName, userName, `password`, email, numberOfCharacters)"
          + "values('"+profileName+"','"+userName+"','"+pword+"','"+email+"',"+numberOfCharacters+");");
            stmt.close();

        } catch (Exception e) {

            e.printStackTrace();

        }

    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return pword;
    }

    public void setPassword(String password) {
        this.pword = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
