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
            <a class = "HomeButton" onClick="displaymessage()" style="text-decoration:none" href="http://localhost:8080/LightMRE/QueryAllCustomers">Home</a>
            <a class = "HomeButton" style="text-decoration:none" href="http://localhost:8080/LightMRE/MailingList">Mailing list</a>
            <a class = "HomeButton" onClick="forwardToUserSuggestList()" style="text-decoration:none" href="#">Suggest List</a>
            <a class = "HomeButton" onClick="displaymessage()" style="text-decoration:none" href="http://localhost:8080/LightMRE/LogOut">Log Out</a>
        </div>


        <section>
            <!--for demo wrap-->
            <h1 id = "youMayLike">Mailing list</h1>
            <div class="tbl-header">
                <table cellpadding="0" cellspacing="0" border="0">
                    <thead>
                        <tr>
                            <th>Last Name</th>
                            <th>First Name</th>
                            <th>Address</th>
                            <th>City</th>
                            <th>State</th>
                            <th>ZipCode</th>
                           
                        </tr>
                    </thead>
                </table>
            </div>
            <div class="tbl-content">
                <table cellpadding="0" cellspacing="0" border="0" id="mytable">
                    <tbody>
                        <c:forEach items="${MailingList}" var="dList">
                            <tr>
                                <td contenteditable='true'>${dList.lastName}</td>
                                <td contenteditable='true'>${dList.firstName}</td>
                                <td contenteditable='true'>${dList.address}</td>
                                <td contenteditable='true'>${dList.city}</td>
                                <td contenteditable='true'>${dList.state}</td>
                                <td contenteditable='true'>${dList.zipCode}</td>
                               
                                
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
            function displaymessage() {
                window.location = "AboutUs.jsp"
            }

            function forwardToSearch() {
                window.location = "Search.jsp"
            }

            function rentIt() {
                var va = document.getElementById('movieName').value;
                alert(va);
            }


            function editEmployee(element) {

                // getting which col is selected, returned the name
                var name = document.getElementById("mytable").rows[element.parentNode.parentNode.rowIndex].cells[0].innerHTML;
                confirm("Edit " + name + "?");
            }
            function deleteEmployee(element) {

                // getting which col is selected, returned the name
                var id = document.getElementById("mytable").rows[element.parentNode.parentNode.rowIndex].cells[0].innerHTML;
                confirm("Are you sure you want to delete " + id + "?");
                location.href = "ListOfEmployees?EmployeeId=" + id;
            }
        </script>
    </body>
</html>