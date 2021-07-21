<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
 <!--    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
  -->   <link rel="stylesheet" type="text/css"  href  ="/Student-management/resources/css/AddStylesheet.css">
<!--      <link rel="stylesheet" type="text/css"  href ="/Student-management/resources/css/Stylesheet.css"> -->
</head>

<body class="image" >
   <div class="container">
          <h2 align=center>Insert / Update Student</h2>
                    <form:form action="saveStudentData" method="POST" modelAttribute="studentDTO">
                         <div  align="center"> 
                               <form:hidden  path="Id"/>     
			<p style="margin-left : 10px">
				<label for="name" class="label" >Name </label>
				<form:input path="name" id="name" cssClass="box" />
				<form:errors align ="center"  path="name" cssClass="Error" />
			</p>

			<p>
				<label for="mobile" class="label">Mobile </label>
				<form:input path="mobile" id="mobile" cssClass="box" />
				<form:errors align ="center"  path="mobile" cssClass="error" />
			</p>

			<p style="margin-right : 20px">
				<label for="country" class="label">Country </label>
				<form:input path="country" id="country"   cssClass="box"/>
				<form:errors align ="center"  path="country" cssClass="errors" />
			</p>

			<input type="submit" value="SUBMIT"  class="btn-danger" />             
         </div>    
         
</form:form>
</div>
</body>
</html>