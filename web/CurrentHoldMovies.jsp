<%-- 
    Document   : CurrentHoldMovies
    Created on : Apr 30, 2017, 1:56:17 AM
    Author     : MATT
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
 <link rel="stylesheet" href="css/style.css" type="text/css">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>

        <div class = "topnav">
            <a class = "HomeButton" onClick="displaymessage()" style="text-decoration:none" href="http://localhost:8080/LightMRE/HomePageServ">Home</a>
            <a class = "HomeButton" onClick="displaymessage()" style="text-decoration:none" href="#">Account</a>
            <a class = "HomeButton" onClick="displaymessage()" style="text-decoration:none" href="http://localhost:8080/LightMRE/CustomerHoldMovies">My movies</a>
            <a class = "HomeButton" onClick="forwardToSearch()" style="text-decoration:none" href="http://localhost:8080/LightMRE/BestSellMovie">Best sell movies</a>
            <a class = "HomeButton" onClick="forwardToSearch()" style="text-decoration:none" href="http://localhost:8080/LightMRE/RentalHistory">History</a>
            <a class = "HomeButton" onClick="forwardToSearch()" style="text-decoration:none" href="#">Search</a>
            <a class = "HomeButton" onClick="displaymessage()" style="text-decoration:none" href="http://localhost:8080/LightMRE/LogOut">Log Out</a>
        </div>


        <section>
            <!--for demo wrap-->
            <h1 id = "My Movies">My Movies...</h1>
            <div class="tbl-header">
                <table cellpadding="0" cellspacing="0" border="0">
                    <thead>
                        <tr>
                            <th>Order ID</th>
                            <th>Movie</th>
                            <th>Type</th>
                            <th>Rating</th>
                            <th></th>
                        </tr>
                    </thead>
                </table>
            </div>
            <div class="tbl-content">
                <table cellpadding="0" cellspacing="0" border="0" id="mytable">
                    <tbody>
                    <c:forEach items="${currentHeldList}" var="mList">
                        <tr>
                            <td>${mList.orderId}</td>
                            <td>${mList.name}</td>
                            <td>${mList.type}</td>
                            <td>${mList.rating}</td>
                            <td><button type="button" onclick="returnIt(this)">Return It</button></td>
                        </tr>
                    </c:forEach>

                    </tbody>
                </table>

            </div>

            <div class="made-with-love">
                <img src="images/sbuLogoSmall.png" alt="Smiley face" height="208" width="252">
                </br>
                LightMRE
            </div>
            
            <script>
            function displaymessage() {
                window.location = "AboutUs.jsp"
            }
            
            function forwardToSearch() {
                window.location = "Search.jsp"
            }

            function returnIt(element) {
                var id = document.getElementById("mytable").rows[element.parentNode.parentNode.rowIndex].cells[0].innerHTML;
                var name = document.getElementById("mytable").rows[element.parentNode.parentNode.rowIndex].cells[1].innerHTML;
                confirm("Are you sure to return " + name + "?");
                 location.href = "ReturnIt?ID=" + id +"&MovieName="+ name;
            }

        </script>
    </body>
</html>
