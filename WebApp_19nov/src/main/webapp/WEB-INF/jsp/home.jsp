<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <form action="addAlien">
        Aid : <input type="text" name="aid" /><br/>
        AName : <input type="text" name="aname" /><br/> 
        <input type="submit"  />
    </form>
    <br/>
     <form action="getAlien">
        Aid : <input type="text" name="aid" /><br/>
        
        <input type="submit"  />
    </form>
    <form action="deleteAlien">
        Aid To be deleted: <input type="text" name="aid" /><br/>
        
        <input type="submit"  />
    </form>
</body>
</html>