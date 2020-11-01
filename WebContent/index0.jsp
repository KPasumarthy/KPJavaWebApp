<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Kailash Java Web Application : REST APIs</title>
</head>
<body>  
<!-- KP : The content below is only a placeholder and can be replaced.-->
<div style="text-align:center">
  <h1>
     Welcome to Kailash Java Web Application : EJB Servlets & REST APIs!
  </h1>
</div>

<div>
<h3>CRUD - HTTP : GET</h2>
<form name="myForm" method="get" action=Servlet2CallKPWebAPIs>	
	<input type="submit" value="Get">
</form>
</div>

<div>
<h3>CRUD - HTTP : POST</h>
<form name="myForm" method="post" action=Servlet2CallKPWebAPIs>
	First Name : <input type="text" name="firstName" value="Kailash"></input>
	Last  Name : <input type="text" name="lastName" value="Pasumarthy"></input>
	<input type="submit" value="Post">
</form>
</div>

<div>
<h3>CRUD - HTTP : UPDATE</h>
<form name="myForm" method="update" action=Servlet2CallKPWebAPIs>
	First Name : <input type="text" name="firstName" value="Kailash"></input>
	Last  Name : <input type="text" name="lastName" value="Pasumarthy"></input>
	<input type="submit" value="Update">
</form>
</div>

<div>
<h3>CRUD - HTTP : DELETE</h>
<form name="myForm" method="delete" action=Servlet2CallKPWebAPIs>
	First Name : <input type="text" name="firstName" value="Kailash"></input>
	Last  Name : <input type="text" name="lastName" value="Pasumarthy"></input>
	<input type="submit" value="Delete">
</form>
</div>



</body>

</html>