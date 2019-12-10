<%-- <%@page import="com.epita.quizapp.obj.MultipleChoices"%>

<%@page import="com.epita.quizapp.obj.QuizQuestions"%>

<%@page contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@page import="com.epita.quizapp.*"%>

<jsp:useBean id="quizDao" type="com.epita.quizapp.dao.QuizDao"
	scope="request" />

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"

    "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<title>Quiz Web Application</title>
<style>
	body {  
    	background-color: lightblue; 
    	margin: 20px; 
    }  
    
    #question, 
    #option1, 
    #option2, 
    #option3, 
    #correctanswer {
    	padding: 5px;
    	margin: 5px;
    	width: 50%;
    }
    
    #add {
    	background-color: #0080ff;
    	color: #ffffff;
    	margin: 20px;
    	padding: 10px;
    }
	
</style>
</head>

<body>
    <h3 align="center">ADMIN PAGE</h3>
	<h4 align="center">Add Questions with Multiple choices and correct answer to the Database</h4>

	<form method="POST" action="addquestions.html" style='align-content: center;'>

		Question: <br/><input id='question' type="text" name="quizquestion" /><br/> Option 1: <br/><input
			id='option1' type="text" name="option1" /><br /> Option 2: <br/><input id='option2' type="text"
			name="option2" /><br /> Option 3: <br/><input id='option3' type="text" name="option3" /><br />

		Correct Answer: <br/><input id='correctanswer' type="text" name="correctanswer" /><br /> 
		<input id='add' 
			type="submit" value="Add" />

		<ol>

			<%
				for (QuizQuestions quest : quizDao.getQuestions()) {
			%>

			<li><%=quest.getQuizQuestion()%></li>

			<%
				}
			%>

		</ol>

		<hr>

	</form>

</body>

</html> --%>