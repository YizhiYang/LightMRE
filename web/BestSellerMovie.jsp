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
            <a class = "HomeButton" onClick="displaymessage()" style="text-decoration:none" href="#">Movies</a>
            <a class = "HomeButton" onClick="forwardToSearch()" style="text-decoration:none" href="#">Employees</a>
            <a class = "HomeButton" onClick="displaymessage()" style="text-decoration:none" href="#">About Us</a>
        </div>


        <section>
            <!--for demo wrap-->
            <h1 id = "youMayLike">Best Sell Movies</h1>
            <div class="tbl-header">
                <table cellpadding="0" cellspacing="0" border="0">
                    <thead>
                        <tr>
                            <th>Movie</th>
                            <th>Type</th>
                            <th>Rating</th>
                            <th>Price</th>
                            <th></th>
                            <th><button onclick="location.href = 'AddEmployee.jsp'">Add Employee</button></th>
                        </tr>
                    </thead>
                </table>
            </div>
            <div class="tbl-content">
                <table cellpadding="0" cellspacing="0" border="0" id="mytable">
                    <tbody>
                        <c:forEach items="${BestSellList}" var="dList">
                            <tr>
                                <td>${dList.name}</td>
                                <td>${dList.type}</td>
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
            <img src="images/sbuLogoSmall.png" alt="Smiley face" height="208" width="252">
            </br>
            LightMRE
        </div>

        <c:choose>
            <c:when test="${deleteStatus =='false'}">
                <script> deleteFalse()</script> 
                <br />
            </c:when>    
            <c:when test="${deleteStatus =='true'}">
                <script> deleteTrue()</script>
                <br />
            </c:when>
            <c:otherwise>
            </c:otherwise>
        </c:choose>

        <script>

        </script>
    </body>
</html>