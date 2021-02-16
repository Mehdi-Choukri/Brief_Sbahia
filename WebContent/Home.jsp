<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Home</title>
<!--  <link rel="stylesheet" type="text/css" href="css/bootstrap-4.3.1-dist"> --> 
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/javascript.util/0.12.12/javascript.util.min.js" integrity="sha512-oHBLR38hkpOtf4dW75gdfO7VhEKg2fsitvHZYHZjObc4BPKou2PGenyxA5ZJ8CCqWytBx5wpiSqwVEBy84b7tw==" crossorigin="anonymous"></script>
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.2/css/all.min.css" integrity="sha512-HK5fgLBL+xu6dm/Ii3z4xhlSUyZgTT9tuc/hSrtw6uzJOvgRr2a9jyxxT1ely+B+xFAmJKVSTbpM/CuL7qxO8w==" crossorigin="anonymous" />
  
  
</head>
<style>
    .wrapper-container
    {
        display: flex;
        flex-wrap: wrap;
        width:1000px;
        
        margin: auto;
    }
    .break 
    {
        flex-basis: 100%;
        height: 0;  
    }
    .wrapper
    {
        width:300px;
        height:470px;
        border : 1px solid silver;
        font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
        margin-left: 25px;
        margin-top: 25px;
    }
    .wrapper-topSide
    {
        display: flex;
     
        
    }
    .wrapper-topSide-right
    {
        margin-left: 140px;
    }
    .fa-heart
    {
         font-size: 25px;
         color :#E7AB3C;
         

    }
    .wrapper-downSide1 ,.wrapper-downSide2 p{
        text-align: center;

    }
    .wrapper-topSide-left
    {
        width:100px;
        height:30px;
        background-color: #E7AB3C;
        text-align: center;
        color :white;
    }
    .wrapper-downSide2
    {
        color :#E7AB3C;
        font-size: 27px;
    }
    .wrapper-downSide1
    {
        
        font-size: 27px;
    }
    


</style>
<body>

<div class="container col-md-8 col-md-offset-2 col-xs-12">
	<%@include file="Header.jsp" %>
	 
	 <div class="wrapper-container">
	 <%
         int cpt =1;
     
        
   				 %>
	 
		<c:forEach items="${model.listeProduit }" var="p">
        <div class="wrapper">
            <div class="wrapper-topSide">
                <div class="wrapper-topSide-left">PROMO</div>
                <div class="wrapper-topSide-right"><a href="Vote.asp?id=${p.id}"><i class="far fa-heart"></i></a> <i class="fas fa-chevron-left"></i>${p.nbrVote} <i class="fas fa-chevron-right"></i></div>
    
            </div>
            <div class="wrapper-midSide">
                <img src="Images/${p.urlImage}"  width="290" height="290"alt="">
    
            </div>
            <div class="wrapper-downSide1">
                <p>${ p.intitule}</p>
    
            </div>
            <div class="wrapper-downSide2">
                <p>${p.prix}</p>
            </div>
    
        </div>
         <%
         
         
         if(cpt % 3 ==0)
         {
        	 %>
        	 <div class="break"></div>
        	 <% 
         }
         cpt++;
        
   				 %>
       
        </c:forEach>
      </div>
	
	</div>
	<%@include file="Footer.jsp" %>

</body>
</html>