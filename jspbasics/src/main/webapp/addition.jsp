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
		<%
		int n1 = Integer.parseInt(request.getParameter("number1"));
		int n2 = Integer.parseInt(request.getParameter("number2"));
		%>
		
		<h1>sum of <%= n1 %> and <%= n2 %> = <%=n1+n2 %> </h1>

		<jsp:include page="footer.jsp" />
	

</body>
</html>
