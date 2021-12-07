<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<title>First Web Application</title>
</head>

<body>
    <font color="red">${obj.aname}</font>
    <form method="post">
        Name : <input type="text" name="name" /><br/>
        Password : <input type="password" name="password" /><br/> 
        <input type="submit" />
    </form>
</body>

</html>
