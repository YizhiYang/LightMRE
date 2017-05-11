<%-- 
    Document   : AddEmployee
    Created on : Apr 17, 2017, 11:04:51 PM
    Author     : MATT
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<link rel="stylesheet" href="css/style.css" type="text/css">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>

    <style>
        /* Full-width input fields */

        *{
            margin: 0;
            padding: 0;
            box-sizing: border-box;
            -webkit-box-sizing: border-box;
            -moz-box-sizing: border-box;
            -webkit-font-smoothing: antialiased;
            -moz-font-smoothing: antialiased;
            -o-font-smoothing: antialiased;
            font-smoothing: antialiased;
            text-rendering: optimizeLegibility;
        }

        body {

            color: #777;
            background: -webkit-linear-gradient(left, #25c481, #25b7c4);
            background: linear-gradient(to right, #25c481, #25b7c4);
        }

        .container {
            max-width: 400px;
            width: 100%;
            margin: 0 auto;
            position: relative;
        }

        #contact input[type="text"],
        #contact input[type="email"],
        #contact input[type="tel"],
        #contact input[type="url"],
        #contact textarea,
        #contact button[type="submit"] {
            font: 400 12px/16px "Roboto", Helvetica, Arial, sans-serif;
        }

        #contact {
            background: #F9F9F9;
            padding: 25px;
            margin: 150px 0;
            box-shadow: 0 0 20px 0 rgba(0, 0, 0, 0.2), 0 5px 5px 0 rgba(0, 0, 0, 0.24);
        }

        #contact h3 {
            display: block;
            font-size: 30px;
            font-weight: 300;
            margin-bottom: 10px;
        }

        #contact h4 {
            margin: 5px 0 15px;
            display: block;
            font-size: 13px;
            font-weight: 400;
        }

        fieldset {
            border: medium none !important;
            margin: 0 0 10px;
            min-width: 100%;
            padding: 0;
            width: 100%;
        }

        #contact input[type="text"],
        #contact input[type="email"],
        #contact input[type="tel"],
        #contact input[type="url"],
        #contact textarea {
            width: 100%;
            border: 1px solid #ccc;
            background: #FFF;
            margin: 0 0 5px;
            padding: 10px;
        }

        #contact input[type="text"]:hover,
        #contact input[type="email"]:hover,
        #contact input[type="tel"]:hover,
        #contact input[type="url"]:hover,
        #contact textarea:hover {
            -webkit-transition: border-color 0.3s ease-in-out;
            -moz-transition: border-color 0.3s ease-in-out;
            transition: border-color 0.3s ease-in-out;
            border: 1px solid #aaa;
        }

        #contact textarea {
            height: 100px;
            max-width: 100%;
            resize: none;
        }

        #contact button[type="submit"] {
            cursor: pointer;
            width: 100%;
            border: none;
            background: -webkit-linear-gradient(left, #25c481, #25b7c4);
            color: #d4ecfc;
            margin: 0 0 5px;
            padding: 10px;
            font-size: 15px;
        }

        #contact button[type="submit"]:hover {
            background: #43A047;
            -webkit-transition: background 0.3s ease-in-out;
            -moz-transition: background 0.3s ease-in-out;
            transition: background-color 0.3s ease-in-out;
        }

        #contact button[type="submit"]:active {
            box-shadow: inset 0 1px 3px rgba(0, 0, 0, 0.5);
        }

        .copyright {
            text-align: center;
        }

        #contact input:focus,
        #contact textarea:focus {
            outline: 0;
            border: 1px solid #aaa;
        }

        ::-webkit-input-placeholder {
            color: #888;
        }

        :-moz-placeholder {
            color: #888;
        }

        ::-moz-placeholder {
            color: #888;
        }

        :-ms-input-placeholder {
            color: #888;
        }

    </style>



    <body>


        <div class = "topnav">
            <a class = "HomeButton" onClick="displaymessage()" style="text-decoration:none" href="http://localhost:8080/LightMRE/HomePageServ">Home</a>
            <a class = "HomeButton" onClick="displaymessage()" style="text-decoration:none" href="#">Movies</a>
            <a class = "HomeButton" onClick="forwardToSearch()" style="text-decoration:none" href="http://localhost:8080/LightMRE/ListOfEmployees">Employees</a>
            <a class = "HomeButton" style="text-decoration:none" href="http://localhost:8080/LightMRE/QueryAllCustomers">Customers</a>
            <a class = "HomeButton" onClick="displaymessage()" style="text-decoration:none" href="SalesReport.jsp">Sales Report</a>
            <a class = "HomeButton" onClick="displaymessage()" style="text-decoration:none" href="http://localhost:8080/LightMRE/LogOut">Log Out</a>
        </div>

        <div class="container">  
            <form id="contact" action="http://localhost:8080/LightMRE/EditMovieTransaction" method="post">
                <h3>Edit Movie</h3>
                <h4>Movie details</h4>
                <fieldset>
                    <input name="lastname" value ="${lastName}" placeholder="Last Name" type="text" tabindex="1" required autofocus>
                </fieldset>
                <fieldset>
                    <input name="firstName" value ="${firstName}" placeholder="Frist Name" type="text" tabindex="1" required autofocus>
                </fieldset>
                <fieldset>
                    <input name="address" value ="${address}" placeholder="Address" type="text" tabindex="2" required>
                </fieldset>
                <fieldset>
                    <input name="city" value ="${city}" placeholder="City" type="text" tabindex="3" required>
                </fieldset>
                <fieldset>
                    <input name="state" value ="${state}" placeholder="State" type="text" tabindex="4" required>
                </fieldset>
                <fieldset>
                    <input name="zipcode" value ="${zipcode}" placeholder="Zip Code" type="text" tabindex="5" required>
                </fieldset>
                <fieldset>
                    <input name="telephone" value ="${telephone}" placeholder="Telephone" type="text" tabindex="6" required>
                </fieldset>
                <fieldset>
                    <input name="email" value ="${email}" placeholder="Email" type="text" tabindex="7" required>
                </fieldset>
                <fieldset>
                    <input name="CreditCardNumber" value ="${creditCardNumber}" placeholder="Credit Card Number" type="text" tabindex="8" required>
                </fieldset>
                <fieldset>
                    <input name="Type" value ="${type}" placeholder="Type" type="text" tabindex="8" required>
                </fieldset>
                <fieldset>
                    <input name="password" value ="${password}" placeholder="password" type="text" tabindex="8" required>
                </fieldset>

                <button name="Save" type="submit" id="contact-submit" data-submit="...Sending">Save</button>
                </fieldset>
            </form>
        </div>


        <div class="made-with-love">
            <img src="images/sbuLogoSmall.png" alt="Smiley face" height="208" width="252">
            </br>
            LightMRE
        </div>

    </body>



</html>
