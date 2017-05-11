<%-- 
    SearchResult Page to display the search result
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<link rel="stylesheet" href="css/style.css" type="text/css">
<!DOCTYPE html>
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
            <h1 id = "youMayLike">Search Result:</h1>
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
                <table cellpadding="0" cellspacing="0" border="0" id="mytable">
                    <tbody>
                        <c:forEach items="${searchList}" var="eList">
                            <tr>
                                <td>${eList.name}</td>
                                <td>${eList.type}</td>
                                <td>${eList.price}</td>
                                <td>${eList.rating}</td>
                                <td>${eList.price}</td>
                                <td><button type="button" onclick="rentIt(this)">Rent It</button></td>
                            </tr>
                        </c:forEach>


                    </tbody>
                </table>

            </div>


        </section>

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

            function forwardToSearch() {
                window.location = "Search.jsp"
            }
            
                        function rentIt(element) {
                var name = document.getElementById("mytable").rows[element.parentNode.parentNode.rowIndex].cells[0].innerHTML;
                confirm("Are you sure to rent " + name + " ?");
                location.href = "RentIt?MovieName=" + name;
            }
        </script>
    </body>
</html>
