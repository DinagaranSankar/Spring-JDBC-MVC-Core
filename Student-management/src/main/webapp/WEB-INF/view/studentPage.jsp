<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:directive.page isELIgnored="false" />
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <link rel="stylesheet" type="text/css"  href ="/Student-management/resources/css/Stylesheet.css">   
     <script type = "text/javascript">
             function confirmComplete() 
             {
    	            var answer=confirm("Are you sure you want to delete this record ?");
    	            if (answer==true)
    	            {
    	                   return true;
    	             }
    	             else
    	             {
    	                    return false;
    	              }
    	      }
      </script>      
</head>
<!-- 	        <form action="addStudent">
	              <input type="submit"  value="ADD" class="btn btn-secondary"/>   --><!-- class="btn btn-outline-*
	         </form> -->
 <h1>Student Management
          <img alt ="Student Logo" src=" /Student-management/images/smLogo.png"  class="avatar" >
 </h1>
 <br/>
<body class = "intro">
    <div align="left">                       
	<table border="1"    class="table table-striped table-hover"->
		<thead class = "table-dark">
			<tr>
				<td>ID</td>
				<td>Name</td>
				<td>Mobile</td>
				<td>Country</td>
				<td>Insert</td>
				<td>Update</td>
				<td>Delete</td>
			</tr>
		</thead>
		<c:forEach items="${students}" var="student">
			<tr>
				<td>${student. id}</td>
				<td>${student. name}</td>
				<td>${student. mobile}</td>
				<td>${student. country}</td>
				<td><a href="/Student-management/addStudent"><input type=button  value='Insert'  class="btn btn-primary"></a></td>
				<td><a href="/Student-management/updateStudent?StudentId=${student. id}"><input type=button  value='Update' class="btn btn-warning"></a></td>
				<td><a href="/Student-management/deleteStudent?StudentId=${student. id}"  onclick="{return confirmComplete();}"><input type=button  value='Delete'  class="btn btn-danger"></a></td>
			</tr>
		</c:forEach>
	</table>
	
	 <img alt ="Student Photo" src=" /Student-management/images/learning.jpg" style="width:100%;height:450px">
	 
</div>
</body>
</html>