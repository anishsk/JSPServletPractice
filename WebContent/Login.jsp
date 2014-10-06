<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script type='text/javascript' src='js\scripts.js'></script>
<link rel="stylesheet" type="text/css" href="css\style.css" />
<title>Insert title here</title>
</head>
<body>
	<div class="container" id="logincontainer">
		<form action="LoginResponse" name="loginform" method="post">
			<input type="text" required="required" name="uname" placeholder="Username"/>
			<input type="password" required="required" name="password" placeholder="Password"/>
			<input type="submit" value="Submit" onclick="return checkPasslen();">
		</form>
	</div>
</body>
</html>