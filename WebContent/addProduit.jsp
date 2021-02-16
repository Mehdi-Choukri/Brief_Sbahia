<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add Product</title>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container col-md-8 col-md-offset-2 col-xs-12">
	<%@include file="Header.jsp" %>
		<div class="panel  panel-warning">
			<div class="panel-heading">Ajouter un produit</div>
			<div class="panel-body">
				<form action="saveProduct.asp" method="post" enctype="multipart/form-data">
					<div class="form-group">
						<label class="control-label">Description</label>
						<input type="text" name="description"   class="form-control" required="required"/>
						<span></span>
					</div>
					<div class="form-group">
						<label class="control-label">Prix</label>
						<input type="text" name="prix"   class="form-control" required="required"/>
						<span></span>
					</div>
					<div class="form-group">
						<label class="control-label">Quantité en stock</label>
						<input type="text" name="qteStock"   class="form-control" required="required"/>
						<span></span>
					</div>
					<div class="form-group">
						<label class="control-label">Intitule</label>
						<input type="text" name="intitule"   class="form-control" required="required"/>
						<span></span>
					</div>
					<div class="form-group">
						<label class="control-label">Url image</label>
						<input type="file" name="urlImage"   class="form-control" required="required"/>
						<span></span>
					</div>
					 
					 
					<div>
						<button type="submit" class="btn btn-warning">Ajouter</button>
					</div>
				</form>
		 
			 
			</div>
		
		
		</div>
	</div>

</body>
</html>