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
  
<!--<input id="mainButton" type="button" value="Home" onclick="displaymessage()" >
<input type="button" value="Account" onclick="displaymessage()" >
<input type="button" value="Search" onclick="displaymessage()" >
<input type="button" value="About us" onclick="displaymessage()" >-->

<a href="WorkBench.jsp">
   <input type="button" id="idname" value="Home" />
</a>

<a href="AboutUs.jsp">
   <input type="button" value="Account" />
</a>

<a href="www.google.us">
   <input type="button" value="Search" />
</a>

<a href="AboutUs.jsp">
   <input type="button" value="About Us" />
</a>

    
<script> 
    function displaymessage() { alert("Hello World!"); }
</script>


</body>
</html>