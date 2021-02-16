<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Modification de produit</title>
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container col-md-8 col-md-offset-2 col-xs-12">
	<%@include file="Header.jsp" %>
		<div class="panel  panel-warning">
			<div class="panel-heading">Modifier un Produit </div>
			<div class="panel-body">
				<form action="updateProduit.asp" method="post" enctype="multipart/form-data">
				
					<div class="form-group">
						<label class="control-label">ID</label>
						<input type="text" name="id"  value="${produit.id}" class="form-control" required="required"/>
						<span></span>
					</div>
					<div class="form-group">
						<label class="control-label">Description</label>
						<input type="text" name="description" value="${produit.description}"  class="form-control" required="required"/>
						<span></span>
					</div>
				
					<div class="form-group">
						<label class="control-label">Intitulé</label>
						<input type="text" name="intitule" value="${produit.intitule}" class="form-control" required="required"/>
						<span></span>
					</div>
					<div class="form-group">
						<label class="control-label">Prix</label>
						<input type="text" name="prix" value="${produit.prix}" class="form-control" required="required"/>
						<span></span>
					</div>
						<div class="form-group">
						<label class="control-label">Nombre de vote</label>
						<input type="text" name="nbrVote"  value="${produit.nbrVote}" class="form-control" required="required"/>
						<span></span>
					</div>
					<div class="form-group">
						<label class="control-label">Quantité en stock</label>
						<input type="text" value="${produit.qteStock}"  name="qteStock" required="required" class="form-control"/>
						<span></span>
					</div>
					<div class="form-group">
						<label class="control-label">Image du produit</label>
						<input type="file" name="urlImage"   class="form-control" required="required"/>
						<span></span>
					</div>
					<div>
						<button type="submit" class="btn btn-warning">Modifier</button>
					</div>
				</form>
		 
			 
			</div>
		
		
		</div>
	</div>

</body>
</html>