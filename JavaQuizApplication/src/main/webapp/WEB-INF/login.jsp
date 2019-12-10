<%@page contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@page import="fr.epita.javaquiz.*"%>

<jsp:useBean id="javaQuizDao" type="fr.epita.javaquiz.dao.JavaQuizDao"
	scope="request" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Advanced Java Quiz Web Application</title>
<style>
	body {  
    	background-color: white; 
    	margin: 10px; 
    }  
    
    #add {
    	background-color: #0080ff;
    	color: #ffffff;
    	margin: 10px;
    	padding: 10px;
    }
	
</style>
</head>
<body>
<h3 align="center">LOGIN PAGE</h3>
<form method="POST" action="javatest.html">
		Username: <br/><input id='uname' type="text" name="uname" /><br/> 
		Password: <br/><input id='password' type="text" name="password" /><br /> 
		
		<input id='login' 
			type="submit" value="Login" />
</form>
</body>
</html>