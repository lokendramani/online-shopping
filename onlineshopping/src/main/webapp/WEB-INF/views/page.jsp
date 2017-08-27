<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<spring:url var="css" value="/resources/css" />
<spring:url var="js" value="/resources/js" />
<spring:url var="images" value="/resources/images" />
<c:set var="contextRoot" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title>Online Shopping - ${title}</title>

<script>
	window.menu = '${title}'
	window.contextRoot='${contextRoot}'
</script>
<!-- Bootstrap Core CSS -->
<link href="${css}/bootstrap.min.css" rel="stylesheet">

<!-- Bootstrap Readable theme -->
<link href="${css}/bootstrap-readable-theme.css" rel="stylesheet">

<!-- Datatable Bootstrap CSS -->
<link href="${css}/dataTables.bootstrap.css" rel="stylesheet">


<!-- Custom CSS -->
<link href="${css}/myapp.css" rel="stylesheet">

<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<body>
	<div class="wrapper">
	
		<%@include file="./shared/navbar.jsp"%>
		<!-- Page Content -->

		<div class="content">

			<c:if test="${userClickHome == true}">
				<!-- Home content -->
				<%@include file="home.jsp"%>
			</c:if>

			<c:if test="${userClickAbout == true}">
				<!-- About content -->
				<%@include file="about.jsp"%>
			</c:if>



			<c:if test="${userClickContact == true}">
				<!-- Contact content -->
				<%@include file="contact.jsp"%>
			</c:if>
			<c:if test="${userClickAllProducts == true or userClickCategoryProducts == true}">
				<!-- Contact content -->
				<%@include file="listProducts.jsp"%>
			
			</c:if>
			<!-- User click showProduct -->
			<c:if test="${userClickShowProduct == true}">
				<!-- Contact content -->
				<%@include file="singleProduct.jsp"%>
			
			</c:if>
			
			<!-- Load only when User click ManageProduct -->
			<c:if test="${userClickManageProduct == true}">
				<!-- Contact content -->
				<%@include file="manageProducts.jsp"%>
			
			</c:if>
						
			
			<!-- /.container -->

		</div>
		<!-- Footer comes here -->
		<%@include file="./shared/footer.jsp"%>
		<!-- /.container -->

		<!-- jQuery -->
		<script src="${js}/jquery.js"></script>
		
		<!-- jQuery validation -->
		<script src="${js}/jquery.validate.js"></script>
		
		
		<!-- Bootstrap Core JavaScript -->
		<script src="${js}/bootstrap.min.js"></script>
		<!-- Data Table Jquery -->
		<script src="${js}/jquery.dataTables.js"></script>
		<!-- Data Table Bootstrap js -->
		<script src="${js}/dataTables.bootstrap.js"></script>
		
		<!-- Bootbox js -->
		<script src="${js}/bootbox.min.js"></script>
		
		
		<!-- Self coded JS file -->
		<script src="${js}/myapp.js"></script>
	</div>
</body>

</html>