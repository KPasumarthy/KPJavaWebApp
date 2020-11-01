<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Kailash Java Web Application : REST APIs!</title>
</head>
<body>  
<!-- KP : The content below is only a placeholder and can be replaced.-->
<div style="text-align:center">
  <h1>
    Welcome to Kailash Java Web Application - EJB Servlets!
  </h1>
</div>

<div>
<%
	//out.println(request.getAttribute("zero"));
    //out.println(request.getAttribute("message"));
	//out.println(request.getContextPath());
	//out.println("<b>Welcome " + request.getAttribute("rs") + "!</b>");
	out.println(request.getAttribute("strTable"));
%>
</div>



<div class="container-fluid">
		<div class="row">
			<div class="col-md-12">
				<div id="header" class="clearfix">
					<img class="header" role="img"
						aria-label="This is the main header logo"
						src="images/KPIcon32x32.ico" 
						alt="logo">
				</div>
			</div>

			<div class="col-md-3">
				<br />
			</div>
		</div>
	</div>

<div>
<form name="myForm" method="get" action=Servlet2CallKPWebAPIs>
	First Name : <input type="text" name="firstName" value="Kailash"></input>
	Last  Name : <input type="text" name="lastName" value="Pasumarthy"></input>
	<input type="submit" value="Post">
</form>

</div>

<div class="container-fluid">
		<div class="row">
			<div class="col-md-12">
				<div id="header" class="clearfix">
					<img class="header" role="img"
						aria-label="This is the main header logo"
						src="images/KPIcon32x32.ico" 
						alt="logo">
				</div>
			</div>

			<div class="col-md-3">
				<br />
			</div>
		</div>
	</div>

</body>

</html>



