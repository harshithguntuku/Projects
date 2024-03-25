<%@page import="com.harshith.project.ProductDao" import ="java.util.Base64"%>
<%@page language="java" contentType="text/html"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<title>Product List</title>
	<!--  Bootstrap CDN link to get the support of Bootstrap-->
	<link rel = "stylesheet"
	href = "https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
</head>

<body>
	<div>
			<h1 class = "text-center text-success" >List of Available products</h1>
	</div>	
	
	<div>
		<a class = "btn btn-success" href = "add-product.html">Save Product</a>	
	</div>	
	
	<div>
		<input type ="text" placeholder="search">
	</div>
	
	<div>
		<c:if test = "${saveResult==1}">
			<h1 class="text-success text-center">Data Inserted Successfully</h1>
		</c:if>
	</div>

	<div>
		<c:if test = "${deleteResult==1}">
			<h1 class="text-danger text-center">Data Deleted Successfully</h1>
		</c:if>
	</div>	
<table class = "table table-bordered table-striped">
<thead class = "thead-dark">

	<tr>
		<th>Product Id</th>
		<th>Product Name</th>
		<th>Product Price</th>
		<th>Brand</th>
		<th>Made In</th>
		<th>Mfg Date</th>
		<th>Expiry Date</th>
		<th>Image</th>
		<th>Actions</th>
		
	</tr>
</thead>

<tbody>
<c:forEach var = "product" items = "<%=new ProductDao().findAll()%>">
	<tr>
		<td>${product.proId}</td>
		<td>${product.proName}</td>
		<td>${product.proPrice}</td>
		<td>${product.proBrand}</td>
		<td>${product.proMadeIn}</td>
		<td>${product.proMfgDate}</td>
		<td>${product.proExpDate}</td>
		<td>
		<img src="data:image/jpeg;base64,${Base64.getEncoder().encodeToString(product.proImage)}" alt="Product Image"
		style="max-width: 100px; max-height: 100px;">
		</td>
		
		<td>
			<a class = "btn btn-danger"
			href = "./DeleteProductServlet?proId=${product.proId}">Delete</a>
			<a class = "btn btn-primary"
			href = "./EditProductServlet?proId=${product.proId}">Edit</a>
		</td>

	</tr>
</c:forEach>				
</tbody>			
</table>
</body>
</html>