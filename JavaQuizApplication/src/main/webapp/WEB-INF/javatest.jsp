<%@page import="fr.epita.javaquiz.model.Questionaire"%>
<%@ page import="java.sql.*"%>
<jsp:useBean id="javaQuizDao" type="fr.epita.javaquiz.dao.JavaQuizDao"
	scope="request" />
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Java Quiz Application</title>
<style>
	body {  
    	background-color: white; 
    	margin: 20px; 
    }  
    
</style>
</head>
<body>
	<h3 align="center">JAVA QUIZ</h3>
	
	<form method="post" action="questions.html">
		<% int count = 1;%>
		<ol type="1">
			<%
			for (Questionaire question : javaQuizDao.getQuestionaire()) {
		%>
			
			<li><%=question.getQuestionaire()%> <input type="hidden"
				name="questionId" value="<%=count%>">
				<ol type="a">
					<%
					for (int j=0; j < question.getChoiceList().length; j++) {	
				%>
					<li><input type="radio" name="question_<%=count %>"
						value="<%=question.getChoiceList()[j]%>"> <%=question.getChoiceList()[j]%></li>
					<% } %>
				</ol></li>
			<% count++; %>
			<% } %>
		</ol>
		<br><input id='result' type="submit" value="Submit">
		<br/><br/><br/>
		<input id='total' type="hidden"
				name="total">
		
		Your Total Score is: <%= request.getAttribute("total") %>
	</form>
</body>
</html>
