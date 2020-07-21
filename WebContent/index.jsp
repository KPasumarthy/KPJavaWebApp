<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Kailash Java Web Application</title>
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/style.css" rel="stylesheet">
<link href="css/skin.css" rel="stylesheet">
<link href="css/pricingCol.css" rel="stylesheet">
<!-- KP : <link rel="stylesheet" href="css/font-awesome.min.css">-->
<link rel="stylesheet" href="css/bootstrap-grid.min.css" />
<link href="css/StyleSheet.css" rel="stylesheet" />

<script src="js/jquery.min.js"></script>
<script src="js/jsCall2ServletKPWebAPIs.js"></script>
<script src="js/elementTransitions.min.js"></script>
<script src="js/modernizr.custom.js"></script>
<script src="js/bootstrap.min.js"></script>
</head>
<body>  

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



<!-- KP : The content below is only a placeholder and can be replaced.-->
<div style="text-align:center">
  <h1>
    Welcome to Kailash Java Web Application : REST APIs!
  </h1>
</div>
<div>
<form name="myForm" method="get" action=Servlet2CallKPWebAPIs>
	First Name : <input type="text" name="firstName" value="Kailash"></input>
	Last  Name : <input type="text" name="lastName" value="Pasumarthy"></input>
	<input type="submit" value="Post">
</form>

</div>
</body>

</html>