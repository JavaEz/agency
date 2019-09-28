<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="mytag" tagdir="/WEB-INF/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<title>Welcome!</title>

</head>
<body>
	hello${userEmail}
	<header>
		<ul>
			<li><a href="${pageContext.servletContext.contextPath}/logout">Logout</a></li>
		</ul>
		<li><a href="${pageContext.servletContext.contextPath}/adminpanel"></a></li>
		
	</header>
	<p>${loggedInUser.role == 1}</p>

	<div>
		<mytag:tourList tours="${tours}" />
	</div>
</body>
</html>
