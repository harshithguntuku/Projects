<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import ="java.util.Base64"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Form</title>
	<!--  Bootstrap CDN link to get the support of Bootstrap-->
	<link rel = "stylesheet"
	href = "https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
	
	<!--  This is java script validation code location -->
	<script src = "FormValidation.js"></script>
</head>

<body style="background-image: url(whitebg.jpg)">
	<div class = "container mt-5 text-center">
		<h2 class = "text-center font-italic mb-1">Edit Form...</h2>
			<form method= "post" action="UpdateProductServlet"
			enctype = "multipart/form-data" onsubmit ="return validateForm()">
	
		<div class = "form-group">
		<label class = "font-italic font-weight-bold"
		for = "proId">Product Id:</label>
		<input type="number" class="form-control-sm" id="proId"
		name ="proId" value="${existingProduct.proId}" required>
		</div>
		
		<div class = "form-group">
		<label class = "font-italic font-weight-bold"
		for = "proName">Product Name:</label>
		<input type="text" class="form-control-sm" id="proName"
		name ="proName" value="${existingProduct.proName}" required>
		</div>
		
		<div class = "form-group">
		<label class = "font-italic font-weight-bold"
		for = "proPrice">Product Price:</label>
		<input type="number" class="form-control-sm" id="proPrice"
		name ="proPrice" value="${existingProduct.proPrice}" required>
		</div>
		
		<div class = "form-group">
		<label class = "font-italic font-weight-bold"
		for = "proBrand">Product Brand:</label>
		<input type="text" class="form-control-sm" id="proBrand"
		name ="proBrand" value="${existingProduct.proBrand}" required>
		</div>
		
		<div class = "form-group">
		<label class = "font-italic font-weight-bold"
		for = "proMadeIn">Product MadeIn:</label>
		<input type="text" class="form-control-sm" id="proMadeIn"
		name ="proMadeIn" value="${existingProduct.proMadeIn}" required>
		</div>		
		
		<div class = "form-group">
		<label class = "font-italic font-weight-bold"
		for = "proMfgDate">Product Manufacture date:</label>
		<input type="date" class="form-control-sm" id="proMfgDate"
		name ="proMfgDate" value="${existingProduct.proMfgDate}"required>
		</div>		

		<div class = "form-group">
		<label class = "font-italic font-weight-bold"
		for = "proExpDate">Product Expiry date:</label>
		<input type="date" class="form-control-sm" id="proExpDate"
		name ="proExpDate" value="${existingProduct.proExpDate}" required>
		</div>		
		
		<!--  Display the current product image -->
		<div class = "form-group">
		<label class = "font-italic font-weight-bold"
		for = "proImage">Current Product Image:</label>
		<img id = "currentImage"
		src = "data:image/jpeg;base64,${Base64.getEncoder().encodeToString(existingProduct.proImage)}"
		alt = "Current Product Image" style="max-width: 100px; max-height : 100px;">
		<input type = "hidden" id="existingImage"
		name ="existingImage" accept="image/*" value="${existingProduct.proImage}" />
		</div>
		
		<!-- Allow users to upload a new image -->
		<div class="form-group">
			<label class = "font-italic font-weight-bold" for="newProImage">New Product Image:</label>
			<input type = "file" class="form-control-file-sm" id="newProImage" name="newProImage"
			accept="image/*">
		</div>
		
		<div>
		<input type="submit" class="btn btn-success" value = "update"/>
		<a href="productList.jsp" class="btn btn-primary">List of products</a>
		</div>						
				
	</form>
	</div>	
		
</body>
</html>