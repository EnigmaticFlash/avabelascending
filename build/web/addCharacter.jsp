<%-- 
    Document   : addCharacter
    Created on : Oct 5, 2015, 5:21:03 PM
    Author     : enigma
--%>

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


        <div class="centerIt">
            <a href="changePassword">Change Password</a><br><br>


        </div>
        <div class="centerIt"> 
            Character game name:<input type="text" name="characterName"></input><br>
        </div>

        <div class="centerIt">

            <form action="action_page.php">

                <script>
                    var characterClass;

                    function check() {
                        characterClass = document.getElementById("characterClass").value;
                        if (characterClass == "warrior") {
                            warrior();
                        } else if (characterClass == "rouge") {
                            rouge();
                        } else if (characterClass == "ranger") {
                            ranger();
                        } else if (characterClass == "creator") {
                            creator();
                        } else if (characterClass == "magician") {
                            magician();
                        } else if (characterClass == "acolyte") {
                            acolyte();
                        } else if (characterClass == "wanderer") {
                            wanderer();
                        } else {
                            blank();
                        }

                    }
                </script>
                General class: <select id="characterClass" name="characterClass" onchange="check()">
                    <option value=""></option>
                    <option value="warrior">Warrior</option>
                    <option value="rouge">Rouge</option>
                    <option value="ranger">Ranger</option>
                    <option value="creator">Creator</option>
                    <option value="magician">Magician</option>                       
                    <option value="acolyte">Acolyte</option>                    
                    <option value="wanderer">Wanderer</option>
                </select>
                <br>
                <script>

                    function warrior() {

                        document.getElementById("0").innerHTML = "<div class=\"centerIt\"> Advanced class:<select name=\"characterSubClass\">" +
                                "<option value=\"warrior\">Warrior</option>" +
                                "<option value=\"gladiator\">Gladiator</option>" +
                                "<option value=\"crusader\">Crusader</option>" +
                                "<option value=\"paladin\">Paladin</option>" +
                                "<option value=\"samurai\">Samurai</option>" +
                                "<option value=\"stinger\">Stinger</option>" +
                                "<option value=\"blader\">Blader</option>" +
                                "<option value=\"fireBringer\">Fire Bringer</option>" +
                                "</select></div>";
                    }
                    function rouge() {
                        document.getElementById("0").innerHTML = " \n\
               <div class=\"centerIt\"> Advanced class: <select name=\"characterSubClass\">" +
                                "<option value=\"rouge\">Rouge</option>" +
                                "<option value=\"debuster\">Debuster</option>" +
                                "<option value=\"stormRaider\">Storm Raider</option>" +
                                "<option value=\"assassin\">Assassin</option>" +
                                "<option value=\"shinobi\">Shinobi</option>" +
                                "<option value=\"raven\">Raven</option>" +
                                "<option value=\"raiden\">Raiden</option>" +
                                "<option value=\"clown\">Clown</option>" +
                                "</select></div>";
                    }
                    function ranger() {
                        document.getElementById("0").innerHTML = " \n\
               <div class=\"centerIt\"> Advanced class: <select name=\"characterSubClass\">" +
                                "<option value=\"ranger\">Ranger</option>" +
                                "<option value=\"sniper\">Sniper</option>" +
                                "<option value=\"gunslinger\">Gunslinger</option>" +
                                "<option value=\"trapGunner\">Trap Gunner</option>" +
                                "<option value=\"gambit\">Gambit</option>" +
                                "<option value=\"elfeen\">Elfeen</option>" +
                                "<option value=\"doubleBarrel\">Double Barrel</option>" +
                                "<option value=\"fortress\">Fortress</option>" +
                                "</select></div>";
                    }
                    function creator() {
                        document.getElementById("0").innerHTML = " \n\
               <div class=\"centerIt\"> Advanced class: <select name=\"characterSubClass\">" +
                                "<option value=\"creator\">Creator</option>" +
                                "<option value=\"blackSmith\">Black Smith</option>" +
                                "<option value=\"alchemist\">Alchemist</option>" +
                                "<option value=\"enchanter\">Enchanter</option>" +
                                "<option value=\"crafter\">Crafter</option>" +
                                "<option value=\"battleCracker\">Battle Cracker</option>" +
                                "<option value=\"planter\">Planter</option>" +
                                "<option value=\"battleForce\">Battle Force</option>" +
                                "</select></div>";
                    }
                    function magician() {
                        document.getElementById("0").innerHTML = " \n\
                <div class=\"centerIt\"> Advanced class:<select name=\"characterSubClass\">" +
                                "<option value=\"magician\">Magician</option>" +
                                "<option value=\"wizard\">Wizard</option>" +
                                "<option value=\"elementalist\">Elementalist</option>" +
                                "<option value=\"lostSpeller\">Lost Speller</option>" +
                                "<option value=\"soulBlader\">Soul Blader</option>" +
                                "<option value=\"darkPain\">Dark Pain</option>" +
                                "<option value=\"ignite\">Ignite</option>" +
                                "<option value=\"glacial\">Glacial</option>" +
                                "</select></div>";
                    }
                    function acolyte() {
                        document.getElementById("0").innerHTML = " \n\
              <div class=\"centerIt\"> Advanced class:  <select name=\"characterSubClass\">" +
                                "<option value=\"acolyte\">Acolyte</option>" +
                                "<option value=\"priest\">Priest</option>" +
                                "<option value=\"linker\">Linker</option>" +
                                "<option value=\"monk\">Monk</option>" +
                                "<option value=\"exorcist\">Exorcist</option>" +
                                "<option value=\"legSol\">Leg Sol</option>" +
                                "<option value=\"angelus\">Angelus</option>" +
                                "<option value=\"gradia\">Gradia</option>" +
                                "</select></div>";
                    }
                    function wanderer() {
                        document.getElementById("0").innerHTML = " \n\
               <div class=\"centerIt\"> Advanced class: <select name=\"characterSubClass\">" +
                                "<option value=\"wanderer\">Wanderer</option>" +
                                "<option value=\"bard\">Bard</option>" +
                                "<option value=\"spiker\">Spiker</option>" +
                                "<option value=\"geoDancer\">Geo Dancer</option>" +
                                "<option value=\"battleDancer\">Battle Dancer</option>" +
                                "<option value=\"painter\">Painter</option>" +
                                "<option value=\"undine\">Undine</option>" +
                                "<option value=\"hermit\">Hermit</option>" +
                                "</select></div>";
                    }
                    function blank() {
                        document.getElementById("0").innerHTML = " \n\
               <div class=\"centerIt\"> Advanced class: <select name=\"characterSubClass\">" +
                                "<option value=\"\">Select base class</option>" +
                                "</select></div>";

                    }

                </script>
                <div id="0">

                </div>



                <br><br>

                <input type="submit">
            </form>
        </div>


</html>
