<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Articles </title>
<!--  <link rel="stylesheet" type="text/css" href="css/bootstrap-4.3.1-dist"> --> 
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
 
</head>
<body>
		
	<div class="container">
	<%@include file="Header.jsp" %>
		<div class="panel  panel-warning">
			<div class="panel-heading">	Recherche des Produits </div>
			<div class="panel-body">
			<form action="chercher.asp" method="get">
			<label>Intitule : </label>
			<input type="text"  name="inputIntitule" />
			<button class="btn btn-warning" type="submit">Chercher</button>
			</form>
			<table class="table">
			<tr>
			<th scope="col">Image</th>
			<th scope="col">ID</th>
			<th scope="col">Intitulé</th>
			<th scope="col">Prix</th>
			<th scope="col">Quantité en stock</th>
			<th colspan="2" scope="col">Actions à faire</th>
			</tr>
			<c:forEach items="${model.listeProduit }" var="p">
			<tr>
			<td><img src="Images/${p.urlImage}"  width="150" height="100" ></td>
			<td>${p.id}</td>
			<td>${p.intitule}</td>
			<td>${p.prix}</td>
			<td>${p.qteStock}</td>
			<td><a href="modifierArticle.asp?id=${p.id}">Modifier</a></td>
			<td><a onclick="return confirm('êtes-vous sur de vouloir supprimer ?')"  href="supprimerArticle.asp?id=${p.id}">Supprimer</a></td>
			</tr>
			
			</c:forEach>
			
			</table>
			</div>
		
		
		</div>
	</div>
 

</body>
 
</html>