<%@ page language="java" contentType="text/html; charset=windows-1256" pageEncoding="windows-1256"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<link rel="stylesheet" type="text/css"
href="webjars/bootstrap/4.3.1/css/bootstrap.min.css" />
<c:url value="/css/main.css" var="jstlCss" />
<link href="${jstlCss}" rel="stylesheet" />
<script type="text/javascript" src="webjars/bootstrap/4.3.1/js/bootstrap.min.js"></script>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=windows-1256">
<title>Modifier un Etudiant</title>
</head>
<body>
	<div class="container mt-5">
		<div class="card-body">
			<form action="updateEtudiant" method="post">
				<div class="form-group">
					<label class="control-label">ID Etudiant :</label>
					<input type="text" name="id" value="${e.id}" readonly class="form-control">
				</div>
				<div class="form-group">
					<label class="control-label">Nom Etudiant :</label>
					<input type="text" name="nom" value="${e.nom}" class="form-control">
				</div>
				<div class="form-group">
					<label class="control-label">Moyenne Etudiant :</label>
					<input type="text" name="moy" value="${e.moy}" class="form-control">
				</div>
				<div class="form-group">
					<label class="control-label"> Date Naissance :</label>

					 <fmt:formatDate pattern="yyyy-MM-dd" value="${e.date}"
					var="formatDate" />
					 <input type="date" name="date" value="${formatDate}" class="form-control"></input>
				 </div>
				<input type="submit" value="Modifier" class="btn btn-primary">
				</pre>
			</form>
<br/>
<br/>
<a href="ListeProduits">Liste Etudiants</a>
</body>
</html>