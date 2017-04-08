<%-- 
    Homepage that diaplay the suggestion list and menu bar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
 <link rel="stylesheet" href="css/style.css" type="text/css">
<html>
    <head>
    </head>
    <body>

        <div class = "topnav">
            <a class = "HomeButton" onClick="displaymessage()" style="text-decoration:none" href="#">Home</a>
            <a class = "HomeButton" onClick="displaymessage()" style="text-decoration:none" href="#">Account</a>
            <a class = "HomeButton" onClick="forwardToSearch()" style="text-decoration:none" href="#">Search</a>
            <a class = "HomeButton" onClick="displaymessage()" style="text-decoration:none" href="#">About Us</a>
        </div>


        <section>
            <!--for demo wrap-->
            <h1 id = "youMayLike">You may like...</h1>
            <div class="tbl-header">
                <table cellpadding="0" cellspacing="0" border="0">
                    <thead>
                        <tr>
                            <th>Movie</th>
                            <th>Type</th>
                            <th>Actor</th>
                            <th>Rating</th>
                            <th>Price</th>
                            <th></th>
                        </tr>
                    </thead>
                </table>
            </div>
            <div class="tbl-content">
                <table cellpadding="0" cellspacing="0" border="0">
                    <tbody>
                        <c:forEach items="${recommendList}" var="dList">
                            <tr>
                                <td>${dList.name}</td>
                                <td>${dList.type}</td>
                                <td>${dList.price}</td>
                                <td>${dList.rating}</td>
                                <td>${dList.price}</td>
                                <td><button type="button" onclick="rentIt()">Rent It</button></td>
                            </tr>
                        </c:forEach>

                    </tbody>
                </table>

            </div>
            
            
        </section>


        <!-- follow me template -->
        <div class="made-with-love">
            <img src="sbuLogoSmall.png" alt="Smiley face" height="208" width="252">
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

            function rentIt() {
                alert("Are you sure?");
            }

        </script>
    </body>
</html>