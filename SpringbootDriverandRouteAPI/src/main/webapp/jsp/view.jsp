<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

<script src="https://code.jquery.com/jquery-3.5.1.js"></script>
<script
	src="https://cdn.datatables.net/1.10.21/js/jquery.dataTables.min.js"></script>
<!-- //cdn.datatables.net/1.10.21/css/jquery.dataTables.min.css
 --><link href="https://cdn.datatables.net/1.10.21/css/jquery.dataTables.min.css"
	rel="stylesheet" type="text/css">


<script type="text/javascript">

$(document).ready(function () {
    $('#emptab').DataTable({
        pagingType: 'full_numbers',
    });
});
</script>





</head>
<body>
<h3>View  Driver</h3>
<a href="/">AddDriver</a>
<table id="drivertab" class="table">
<thead class="thead-dark">
<tr>
<th>
DriverId
</th>
<th>
FirstName
</th>
<th>
LastName
</th>
<th>
MobileNumber
</th>
<th>
LicenseNumber
</th>
<th>Edit</th>
<th>Delete</th>
</tr>
</thead>
<tbody>
<c:forEach items="${drivers}" var="driver">
<tr>
<td>${driver.driverid}</td>

<td>${driver.firstname}</td>
<td>${driver.lastname}</td>
<td>${driver.mobilenumber}</td>
<td>${driver.licensenumber}</td>
<td><a href="editDriver?eid=${driver.driverid}">Edit</a></td>
     <td><a href="deleteDriver?eid=${driver.driverid}">Delete</a>

</tr>

</c:forEach>

</tbody>

</table>
</body>
</html>