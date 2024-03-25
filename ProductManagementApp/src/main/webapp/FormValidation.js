
function validateForm() {
	//read the form data

	var ProId = document.getElementById("proId").value;
	var ProName = document.getElementById("proName").value;
	var ProPrice = document.getElementById("proPrice").value;
	var ProBrand = document.getElementById("proBrand").value;
	var ProMadeIn = document.getElementById("proMadeIn").value;


	if (ProId.trim() === "" || ProName.trim() === "" || ProPrice.trim() === "" || ProBrand.trim() === "" || ProMadeIn.trim() === "") {
		alert("All fields must be filled out")
		return false;
	}
	if (parseFloat(ProPrice) < 0) {
		alert("Product Price must be a positive value");
		return false;
	}
	if (ProName.length > 50 || ProBrand.length > 50) {
		alert("Product name and product Brand must be less than 50 characters");
		return false;
	}

	//get the mfg and exp dates
	var ProMfgDate = document.getElementById("proMfgDate").value;
	var ProExpDate = document.getElementById("proExpDate").value;

	//convert into date formate
	var manufacturingObj = new Date(ProMfgDate);
	var expiryDateObj = new Date(ProExpDate);

	//check the validations of dates
	if (manufacturingObj > expiryDateObj) {
		alert("manufacturing date cannot be greater than expiry date");
		return false;
	}
	return true;



}