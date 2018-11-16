<%-- 
    Document   : login
    Created on : 7-Nov-2018, 9:34:21 AM
    Author     : awarsyle
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
        <h1>Login Page</h1>
        <form method="post" action="login">
            username: <input type="text" required name="username"><br>
            password: <input type="password" required name="password"><br>
            <input type="submit" value="Submit">
        </form>
    </body>
</html>
