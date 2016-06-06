<%-- 
    Document   : historique
    Created on : 6 juin 2016, 16:20:17
    Author     : user
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN" "http://www.w3.org/TR/REC-html40/loose.dtd">
<html>
	<head>
    	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    	<%@ include file="/WEB-INF/css.jsp" %>
    	<title>Historique</title>
	</head>
	<body>
   	 
<%
      	String var= (String) session.getAttribute("utilisateur");
      	 
        	if (var != null) { %>  
                	<%@ include file="/WEB-INF/header_connecte.jsp" %>
             	<%  }else{ %>
                	<%@ include file="/WEB-INF/header_guest.jsp" %>
            	<% } %>

</br></br>
    
    	<h1>Historique</h1>
    	<table>
        	<tr>
            	<th>Taches</th>
            	<th>Montants</th>
            	<th>Date</th>
        	</tr>
        	<c:forEach items="${taches}" var="taches">
            	<tr>
                	<td>${taches.nom}</td><td>${taches.montant}</td><td>${taches.date}</td>
            	</tr>
        	</c:forEach>
    	</table>
	</body>
</html>
