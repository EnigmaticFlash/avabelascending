<%-- 
    Document   : Profile
    Created on : Oct 4, 2015, 5:40:13 PM
    Author     : enigma
--%>

<%@page import="com.sun.xml.ws.commons.WSEndpointCollectionBasedMOMListener"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link type="text/css" rel="stylesheet" href="stylesheet.css"/>

    </head>

    <body>
        <%
            if (session.getAttribute("pName") != null) {
                String name = (String) session.getAttribute("pName");
                response.getWriter().print(name);
            } else {

                response.sendRedirect("signIn.html");
            }
        %>
        <div id="header" >
            <span></span>
        </div>




        <div class="sideLeft">

            <ul id="sideLink">
                <li><a href="index.jsp">Home</a></li>
                <li><a href="registerGuild.jsp">Register Guild</a></li>
                <li><a href="findGuild.jsp">Find Guild</a></li>
                <li><a href="planEvent.jsp">Plan Event</a></li>
                <li><a href="viewEvents.jsp">View Events</a></li>
                    <% if (session.getAttribute("pName") == null) {
                    %>
                <li><a href="signUp.html">Sign Up</a></li>
                <li><a href="signIn.html">Sign In</a></li>
                    <%
                    } else {
                    %>
                <li><a href="logout">Logout</a></li>
                <li><a href="Profile.jsp">Profile</a></li>
                    <%
                        }
                    %>

            </ul>
        </div>

        <div class="main">
             <a href="addCharacter.jsp">Add Character</a>
        </div>

    </body>



