<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


	<jsp:include page="header.jsp" />
	<%!
		String makeItLower(String data) {
			return data.toLowerCase();
		}
	%>
	
	Lower case "Hello world": <%= makeItLower("HELLO WORLD") %>
	<jsp:include page="footer.jsp" />
	
</body>
</html>