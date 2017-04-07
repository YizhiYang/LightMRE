<%-- 
    Document   : WorkBench
    Created on : Apr 5, 2017, 5:17:51 PM
    Author     : MATT
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<link rel="stylesheet" href="css/style.css" type="text/css">

</head>
<body>
  

<div class = "topnav">
<a class = "HomeButton" onClick="displaymessage(); return false;" style="text-decoration:none" href="#">Home</a>
<a class = "HomeButton" onClick="displaymessage(); return false;" style="text-decoration:none" href="#">Account</a>
<a class = "HomeButton" onClick="displaymessage(); return false;" style="text-decoration:none" href="#">Search</a>
<a class = "HomeButton" onClick="displaymessage(); return false;" style="text-decoration:none" href="#">About Us</a>
</div>
    
<script> 
    function displaymessage() {
        window.location = "AboutUs.jsp" 
    }
</script>


</body>
</html>