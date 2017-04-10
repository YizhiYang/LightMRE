
<%-- 
    Search Home Page, include a customized Search Page button also.
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<link rel="stylesheet" href="css/style.css" type="text/css">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div class = "topnav">
            <a class = "HomeButton" onClick="displaymessage(); return false;" style="text-decoration:none" href="#">Home</a>
            <a class = "HomeButton" onClick="displaymessage(); return false;" style="text-decoration:none" href="#">Account</a>
            <a class = "HomeButton" onClick="displaymessage(); return false;" style="text-decoration:none" href="#">Search</a>
            <a class = "HomeButton" onClick="displaymessage(); return false;" style="text-decoration:none" href="#">About Us</a>
        </div>
        </br>
        </br>

        <form class="form-wrapper" method="post" action="http://localhost:8080/LightMRE/SearchResult">
            <input type="text" id="search" name ="search" placeholder="" required>
            <input type="submit" id="submit" action = "SearchResult" value="Find">
            </br>
            </br>
            <select name="searchType" id = "searchType">
                <option value="name">Name</option>
                <option value="type">Type</option>
            </select>
        </form>





        <div class="detailSearch">
            <ul class="searchMenu">
                <li class="searchMenuButton"><a href="#home">Beat Sell</a></li>
                <li class="searchMenuButton"><a href="#news">Details Search</a></li>
                <li class="searchMenuButton"><a href="#contact">Contact</a></li>
                <li class="searchMenuButton"><a href="#about">About Us</a></li>
            </ul>
        </div>

        <div class="made-with-love">
            <img src="images/sbuLogoSmall.png" alt="Smiley face" height="208" width="252">
            </br>
            LightMRE
        </div>

        <script>
            function find() {
                //session.setAttribute("keyword", document.getElementById("search"));

                window.location = "SearchResult.jsp"
            }
        </script>
    </body>
</html>
