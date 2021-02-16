<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Confirmation</title>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>

<body>

<div class="container">
	<%@include file="Header.jsp" %>
		<div class="panel  panel-warning">
			<div class="panel-heading">	Confirmation </div>
			<div class="panel-body">
			
			
			<div class="form-group">
			 		<label>Image : </label>
			 		<label>${produit.urlImage}</label>
			 	</div>
			 
			 	<div class="form-group">
			 		<label>ID : </label>
			 		<label>${produit.id}</label>
			 	</div>
			 	<div class="form-group">
			 		<label>Intitule : </label>
			 		<label>${produit.intitule}</label>
			 	</div>
			 	<div class="form-group">
			 		<label>Description : </label>
			 		<label>${produit.description}</label>
			 	</div>
			 	<div class="form-group">
			 		<label>Prix : </label>
			 		<label>${produit.prix}</label>
			 	</div>
			 	<div class="form-group">
			 		<label>Nombre de vote : </label>
			 		<label>${produit.nbrVote}</label>
			 	</div>
			 	<div class="form-group">
			 		<label>Quantité en stock : </label>
			 		<label>${produit.qteStock}</label>
			 	</div>
			 
			</div>
		
		
		</div>
	</div>
	<%@include file="Footer.jsp" %>

</body>
</html>