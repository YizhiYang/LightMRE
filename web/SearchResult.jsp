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
            <a class = "HomeButton" onClick="displaymessage(); return false;" style="text-decoration:none" href="#">Home</a>
            <a class = "HomeButton" onClick="displaymessage(); return false;" style="text-decoration:none" href="#">Account</a>
            <a class = "HomeButton" onClick="displaymessage(); return false;" style="text-decoration:none" href="#">Search</a>
            <a class = "HomeButton" onClick="displaymessage(); return false;" style="text-decoration:none" href="#">About Us</a>
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
                <table cellpadding="0" cellspacing="0" border="0">
                    <tbody>
                        <c:forEach items="${searchList}" var="eList">
                            <tr>
                                <td>${eList.name}</td>
                                <td>${eList.type}</td>
                                <td>${eList.price}</td>
                                <td>${eList.rating}</td>
                                <td>${eList.price}</td>
                                <td><button type="button" onclick="rentIt()">Rent It</button></td>
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

    </body>
</html>
