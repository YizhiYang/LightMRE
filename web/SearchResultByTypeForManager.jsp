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
            
            <a class = "HomeButton" onClick="forwardToSearch()" style="text-decoration:none" href="http://localhost:8080/LightMRE/ListOfEmployees">Employees</a>
            <a class = "HomeButton" style="text-decoration:none" href="http://localhost:8080/LightMRE/QueryAllCustomers">Customers</a>
            <a class = "HomeButton" onClick="forwardToSearch()" style="text-decoration:none" href="#">Search</a>
            <a class = "HomeButton" onClick="displaymessage()" style="text-decoration:none" href="SalesReport.jsp">Sales Report</a>
            <a class = "HomeButton" onClick="displaymessage()" style="text-decoration:none" href="http://localhost:8080/LightMRE/LogOut">Log Out</a>
        </div>


        <section>
            <!--for demo wrap-->
            <h1 id = "youMayLike">Search Result:</h1>
            <div class="tbl-header">
                <table cellpadding="0" cellspacing="0" border="0">
                    <thead>
                        <tr>
                            <th>Movie Name</th>
                            <th>Movie Type</th>
                            <th>Last Name</th>
                            <th>First Name</th>
                        </tr>
                    </thead>
                </table>
            </div>
            <div class="tbl-content">
                <table cellpadding="0" cellspacing="0" border="0">
                    <tbody>
                        <c:forEach items="${resultBean}" var="eList">
                            <tr>
                                <td>${eList.name}</td>
                                 <td>${eList.type}</td>
                                <td>${eList.lastName}</td>
                                <td>${eList.firstName}</td>
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
                window.location = "ManagerSearch.jsp"
            }
        </script>
    </body>
</html>
