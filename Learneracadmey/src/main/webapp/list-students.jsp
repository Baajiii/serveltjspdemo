
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List of Students</title>
<link type="text/css" rel="stylesheet">
</head>
<body>
<div  >
	<jsp:include page="left-list.jsp" />	
		<div >
			<div >
				<h3>Students</h3>
			</div>
		</div>


		<div>

			<div >

				<table>

					<tr>

						<th>First Name</th>
						<th>Last Name</th>
						<th>age</th>
						

					</tr>

					<c:forEach var="tempStudent" items="${STUDENT_LIST }">
						<tr>

							<td>${tempStudent.fname}</td>
							<td>${tempStudent.lname}</td>
							<td>${tempStudent.age}</td>



						</tr>


					</c:forEach>

				</table>
			</div>
		</div>
	</div>

</body>
</html>